package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;

import sqlUtils.CheckForData;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class Home {
Connection con;
String[] fields = new String[4];
	public JFrame frame;
	JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public Home(String[]fields,Connection con) {
		this.fields = fields;
		this.con = con;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 908, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 894, 108);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBounds(0, 103, 1002, 408);
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
		
		JButton btnNewButton = new JButton("Donor Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(23, 61, 128, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Receiver Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				String query = "select r_name,contact from receiver where bloodtype='"+fields[3]+"';";
                CheckForData check = new CheckForData(con);
                if (check.check_data_exist(query)){
                      
                        try{
                            String query1 = "select r_name,contact from receiver where bloodtype= ?;";
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
                                Obj[r][0] =rs.getString("r_name");
                                Obj[r][1] =rs.getString("contact");
                                r++;
 
                            
                            }
                                                  
                        }
                        
                        catch(Exception e3) {
                        	System.out.println(e3);
                        }
                  
                }

			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(186, 61, 128, 25);
		panel.add(btnNewButton_2);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("LOG OUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage homeobj = new homepage(con);
				homeobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(748, 361, 112, 31);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("NAME  : " + fields[0] );
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(57, 49, 642, 37);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone Number  : "+ fields[2]);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(57, 110, 642, 37);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Blood Group  : " + fields[3]);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(57, 169, 642, 37);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email  :" + fields[1]);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(57, 229, 642, 37);
		panel_1.add(lblNewLabel_1_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 21, 825, 300);
		panel_2.add(scrollPane);
		
		table = new JTable(Obj,clm);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(51);
		JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);
		
		
	}
}