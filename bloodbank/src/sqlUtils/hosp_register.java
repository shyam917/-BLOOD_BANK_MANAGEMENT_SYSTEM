package sqlUtils;

import java.sql.*;

public class hosp_register {
    Connection conn = null;
    public hosp_register(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "create table Hospital (Hosp_name varchar(100)primary key, Email varchar(80), Contact_No bigint , City varchar(30), State varchar(30), password varchar(20));";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}