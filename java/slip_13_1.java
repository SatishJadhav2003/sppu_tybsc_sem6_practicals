import java.sql.*;

public class slip_13_1 {
    public static void main(String[] args) throws Exception {
        // Database credentials
Connection conn;
        try{
            Class.forName("org.postgresql.Driver");
             conn = DriverManager.getConnection("jdbc:postgresql://server2/exam1","exam1","");
            DatabaseMetaData metaData = conn.getMetaData();

            // Print database information
            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());

            // List all tables
            ResultSet tables = metaData.getTables(null, null, "%", null);
            System.out.println("Tables in the database:");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
