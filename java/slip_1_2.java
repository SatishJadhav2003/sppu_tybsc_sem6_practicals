
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class slip_1_2 extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4;
    private JTextField textField1, textField2, textField3, textField4;
    private JButton submitButton;

    public slip_1_2() {
        setTitle("Employee Details");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        label1 = new JLabel("Eno");
        label2 = new JLabel("EName");
        label3 = new JLabel("Designation");
        label4 = new JLabel("Salary");

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(label1);
        add(textField1);
        add(label2);
        add(textField2);
        add(label3);
        add(textField3);
        add(label4);
        add(textField4);
        add(new JLabel()); // Empty label for spacing
        add(submitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String eno = textField1.getText();
        String ename = textField2.getText();
        String designation = textField3.getText();
        String salary = textField4.getText();

        // Store the details in the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username",
                    "password");

            String query = "INSERT INTO employee (Eno, EName, Designation, Salary) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, eno);
            statement.setString(2, ename);
            statement.setString(3, designation);
            statement.setString(4, salary);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee details stored successfully!");

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        slip_1_2 s =new slip_1_2();
    }

}
