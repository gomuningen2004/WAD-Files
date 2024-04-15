import java.sql.*;

public class jdbcsimple {
    public static final String url = "jdbc:mysql://localhost:3306/student";
    public static final String username = "root";
    public static final String password = "go123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}