import java.sql.*;
import java.io.*;

public class slip_11_2 {
    public static void main(String[] args) {

        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        ResultSetMetaData metadata = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://server2/exam1", "exam1", "");
            if (conn == null) {
                System.out.println("Connection Failed");
            } else {
                System.out.println("Connection Successfull");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from donor");
                metadata = rs.getMetaData();
                int n = metadata.getColumnCount();
                for (int i = 0; i < n; i++) {
                    System.out.println("Column name : " + metadata.getColumnName(i));
                    System.out.println("Column Type : " + metadata.getColumnTypeName(i));
                    System.out.println("Column Display size : " + metadata.getColumnDisplaySize(i));
                }
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
