
package baitapgiaodien; 

import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.Socket; 
import java.net.UnknownHostException; 


public class Clientc { 
	static String tong;
    public static void main(String []args) throws IOException 
    { 
        // khoi tao 3 bien kieu String 
        String a,b;
        //tao socket de ket noi toi server 
        Socket ClientSocket = new Socket("Localhost", 1005); 
        //thong bao da ket noi thanh cong 
        System.out.println("Connected to server"); 
        //tao luong nhap du lieu tu ban phim 
        DataInputStream inFromUser = new DataInputStream(System.in); 
        //tao luong nhan du lieu tu server 
        DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream()); 
        //tao luong gui du lieu len server 
        DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream()); 
        // nhap lieu tu ban phim 
        try{ 
            System.out.println("nhap vao so a :"); 
            a=inFromUser.readLine(); 
            System.out.println("nhap vao so b :"); 
             b=inFromUser.readLine(); 
            // gui len server 
             outToServer.writeBytes(a+'\n'); 
            outToServer.writeBytes(b+'\n'); 
        }catch(UnknownHostException e) 
        { 
            System.err.println("Server Not Found"); 
            System.exit(1); 
        }catch(IOException e) 
        { 
            System.err.println("Cannot make a connection"); 
            System.exit(1); 
        } 
         
        //nhan ve tu server 
        tong=inFromServer.readLine(); 
        //in ra man hinh 
        //dong luong gui du lieu len server 
        outToServer.close(); 
        //dong luong nhan du lieu tu server 
        inFromServer.close(); 
        //dong socket client 
        ClientSocket.close(); 
    } 

} 