package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import sqlUtils.org_registration;
public class OrgSignup {

	public JFrame frame;
	private JTextField name;
	private JTextField email;
	private JTextField contact;
	private JTextField city;
	private JTextField state;
	private JPasswordField password;
	private JPasswordField conpassword;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	Connection con;
	
	public OrgSignup(Connection con) {
		this.con = con;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1018, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\images\\bg22.png"));
		lblNewLabel.setBounds(0, 203, 293, 223);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(394, 72, 557, 541);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 547, 531);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		name = new JTextField();
		name.setBounds(304, 10, 122, 34);
		panel_1.add(name);
		((JTextField) name).setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
                String Password = password.getText();
                String Email = email.getText();
                String Contact =contact.getText();
                String State = state.getText(); 
                String City = city.getText();
                String Conpassword= conpassword.getText();
                if (Password.equals(Conpassword)) {
                try {
                    String query = "select * from organization where org_name = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Name);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Organization already exists");
                        return;
                    }
                    query = "insert into  organization values('" + Name + "','"
                            + Email + "','" + Contact + "','" + City + "','" + State + "','" + Password + "')";
                    con.createStatement().executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Sign Up Successful");
                } catch (SQLException ae) {
                    ae.printStackTrace();
                    org_registration createUserTable = new org_registration(con);
                    createUserTable.createTable();
                    JOptionPane.showMessageDialog(null, "Table Created. Try Again");

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Orgnisation already exists");
                }
			}
                else{JOptionPane.showMessageDialog(null, "Password not same");
                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(119, 410, 111, 44);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommonSignup coobj = new CommonSignup(con);
				coobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(330, 410, 96, 44);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Organization Name  :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(84, 10, 175, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email  :");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(134, 52, 96, 18);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contact Number  :");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(84, 115, 146, 18);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("City  :");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(145, 170, 85, 18);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("State  :");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(145, 229, 85, 18);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Password  :");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(134, 283, 111, 21);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Confim Password  :");
		lblNewLabel_1_6_1.setForeground(Color.WHITE);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6_1.setBounds(107, 331, 158, 21);
		panel_1.add(lblNewLabel_1_6_1);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(304, 54, 163, 34);
		panel_1.add(email);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(304, 110, 122, 34);
		panel_1.add(contact);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(304, 172, 122, 27);
		panel_1.add(city);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBounds(304, 231, 122, 27);
		panel_1.add(state);
		
		password = new JPasswordField();
		password.setBounds(304, 286, 152, 27);
		panel_1.add(password);
		
		conpassword = new JPasswordField();
		conpassword.setBounds(304, 334, 163, 27);
		panel_1.add(conpassword);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\images\\bg.png"));
		lblNewLabel_2.setBounds(0, 0, 558, 544);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Organization Registration");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(228, 0, 544, 62);
		frame.getContentPane().add(lblNewLabel_3);
		
	}

}
