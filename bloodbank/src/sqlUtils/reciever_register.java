package sqlUtils;

import java.sql.*;

public class reciever_register {
    Connection conn = null;
    public reciever_register(Connection conn) {
        this.conn = conn;
    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "create table reciever(r_name varchar(50)not null ,email varchar(255) primary key,bloodType varchar(3),contact bigint,city varchar(20), state varchar(20), password varchar(20));";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}