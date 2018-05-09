package baitapgiaodien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class client extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client frame = new client();
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
	public client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First");
		lblNewLabel.setBounds(0, 0, 82, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Second number");
		lblNewLabel_1.setBounds(0, 42, 82, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Resurt from server");
		lblNewLabel_2.setBounds(0, 84, 82, 23);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(98, -3, 166, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 39, 166, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 81, 166, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Send");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a,b,tong;
		        //tao socket de ket noi toi server 
				try {
		        Socket ClientSocket = new Socket("Localhost", 1204); 
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
		            a = textField.getText();
		            b = textField_1.getText();
		            // gui len server 
		             outToServer.writeBytes(a+'\n'); 
		            outToServer.writeBytes(b+'\n'); 
		        }catch(UnknownHostException e1) 
		        { 
		            System.err.println("Server Not Found"); 
		            System.exit(1); 
		        }catch(IOException e1) 
		        { 
		            System.err.println("Cannot make a connection"); 
		            System.exit(1); 
		        } 
		         
		        //nhan ve tu server 
		        tong=inFromServer.readLine(); 
		        textField_2.setText(tong);
		        //in ra man hinh 
		        //dong luong gui` du lieu len server 
		        outToServer.close(); 
		        //dong luong nhan du lieu tu server 
		        inFromServer.close(); 
		        //dong socket client 
		        ClientSocket.close();
		    
				}
				catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(295, 38, 131, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		btnNewButton_2.setBounds(295, 80, 131, 31);
		contentPane.add(btnNewButton_2);
	}

}
