import java.sql.*;
import java.util.*;
import java.io.*;

public class slip_22_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        int ch = 0, no, salary;
        String name;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://server2/exam1", "exam", "");
            if (conn == null) {
                System.out.println("Connection Failed !!!!");
            } else {
                System.out.println("Connection Successfull");
                while (ch != 4) {
                    System.out.println("1]Insert\n2]Update\n3]Display\n4]Exit\nEnter Your Choice : ");
                    switch (ch) {
                        case 1:
                            System.out.println("Enter Eno : ");
                            no = s.nextInt();
                            System.out.println("Enter Employee name : ");
                            name = s.next();
                            System.out.println("Enter Employee salary : ");
                            salary = s.nextInt();
                            ps = conn.prepareStatement("insert into employee values(?,?,?)");
                            ps.setInt(1, no);
                            ps.setString(2, name);
                            ps.setInt(3, salary);
                            int n = ps.executeUpdate();
                            if (n != 0) {
                                System.out.println("Records Inserted successfully...");
                            } else {
                                System.out.println("Error ..... something went wrong...");
                            }
                            break;
                        case 2:
                            System.out.println("Enter Eno to update : ");
                            no = s.nextInt();
                            System.out.println("Enter Employee name : ");
                            name = s.next();
                            System.out.println("Enter Employee salary : ");
                            salary = s.nextInt();
                            ps = conn.prepareStatement("update employee set name=?,salary=? where eno=? ");
                            ps.setString(1, name);
                            ps.setInt(3, salary);
                            ps.setInt(3, no);
                            n = ps.executeUpdate();
                            if (n != 0) {
                                System.out.println("Records Updated successfully...");
                            } else {
                                System.out.println("Error ..... something went wrong...");
                            }
                            break;
                        case 3:
                            System.out.println("Eno\tName\tSalary");
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery("select * from employee");
                            while (rs.next()) {
                                System.out.print(rs.getInt(1 + "\t"));
                                System.out.print(rs.getString(2 + "\t"));
                                System.out.print(rs.getInt(1 + "\n"));
                            }
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice !!");
                            break;
                    }
                }
            }
            conn.close();

        } catch (Exception e) {

        }
    }
}
