package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import sqlUtils.CheckForData;

public class Admindata {
Connection con;
String fields = "", email;
	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public Admindata(String username,String email ,Connection con) {
		this.fields = username;
		this.email = email;
		this.con = con;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 944, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 925, 108);
		panel.setBackground(Color.RED);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		

		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBounds(0, 104, 1056, 417);
		frame.getContentPane().add(tabbedPane);
		
		
		JButton btnNewButton_2 = new JButton("Admin Info");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBounds(29, 64, 128, 25);
		panel.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 121, 882, 400);
		panel.add(panel_2);
		
		
		
		JPanel name = new JPanel();
		tabbedPane.addTab("New tab", null, name, null);
		name.setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("LOG OUT");
		btnNewButton_1.setBounds(748, 361, 112, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage homeobj = new homepage(con);
				homeobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		name.setLayout(null);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		name.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email  : " + email);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(89, 137, 486, 37);
		name.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1 = new JLabel("NAME  : "+fields);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(89, 79, 452, 37);
		name.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(268, 79, 112, 37);
		name.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_5.setBounds(268, 137, 112, 37);
		name.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("");
		lblNewLabel_1_6.setForeground(Color.BLACK);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBackground(Color.WHITE);
		lblNewLabel_1_6.setBounds(268, 203, 112, 37);
		name.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("");
		lblNewLabel_1_7.setForeground(Color.BLACK);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7.setBackground(Color.WHITE);
		lblNewLabel_1_7.setBounds(268, 270, 112, 37);
		name.add(lblNewLabel_1_7);
		
		JPanel donor_info = new JPanel();
		tabbedPane.addTab("", null, donor_info, null);
		donor_info.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 21, 890, 300);
		donor_info.add(scrollPane);
		
		
	}
}