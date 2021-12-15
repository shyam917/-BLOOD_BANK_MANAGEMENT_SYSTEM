package sqlUtils;

import java.sql.*;

public class org_registration {
    Connection conn = null;
    public org_registration(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "create table organization(org_name varchar(50)not null primary key,email varchar(255),contact bigint,city varchar(20), state varchar(20), password varchar(20));";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}