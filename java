import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        try {
            // Update the connection string, username, and password here
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC", 
                "root", 
                "pwd"
            );

            String sql = "INSERT INTO contacts (first_name, last_name, address, phone_number) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.setString(4, phone);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
