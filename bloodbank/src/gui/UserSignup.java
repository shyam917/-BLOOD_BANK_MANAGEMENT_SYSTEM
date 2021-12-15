package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import sqlUtils.reciever_register;
public class UserSignup {

	public JFrame frame;
	private JTextField email;
	private JTextField contact;
	private JTextField city;
	private JTextField state;
	private JTextField name;
	private JPasswordField password;
	private JPasswordField conpassword;
	private JTextField bloodgroup;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	Connection con;
	
	public UserSignup(Connection con) {
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
		lblNewLabel.setIcon(new ImageIcon(".\\images\\bg7.png"));
		lblNewLabel.setBounds(56, 202, 208, 223);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(394, 72, 557, 541);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 557, 531);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		email = new JTextField();
		email.setBounds(307, 58, 161, 34);
		panel_1.add(email);
		email.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(305, 173, 122, 34);
		panel_1.add(contact);
		contact.setColumns(10);
		
		city = new JTextField();
		city.setBounds(305, 228, 122, 34);
		city.setColumns(10);
		panel_1.add(city);
		
		state = new JTextField();
		state.setBounds(305, 281, 122, 27);
		state.setColumns(10);
		panel_1.add(state);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
                String Password = password.getText();
                String Email = email.getText();
                String Bloodgroup = bloodgroup.getText();
                String Contact =contact.getText();
                String State = state.getText(); 
                String City = city.getText();
                String Conpassword= conpassword.getText();
                if (Password.equals(Conpassword)) {
				try {
                    String query = "select * from receiver where email = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Email);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Email already exists");
                        return;
                    }
                    query = "insert into receiver values('" + Name + "','"
                            + Email + "','" + Bloodgroup+ "','" + Contact + "','" + City + "','" + State + "','" + Password + "')";
                    con.createStatement().executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Sign Up Successful");
                } catch (SQLException ae) {
                    ae.printStackTrace();
                   reciever_register reciever = new reciever_register(con);
                    reciever.createTable();
                    JOptionPane.showMessageDialog(null, "Table Created. Try Again");

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "User already exists");
                }
			}
                else{JOptionPane.showMessageDialog(null, "Password not same");
                }
			}
		});
		btnNewButton.setBounds(140, 480, 99, 41);
		btnNewButton.setFont(new Font("Nirmala UI Semilight", Font.BOLD | Font.ITALIC, 18));
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email  :");
		lblNewLabel_1_2.setBounds(109, 63, 96, 18);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contact Number  :");
		lblNewLabel_1_3.setBounds(98, 174, 146, 18);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("City  :");
		lblNewLabel_1_4.setBounds(109, 233, 85, 18);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("State  :");
		lblNewLabel_1_5.setBounds(109, 283, 85, 18);
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Password  :");
		lblNewLabel_1_6.setBounds(109, 335, 111, 21);
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Confim Password  :");
		lblNewLabel_1_6_1.setBounds(82, 407, 158, 21);
		lblNewLabel_1_6_1.setForeground(Color.WHITE);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_6_1);
		
		JLabel lblNewLabel_1 = new JLabel("Name  :");
		lblNewLabel_1.setBounds(109, 10, 122, 18);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(305, 5, 163, 34);
		name.setColumns(10);
		panel_1.add(name);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(339, 480, 99, 41);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommonSignup coobj = new CommonSignup(con);
				coobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Nirmala UI Semilight", Font.BOLD | Font.ITALIC, 18));
		panel_1.add(btnBack);
		
		password = new JPasswordField();
		password.setBounds(305, 334, 152, 27);
		panel_1.add(password);
		
		conpassword = new JPasswordField();
		conpassword.setBounds(307, 406, 152, 27);
		panel_1.add(conpassword);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Blood Group  :");
		lblNewLabel_1_2_1.setBounds(98, 117, 122, 18);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_2_1);
		
		bloodgroup = new JTextField();
		bloodgroup.setBounds(305, 112, 122, 34);
		bloodgroup.setColumns(10);
		panel_1.add(bloodgroup);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\images\\bg.png"));
		lblNewLabel_2.setBounds(0, 0, 557, 541);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RECEIVER  REGISTRATION");
		lblNewLabel_3.setFont(new Font("Wide Latin", Font.PLAIN, 28));
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(110, 10, 746, 52);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
