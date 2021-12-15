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
import java.sql.*;

public class CommonSignup {
Connection con;

	public JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public CommonSignup(Connection con) {
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
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 0, 775, 83);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("ADMIN SIGNUP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSignup adobj = new AdminSignup(con);
				adobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(240, 255, 255));
		btnNewButton_1.setBounds(24, 110, 235, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("DONOR SIGNUP");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonorSignup doobj = new DonorSignup(con);
				doobj.frame.setVisible(true);
				frame.dispose();
			}
			
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_1.setBackground(new Color(240, 255, 240));
		btnNewButton_1_1.setBounds(24, 184, 235, 39);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("RECEIVER SIGNUP");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSignup usobj = new UserSignup(con);
				usobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_2.setBackground(new Color(240, 248, 255));
		btnNewButton_1_2.setBounds(24, 280, 235, 39);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("ORGANIZATION SIGNUP");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrgSignup orobj = new OrgSignup(con);
				orobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_3.setBackground(new Color(240, 248, 255));
		btnNewButton_1_3.setBounds(24, 369, 235, 39);
		frame.getContentPane().add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("HOSPITAL SIGNUP");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospSignup hoobj = new hospSignup(con);
				hoobj.frame.setVisible(true);
				frame.dispose();
			}
			
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1_4.setBackground(new Color(240, 255, 240));
		btnNewButton_1_4.setBounds(24, 451, 235, 39);
		frame.getContentPane().add(btnNewButton_1_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\images\\bg.png"));
		lblNewLabel_1.setBounds(0, 0, 550, 548);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\images\\bg.png"));
		lblNewLabel_2.setBounds(545, 0, 240, 548);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(595, 184, 161, 64);
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
