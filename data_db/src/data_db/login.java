package data_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 678, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(228, 25, 165, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(53, 110, 55, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		TextField t1 = new TextField();
		t1.setBounds(149, 113, 130, 22);
		frame.getContentPane().add(t1);
		
		JLabel lb1 = new JLabel("Name");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb1.setBounds(62, 299, 177, 33);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb2.setBounds(62, 363, 196, 33);
		frame.getContentPane().add(lb2);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sn=t1.getText();
				int sno=Integer.parseInt(sn);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec4","root","mrec");
					String q="select name,marks from student4 where sno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1,sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name:"+rs.getString(1));
					lb2.setText("Marks:"+rs.getString(2));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(131, 193, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
