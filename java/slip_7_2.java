import java.sql.*;


public class slip_7_2 {
    public static void main(String[] args) {
        PreparedStatement ps =null;
        ResultSet rs =null;
        Statement stmt=null;
        Connection conn=null;
        int n;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://server2/exam1","exam1","");
            if (conn==null) {
                System.out.println("Connection Failed !!!");
            }
            else
            {
                System.out.println("Connection Successfull...");
                System.out.println("...... Creating Table .....");
                ps = conn.prepareStatement("create table is not exists product (pid int primary_key,pname varchar(255) ,price varchar(100))");
                n = ps.executeUpdate();
                if (n!=0) {
                    System.out.println("Table Created successfull....\n\n");
                } else {
                    System.out.println("Table Created Failed....");
                }
                System.out.println("...... Inserting values in  Table .....");
                ps = conn.prepareStatement("insert into product (pid,pname,price) values (1,'mango','100'),(2,'apple','200'),(3,'grapes','700'),(4,'tomato','1000'),(5,'milk','200'),");
                n = ps.executeUpdate();
                if (n!=0) {
                    System.out.println("Insertion successfull....\n\n");
                } else {
                    System.out.println("Insertion Failed....");
                }

                System.out.println("....... Getting Data......");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from product");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String price = rs.getString(3);
                    System.out.println(id+"\t"+name+"\t"+price);
                }
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

