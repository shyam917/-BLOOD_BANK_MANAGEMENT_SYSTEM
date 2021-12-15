package gui;

import java.awt.Color;
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
import sqlUtils.admin_register;
public class AdminSignup {

	public JFrame frame;
	private JPasswordField conpassword;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	Connection con;
	
	public AdminSignup(Connection con) {
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
		lblNewLabel.setIcon(new ImageIcon(".\\images\\admin.jpg"));
		lblNewLabel.setBounds(30, 160, 387, 390);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(394, 72, 557, 541);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 547, 531);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField name = new JTextField();
		name.setBounds(275, 108, 183, 34);
		panel_1.add(name);
		name.setColumns(10);
		
		JTextField email = new JTextField();
		email.setBounds(275, 188, 183, 34);
		panel_1.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
                String Password = password.getText();
                String Email = email.getText();
                String Conpassword= conpassword.getText();
                if (Password.equals(Conpassword)) {
                try {
                    String query = "select * from Admin where email = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Email);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Username already exists");
                        return;
                    }
                    query = "insert into Admin values('" + Name + "','"
                            + Email + "','" + Password + "')";
                    con.createStatement().executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Sign Up Successful");}
     
                   catch (SQLException ae) {
                    ae.printStackTrace();
                    admin_register createUserTable = new admin_register(con);
                    createUserTable.createTable();
                    JOptionPane.showMessageDialog(null, "Table Created. Try Again");

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Email already used");
                }
                
			}
                else{JOptionPane.showMessageDialog(null, "Password not same");
                }
                
			}
		});
		btnNewButton.setBounds(145, 459, 85, 21);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommonSignup coobj = new CommonSignup(con);
				coobj.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(275, 459, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("NAME  :");
		lblNewLabel_1.setBounds(161, 113, 85, 18);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("EMAIL  :");
		lblNewLabel_1_2.setBounds(161, 193, 69, 18);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PASSWORD  :");
		lblNewLabel_1_3.setBounds(126, 265, 116, 18);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CONFIRM PASSWORD  :");
		lblNewLabel_1_4.setBounds(45, 327, 194, 18);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_4);
		
		conpassword = new JPasswordField();
		conpassword.setBounds(275, 319, 183, 40);
		conpassword.setForeground(Color.BLACK);
		panel_1.add(conpassword);
		
		password = new JPasswordField();
		password.setBounds(275, 264, 183, 34);
		panel_1.add(password);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(".\\images\\bg.png"));
		lblNewLabel_3.setBounds(0, 0, 547, 531);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("ADMIN     REGISTRATION");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_4.setBounds(287, 10, 602, 56);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
