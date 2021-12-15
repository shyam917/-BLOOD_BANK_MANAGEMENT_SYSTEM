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

public class receiver_info {
Connection con;
String[] fields = new String[4];
	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public receiver_info(String[]fields,Connection con) {
		this.fields = fields;
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
		
		String Obj[][]= {
				{"No DATA","No DATA"},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null},
				{null,null}
				};
		String clm[]= {"Name","Phone Number"};
		
		JButton reciver_info = new JButton("Donor Info");
		reciver_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				String query = "select name,phone from Donor where bloodtype='"+fields[3]+"';";
                CheckForData check = new CheckForData(con);
                if (check.check_data_exist(query)){
                      
                        try{
                            String query1 = "select name,phone from Donor where bloodtype= ?;";
                            PreparedStatement pst = con.prepareStatement(query1);
                            pst.setString(1, fields[3]);
                            ResultSet rs = pst.executeQuery();
                            int r = 0;
                            for (int i = 0; i < Obj.length; i++) {
                                for (int j = 0; j < Obj[i].length; j++) {
                                    Obj[i][j] = "";
                                }
                            }
                            
                            while (rs.next()) {
                                Obj[r][0] =rs.getString("name");
                                Obj[r][1] =rs.getString("phone");
                                r++;
 
                            
                            }
                                                  
                        }
                        
                        catch(Exception e3) {
                        	System.out.println(e3);
                        }
                  
                }
			}
		});
		reciver_info.setBackground(Color.WHITE);
		reciver_info.setFont(new Font("Times New Roman", Font.BOLD, 14));
		reciver_info.setBounds(188, 64, 128, 25);
		panel.add(reciver_info);
		
		JButton btnNewButton_2 = new JButton("Receiver Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone Number : " +  fields[2]);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(89, 137, 486, 37);
		name.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Blood Group : " +  fields[3]);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(89, 203, 452, 37);
		name.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email  : " + fields[1]);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(89, 270, 486, 37);
		name.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1 = new JLabel("NAME  : " + fields[0]);
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
		
		
		table = new JTable(Obj,clm);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(51);
		JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);
		
	}
}