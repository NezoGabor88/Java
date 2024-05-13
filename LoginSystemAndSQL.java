import java.sql.*;

public class LoginSystemAndSQL {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:sqlite:users.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // Create table if not exists
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT NOT NULL UNIQUE," +
                    "password TEXT NOT NULL)";
            stmt.execute(sql);

            // Insert sample user data if the table is empty
            sql = "SELECT count(*) as count FROM users";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int count = rs.getInt("count");
            if (count == 0) {
                sql = "INSERT INTO users (username, password) VALUES " +
                        "('user123', 'pass123')";
                stmt.execute(sql);
            }

            // Prompt the user to enter their username
            String username = "user123"; // You can remove this line
            String password = "pass123"; // and these two lines and
            // uncomment the code below to get user input

            /* Uncomment this block to get user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            scanner.close();
            */

            // Check user credentials
            sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Incorrect username or password. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
