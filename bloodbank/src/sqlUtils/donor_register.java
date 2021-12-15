package sqlUtils;

import java.sql.*;

public class donor_register {
    Connection conn = null;
    public donor_register(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE Donor(\r\n"
            		+ "Name VARCHAR( 50 ) NOT NULL,\r\n"
            		+ "sex VARCHAR( 10 ) not null,\r\n"
            		+ "address VARCHAR( 60 ) not null,\r\n"
            		+ "email VARCHAR( 100 )unique not null,\r\n"
            		+ "phone bigint unique not null,\r\n"
            		+ "age int not null,\r\n"
            		+ "bloodType varchar (3)NOT NULL ,\r\n"
            		+ "password varchar(20)NOT null,\r\n"
            		+ "PRIMARY KEY ( email )\r\n"
            		+ ");";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}