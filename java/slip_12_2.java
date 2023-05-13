
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class slip_12_2 extends JFrame {

     JTable table;

    public slip_12_2() {
        setTitle("Project Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create a table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Project ID");
        model.addColumn("Project Name");
        model.addColumn("Project Description");
        model.addColumn("Project Status");

        // Create the table
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);

        insertValues(model);

        setVisible(true);
    }

     void insertValues(DefaultTableModel model) {
        // Establish a database connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Create the PROJECT table if it doesn't exist
            Statement createTableStmt = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS PROJECT (" +
                    "project_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "project_name VARCHAR(255), " +
                    "project_description VARCHAR(255), " +
                    "project_status VARCHAR(50))";
            createTableStmt.executeUpdate(createTableQuery);

            // Insert values into the PROJECT table
            Statement insertStmt = connection.createStatement();
            String insertQuery = "INSERT INTO PROJECT (project_name, project_description, project_status) VALUES " +
                    "('Project 1', 'Description 1', 'Status 1')," +
                    "('Project 2', 'Description 2', 'Status 2')," +
                    "('Project 3', 'Description 3', 'Status 3')";
            insertStmt.executeUpdate(insertQuery);

            // Retrieve data from the PROJECT table
            Statement selectStmt = connection.createStatement();
            String selectQuery = "SELECT * FROM PROJECT";
            ResultSet resultSet = selectStmt.executeQuery(selectQuery);

            // Iterate over the result set and add rows to the table model
            while (resultSet.next()) {
                int projectId = resultSet.getInt("project_id");
                String projectName = resultSet.getString("project_name");
                String projectDescription = resultSet.getString("project_description");
                String projectStatus = resultSet.getString("project_status");

                model.addRow(new Object[]{projectId, projectName, projectDescription, projectStatus});
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            slip_12_2 p = new slip_12_2();
    }
}
