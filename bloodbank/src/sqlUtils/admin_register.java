package sqlUtils;

import java.sql.*;

public class admin_register {
    Connection conn = null;
    public admin_register(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "create table Admin(org_name varchar(50)not null ,email varchar(255) primary key,contact bigint,city varchar(20), state varchar(20), password varchar(20));";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}