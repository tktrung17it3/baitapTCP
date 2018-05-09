package baitapgiaodien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class server extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server frame = new server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String so1,so2,so3; 
		        int tong; 
		        // tao server socket 
		        try {
		        ServerSocket server = new ServerSocket(1204); 
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
		        outToClient.writeBytes(so3); 
		        //dong luong nhan du lieu tu client 
		        inFromClient.close(); 
		        //dong luong gui du lieu ve client 
		        outToClient.close(); 
		        //dong server socket 
		        server.close();
		        }
		        catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(60, 79, 278, 31);
		contentPane.add(btnNewButton);
	}
}
