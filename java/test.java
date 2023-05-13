import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * test
 */
public class test extends JFrame implements ActionListener {

    JLabel eno, ename, designation, salary;
    JTextField enoTf, enameTf, designationTf, salaryTf;
    JButton button;

    test() {
        setTitle("Employee : ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new GridLayout(5,2));

        eno = new JLabel("Eno : ");
        ename = new JLabel("EName :");
        designation = new JLabel("EDesignation :");
        salary = new JLabel("ESalary :");

        enoTf = new JTextField();
        enameTf = new JTextField();
        designationTf = new JTextField();
        salaryTf = new JTextField();
        button = new JButton("Submit");

        add(eno);
        add(enoTf);
        add(ename);
        add(enameTf);
        add(designation);
        add(designationTf);
        add(salary);
        add(salaryTf);
        add(new JLabel());
        add(button);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        String eno = enoTf.getText();
        String ename = enameTf.getText();
        String designation = designationTf.getText();
        String salary = salaryTf.getText();
        Connection con = null;
        PreparedStatement ps =null;


        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://server2/exam1","exam1","");
            if (con==null) {
                System.out.println("Connection Failed");
            } else {
                System.out.println("Connection Success .....");
                ps = con.prepareStatement("insert into employee (eno,ename,designation,salary) values (?,?,?,?)");
                ps.setString(1,eno);
                ps.setString(2,ename);
                ps.setString(3,designation);
                ps.setString(4,salary);
                int   n = ps.executeUpdate();
                if (n!=0) {
                    JOptionPane.showMessageDialog(this,"Records inserted ..");
                } else {
                    JOptionPane.showMessageDialog(this,"Something went wrong !!");
                }
            }
            
            con.close();
        } catch (Exception ex) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(this,"Something went wrong !!"+ex);
        }
    }


    public static void main(String[] args) {
        test t = new test();
    }
}