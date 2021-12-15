package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import sqlUtils.donor_register;
import javax.swing.*;
public class DonorSignup {

	public JFrame frame;
	private JTextField address;
	private JTextField age;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	Connection con;
	private JTextField sex;
	
	public DonorSignup(Connection con) {
		this.con = con;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 1018, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 123, 398, 453);
		lblNewLabel.setIcon(new ImageIcon(".\\images\\bg5.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(394, 72, 536, 528);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 547, 531);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField name = new JTextField();
		name.setBounds(105, 56, 122, 34);
		panel_1.add(name);
		name.setColumns(10);
		
		JTextField bloodgroup = new JTextField();
		bloodgroup.setBounds(164, 119, 122, 34);
		panel_1.add(bloodgroup);
		bloodgroup.setColumns(10);
		
		JTextField number = new JTextField();
		number.setBounds(164, 178, 122, 34);
		number.setColumns(10);
		panel_1.add(number);
		
		JTextField email = new JTextField();
		email.setBounds(105, 252, 181, 27);
		email.setColumns(10);
		panel_1.add(email);
		
		JTextField password = new JTextField();
		password.setBounds(142, 304, 144, 27);
		password.setColumns(10);
		panel_1.add(password);
		
		JTextField conpassword = new JTextField();
		conpassword.setBounds(184, 355, 144, 27);
		conpassword.setColumns(10);
		panel_1.add(conpassword);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
                String Password = password.getText();
                String Email = email.getText();
                String Bloodgroup = bloodgroup.getText();
                String Sex =sex.getText();
                String Address =address.getText();
                String Age = age.getText(); 
                String Number = number.getText();
                String Conpassword= conpassword.getText();
                if (Password.equals(Conpassword)) {
                    try {
                    	
                        String query = "select * from Donor where Name = ?";
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, Name);
                        ResultSet rs = pst.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        }
                        query = "insert into Donor values('" + 	Name + "','" 
                                + Sex+ "','" + Address + "','" + Email+ "','" +Number+ "','"+ Age+ "','"+ Bloodgroup+ "','"+Password + "');";
                        con.createStatement().executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Sign Up Successful");
                    } catch (SQLException ae) {
                        ae.printStackTrace();
                        donor_register donor = new donor_register(con);
                       donor.createTable();
                        JOptionPane.showMessageDialog(null, "Table Created. Try Again");

                    } catch (Exception ae) {
                        JOptionPane.showMessageDialog(null, "User already exists");
                    }
                
                }
                else{JOptionPane.showMessageDialog(null, "Password not same");
                }
                

            }
        });
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(105, 459, 125, 41);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("NAME  :");
		lblNewLabel_1.setBounds(10, 61, 85, 18);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Blood Group  :");
		lblNewLabel_1_2.setBounds(10, 124, 122, 18);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mobile Number  :");
		lblNewLabel_1_3.setBounds(10, 183, 144, 18);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email  :");
		lblNewLabel_1_4.setBounds(10, 254, 85, 18);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password  :");
		lblNewLabel_1_5.setBounds(10, 302, 103, 27);
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Confirm Password  :");
		lblNewLabel_1_6.setBounds(10, 357, 181, 18);
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("SEX  :");
		lblNewLabel_1_7.setBounds(275, 66, 85, 18);
		lblNewLabel_1_7.setForeground(Color.WHITE);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Address  :");
		lblNewLabel_1_3_1.setBounds(311, 188, 85, 18);
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_3_1);
		
		address = new JTextField();
		address.setBounds(392, 185, 122, 126);
		address.setColumns(10);
		panel_1.add(address);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Age  :");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4_1.setBounds(309, 135, 67, 18);
		panel_1.add(lblNewLabel_1_4_1);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(364, 126, 75, 34);
		panel_1.add(age);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommonSignup coobj = new CommonSignup(con);
				coobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("MS Gothic", Font.BOLD | Font.ITALIC, 20));
		btnBack.setBounds(324, 459, 125, 41);
		panel_1.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\images\\bg.png"));
		lblNewLabel_2.setBounds(0, 0, 537, 531);
		panel_1.add(lblNewLabel_2);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(344, 63, 75, 34);
		panel_1.add(sex);
		
		JLabel lblNewLabel_3 = new JLabel("Donor  Signup");
		lblNewLabel_3.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_3.setBounds(305, 0, 373, 62);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
