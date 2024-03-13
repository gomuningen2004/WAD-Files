import java.sql.*;
import java.util.Scanner;

public class jdbc {
    public static final String url = "jdbc:mysql://localhost:3306/student";
    public static final String username = "root";
    public static final String password = "go123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
             Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("Choose operation:");
                System.out.println("1. Select");
                System.out.println("2. Insert");
                System.out.println("3. Delete");
                System.out.println("4. Update");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        selectOperation(con);
                        break;
                    case 2:
                        insertOperation(con, scanner);
                        break;
                    case 3:
                        deleteOperation(con, scanner);
                        break;
                    case 4:
                        updateOperation(con);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void selectOperation(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String query = "select * from student";
        ResultSet result = stmt.executeQuery(query);
        System.out.println("Name    | Age | Branch | Marks");
        System.out.println("--------------------------------");
        while (result.next()) {
            String name = result.getString("name");
            int age = result.getInt("age");
            String branch = result.getString("branch");
            int marks = result.getInt("marks");

            // Using formatting to align columns
            System.out.printf("%-8s| %-4d| %-7s| %-5d%n", name, age, branch, marks);
        }
    }

    public static void insertOperation(Connection con, Scanner scanner) throws SQLException {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter branch:");
        String branch = scanner.nextLine();

        System.out.println("Enter marks:");
        int marks = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        try (PreparedStatement insertStmt = con.prepareStatement(
                "INSERT INTO student (name, age, branch, marks) VALUES (?, ?, ?, ?)")) {
            insertStmt.setString(1, name);
            insertStmt.setInt(2, age);
            insertStmt.setString(3, branch);
            insertStmt.setInt(4, marks);
            insertStmt.executeUpdate();
            System.out.println("New row inserted successfully.");
        }
    }

    public static void deleteOperation(Connection con, Scanner scanner) throws SQLException {
        System.out.println("Choose deletion criteria:");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Branch");
        System.out.println("4. Marks");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String columnName = "";
        String promptMessage = "";

        switch (choice) {
            case 1:
                columnName = "name";
                promptMessage = "Enter name to delete: ";
                break;
            case 2:
                columnName = "age";
                promptMessage = "Enter age to delete: ";
                break;
            case 3:
                columnName = "branch";
                promptMessage = "Enter branch to delete: ";
                break;
            case 4:
                columnName = "marks";
                promptMessage = "Enter marks to delete: ";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.print(promptMessage);
        String value = scanner.nextLine();

        String deleteQuery = "DELETE FROM student WHERE " + columnName + " = ?";
        try (PreparedStatement deleteStmt = con.prepareStatement(deleteQuery)) {
            deleteStmt.setString(1, value);
            int rowsAffected = deleteStmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted successfully.");
        }
    }


    public static void updateOperation(Connection con) throws SQLException {
        try (PreparedStatement updateStmt = con.prepareStatement(
                "UPDATE student SET branch = ? WHERE name = ?")) {
            updateStmt.setString(1, "CSEAIML");
            updateStmt.setString(2, "John"); // You can modify this to take user input for the name to update
            updateStmt.executeUpdate();
            System.out.println("Branch of John updated successfully.");
        }
    }
}
