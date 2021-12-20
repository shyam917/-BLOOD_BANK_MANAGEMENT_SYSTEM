package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.Scrollable;

import java.awt.event.ActionListener;
import java.beans.Statement;
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
	private JTable table,table2,table3,table4;
	
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
		tabbedPane.setBounds(0, 104, 1005, 417);
		frame.getContentPane().add(tabbedPane);
		
		String Obj[][]= {
				{"No DATA","No DATA","No DATA","No DATA","No DATA","No DATA","No DATA"},
				{null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null},
				};
		String clm[]= {"Name","age","bloodtype","Email","sex","address", "phone"};
		
		String Obj2[][]= {
				{"No DATA","No DATA","No DATA","No DATA","No DATA","No DATA"},
				{null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
                {null,null,null,null,null,null},
				};
		String clm2[]= {"Name","Email","Bloodtype","Contact","City","State"};
		
		String Obj3[][]= {
				{"No DATA","No DATA","No DATA","No DATA","No DATA"},
				{null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
				};
		String clm3[]= {"Name","Email","Contact","City","State"};
		
		
		String Obj4[][]= {
				{"No DATA","No DATA","No DATA","No DATA","No DATA"},
				{null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
                {null,null,null,null,null},
				};
		String clm4[]= {"Name","Email","Contact","City","State"};
		
		
		JButton btnNewButton_2 = new JButton("Admin Info");
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
		
		JButton btnNewButton_2_1 = new JButton("Donor Info");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				
				String query = "select * from donor;";
                CheckForData check = new CheckForData(con);
                if (check.check_data_exist(query)){
                      
                        try{
                            String query1 = "select * from donor;";
                            PreparedStatement pst = con.prepareStatement(query1);
                            ResultSet rs = pst.executeQuery();
                            int r = 0;
                            for (int i = 0; i < Obj.length; i++) {
                                for (int j = 0; j < Obj[i].length; j++) {
                                    Obj[i][j] = "";
                                }
                            }
                            
                            while (rs.next()) {
                                Obj[r][0] =rs.getString("name");
                                Obj[r][1] =rs.getString("age");
                                Obj[r][2] =rs.getString("bloodtype");
                                Obj[r][3] =rs.getString("email");
                                Obj[r][4] =rs.getString("sex");
                                Obj[r][5] = rs.getString("address");
                                Obj[r][6] = rs.getString("phone");
                                r++;
 
                            
                            }
                                                  
                        }
                        
                        catch(Exception e3) {
                        	System.out.println(e3);
                        }

                }
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(181, 64, 128, 25);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Receiver Info");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				String query = "select * from receiver;";
                CheckForData check = new CheckForData(con);
                if (check.check_data_exist(query)){
                      
                        try{
                            String query1 = "select * from receiver;";
                            PreparedStatement pst = con.prepareStatement(query1);
                            ResultSet rs = pst.executeQuery();
                            int r = 0;
                            for (int i = 0; i < Obj3.length; i++) {
                                for (int j = 0; j < Obj3[i].length; j++) {
                                    Obj3[i][j] = "";
                                }
                            }
                            
                            if(r==0)
                            { Obj2[r][0] ="Name";
                            Obj2[r][1] ="Email";
                            Obj2[r][2] ="Bloodtype";
                            Obj2[r][3] ="Contact";
                            Obj2[r][4] ="City";
                            Obj2[r][5] ="State";
                            r++;
                            }
                            
                            while (rs.next()) {
                            
                                Obj2[r][0] =rs.getString("r_name");
                                Obj2[r][1] =rs.getString("email");
                                Obj2[r][2] =rs.getString("bloodtype");
                                Obj2[r][3] =rs.getString("contact");
                                Obj2[r][4] =rs.getString("city");
                                Obj2[r][5] = rs.getString("state");
                                r++;
 
                            
                            }
                                                  
                        }
                        
                        catch(Exception e3) {
                        	System.out.println(e3);
                        }
                  
                }
			}
		});
		btnNewButton_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2_2.setBackground(Color.WHITE);
		btnNewButton_2_2.setBounds(321, 64, 128, 25);
		panel.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Organization Info");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				String query = "select * from organization;";
                CheckForData check = new CheckForData(con);
                if (check.check_data_exist(query)){
                      
                        try{
                            String query1 = "select * from organization;";
                            PreparedStatement pst = con.prepareStatement(query1);
                            ResultSet rs = pst.executeQuery();
                            int r = 0;
                            for (int i = 0; i < Obj4.length; i++) {
                                for (int j = 0; j < Obj4[i].length; j++) {
                                    Obj4[i][j] = "";
                                }
                            }
                            
                            if(r==0)
                            { Obj4[r][0] ="Name";
                            Obj4[r][1] ="Email";
                            Obj4[r][2] ="Contact";
                            Obj4[r][3] ="City";
                            Obj4[r][4] ="State";
                            r++;
                            }
                            
                            while (rs.next()) {
                            
                                Obj4[r][0] =rs.getString("org_name");
                                Obj4[r][1] =rs.getString("email");
                                Obj4[r][2] =rs.getString("contact");
                                Obj4[r][3] =rs.getString("city");
                                Obj4[r][4] = rs.getString("state");
                                r++;
 
                            
                            }
                                                  
                        }
                        
                        catch(Exception e3) {
                        	System.out.println(e3);
                        }
                }
			}
			
		});
		btnNewButton_2_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2_3.setBackground(Color.WHITE);
		btnNewButton_2_3.setBounds(473, 64, 160, 25);
		panel.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_4 = new JButton("Hospital Info");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				String query = "select * from hospital;";
                CheckForData check = new CheckForData(con);
                if (check.check_data_exist(query)){
                      
                        try{
                            String query1 = "select * from hospital;";
                            PreparedStatement pst = con.prepareStatement(query1);
                            ResultSet rs = pst.executeQuery();
                            int r = 0;
                            for (int i = 0; i < Obj3.length; i++) {
                                for (int j = 0; j < Obj3[i].length; j++) {
                                    Obj3[i][j] = "";
                                }
                            }
                            
                            if(r==0)
                            { Obj3[r][0] ="Name";
                            Obj3[r][1] ="Email";
                            Obj3[r][2] ="Contact";
                            Obj3[r][3] ="City";
                            Obj3[r][4] ="State";
                            r++;
                            }
                            
                            while (rs.next()) {
                            
                                Obj3[r][0] =rs.getString("hosp_name");
                                Obj3[r][1] =rs.getString("email");
                                Obj3[r][2] =rs.getString("contact_no");
                                Obj3[r][3] =rs.getString("city");
                                Obj3[r][4] = rs.getString("state");
                                r++;
 
                            
                            }
                                                  
                        }
                        
                        catch(Exception e3) {
                        	System.out.println(e3);
                        }
                }
			}
			
		});
		btnNewButton_2_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2_4.setBackground(Color.WHITE);
		btnNewButton_2_4.setBounds(663, 64, 128, 25);
		panel.add(btnNewButton_2_4);
		
		
		
		JPanel AdminTab = new JPanel();
		tabbedPane.addTab("Admin", null, AdminTab, null);
		AdminTab.setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("LOG OUT");
		btnNewButton_1.setBounds(748, 361, 112, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage homeobj = new homepage(con);
				homeobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		AdminTab.setLayout(null);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		AdminTab.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email  : " + email);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(89, 137, 486, 37);
		AdminTab.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1 = new JLabel("NAME  : "+fields);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(89, 79, 452, 37);
		AdminTab.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(268, 79, 112, 37);
		AdminTab.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_5.setBounds(268, 137, 112, 37);
		AdminTab.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("");
		lblNewLabel_1_6.setForeground(Color.BLACK);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBackground(Color.WHITE);
		lblNewLabel_1_6.setBounds(268, 203, 112, 37);
		AdminTab.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("");
		lblNewLabel_1_7.setForeground(Color.BLACK);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_7.setBackground(Color.WHITE);
		lblNewLabel_1_7.setBounds(268, 270, 112, 37);
		AdminTab.add(lblNewLabel_1_7);
		
		JPanel DonorTab = new JPanel();
		tabbedPane.addTab("Donor", null, DonorTab, null);
		DonorTab.setLayout(null);
		
		
		
		JPanel ReceiverTab = new JPanel();
		tabbedPane.addTab("Receiver", null, ReceiverTab, null);
		
		JPanel OrganizationTab = new JPanel();
		tabbedPane.addTab("Org", null, OrganizationTab, null);
		
		JPanel HospitalTab = new JPanel();
		tabbedPane.addTab("Hosp", null, HospitalTab, null);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 21, 825, 300);
		panel_2.add(scrollPane);
		
		
		
		table = new JTable(Obj,clm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);
		
		DonorTab.add(scrollPane);
		
		
		table2 = new JTable(Obj2,clm2);
		table2.getColumnModel().getColumn(0).setPreferredWidth(200);
		table2.getColumnModel().getColumn(1).setPreferredWidth(200);
		table2.getColumnModel().getColumn(1).setMinWidth(51);
		ReceiverTab.add(table2);
		
		table3 = new JTable(Obj3,clm3);
		table3.getColumnModel().getColumn(0).setPreferredWidth(200);
		table3.getColumnModel().getColumn(1).setPreferredWidth(200);
		table3.getColumnModel().getColumn(1).setMinWidth(51);
		HospitalTab.add(table3);
		
		table4 = new JTable(Obj4,clm4);
		table4.getColumnModel().getColumn(0).setPreferredWidth(200);
		table4.getColumnModel().getColumn(1).setPreferredWidth(200);
		table4.getColumnModel().getColumn(1).setMinWidth(51);
		OrganizationTab.add(table4);
	}
}