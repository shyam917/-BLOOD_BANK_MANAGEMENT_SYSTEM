package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class CommonLogin {
Connection con;
	public JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public CommonLogin(Connection con) {
	this.con = con;
		initialize();
	
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BLOOD  BANK  \r\nMANAGEMENT  \r\nSYSTEM");
		lblNewLabel.setBounds(10, 0, 775, 83);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("ADMIN LOGIN");
		btnNewButton_1.setBounds(24, 110, 235, 39);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin aobj = new AdminLogin(con);
				aobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("DONOR LOGIN");
		btnNewButton_1_1.setBounds(24, 184, 235, 39);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage dobj = new LoginPage(con);
				dobj.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBackground(new Color(240, 255, 240));
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("RECEIVER LOGIN");
		btnNewButton_1_2.setBounds(24, 280, 235, 39);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin uobj = new UserLogin(con);
				uobj.frame.setVisible(true);
				frame.dispose();
			}
			
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_2.setBackground(new Color(240, 248, 255));
		frame.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("ORGANIZATION LOGIN");
		btnNewButton_1_3.setBounds(24, 369, 235, 39);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrgLogin oobj = new OrgLogin(con);
				oobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_3.setBackground(new Color(240, 248, 255));
		frame.getContentPane().add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("HOSPITAL LOGIN");
		btnNewButton_1_4.setBounds(24, 451, 235, 39);
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospLogin hobj = new HospLogin(con);
				hobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_4.setBackground(new Color(240, 255, 240));
		frame.getContentPane().add(btnNewButton_1_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 550, 548);
		lblNewLabel_1.setIcon(new ImageIcon(".\\images\\bg.png"));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(545, 0, 240, 548);
		lblNewLabel_2.setIcon(new ImageIcon(".\\images\\bg.png"));
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(599, 184, 160, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage homeobj = new homepage(con);
				homeobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(0, 10, 160, 51);
		panel.add(btnNewButton);
	}
}
