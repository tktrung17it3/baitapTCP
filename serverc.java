/* 
 * chuong trinh tinh tong 2 so kieu integer tu Client gui len server 
 */ 

package baitapgiaodien; 

import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 

/** 
 * 
 * @author Nguyen Anh Tuan 
 */ 
public class serverc { 
    public static void main(String []args) throws IOException 
    { 
        String so1,so2,so3; 
        int tong; 
        // tao server socket 
        ServerSocket server = new ServerSocket(1005); 
        System.out.println("Server is now already"); 
        //tao 1 socket do ket noi tu client toi server 
        Socket connectionSocket = server.accept(); 
        //tao luong nhan du lieu tu client 
        DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream()); 
        // tao luong gui du lieu toi client 
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
        // truyen du lieu tu client vao 2 bien so1 va so2 
        so1 = inFromClient.readLine(); 
        so2 = inFromClient.readLine(); 
        //ep so1 va so2 tu kieu String sang kieu Integer 
        int a = Integer.parseInt(so1); 
        int b = Integer.parseInt(so2); 
        //tinh tong a + b 
        tong = a + b; 
        //ep tong 2 so a+b sang kieu String 
        so3 = String.valueOf(tong); 
        //gui so3 ve client 
        outToClient.writeBytes(so3+'\n'); 
        //dong luong nhan du lieu tu client 
        inFromClient.close(); 
        //dong luong gui du lieu ve client 
        outToClient.close(); 
        //dong server socket 
        server.close(); 
    } 

} 