package gui;

import java.sql.Connection;
import sqlUtils.ConnectDB;

public class driver {
	public static void main(String[] args) {
	String jdbcURL = "jdbc:postgresql://localhost:5432/BloodBank";
    String username = "postgres";
    String password = "Shyam123$";
    ConnectDB connectDB = new ConnectDB(username, password, jdbcURL);
     Connection con = connectDB.getConnection();
     
			try {
				homepage window = new homepage(con);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			};
}
}