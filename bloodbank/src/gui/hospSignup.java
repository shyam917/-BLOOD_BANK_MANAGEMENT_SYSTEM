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
import sqlUtils.hosp_register;
import sqlUtils.org_registration;
public class hospSignup {

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
	
	public hospSignup(Connection con) {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(394, 72, 557, 541);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 547, 531);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField name = new JTextField();
		name.setBounds(305, 32, 122, 34);
		panel_1.add(name);
		name.setColumns(10);
		
		JTextField email = new JTextField();
		email.setBounds(305, 100, 163, 34);
		panel_1.add(email);
		email.setColumns(10);
		
		JTextField number = new JTextField();
		number.setColumns(10);
		number.setBounds(305, 164, 122, 34);
		panel_1.add(number);
		
		JTextField city = new JTextField();
		city.setColumns(10);
		city.setBounds(305, 228, 122, 27);
		panel_1.add(city);
		
		JTextField state = new JTextField();
		state.setColumns(10);
		state.setBounds(305, 281, 122, 27);
		panel_1.add(state);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = name.getText();
                String Password = password.getText();
                String Email = email.getText();
                String Number =number.getText();
                String State = state.getText(); 
                String City = city.getText();
                String Conpassword= conpassword.getText();
                if (Password.equals(Conpassword)) {
                try {
                    String query = "select * from Hospital where Hosp_name = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, Name);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Hospital already exists");
                        return;
                    }
                    query = "insert into Hospital values('" + Name + "','"
                            + Email + "','" + Number + "','" + City + "','" + State + "','" + Password + "')";
                    con.createStatement().executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Sign Up Successful");
                } catch (SQLException ae) {
                    ae.printStackTrace();
                    hosp_register createUserTable = new hosp_register(con);
                    createUserTable.createTable();
                    JOptionPane.showMessageDialog(null, "Table Created. Try Again");

                } catch (Exception ae) {
                    JOptionPane.showMessageDialog(null, "Hospital already exists");
                }
			}
                else{JOptionPane.showMessageDialog(null, "Password not same");
                }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(328, 461, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hospital Name  :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(78, 37, 152, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email  :");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(114, 105, 96, 18);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contact Number  :");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(64, 169, 146, 18);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("City  :");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(157, 230, 85, 18);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("State  :");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(157, 283, 85, 18);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Password  :");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(114, 339, 111, 21);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Confim Password  :");
		lblNewLabel_1_6_1.setForeground(Color.WHITE);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6_1.setBounds(84, 395, 158, 21);
		panel_1.add(lblNewLabel_1_6_1);
		
		conpassword = new JPasswordField();
		conpassword.setBounds(305, 394, 163, 27);
		panel_1.add(conpassword);
		
		password = new JPasswordField();
		password.setBounds(305, 338, 152, 27);
		panel_1.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\images\\bg.png"));
		lblNewLabel_2.setBounds(0, 0, 558, 531);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\images\\bg27.jpg"));
		lblNewLabel.setBounds(10, 72, 384, 525);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Hospital   Registration");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_3.setBounds(146, 21, 681, 41);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
