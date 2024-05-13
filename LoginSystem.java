import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded username and password (you can replace this with a database or file-based authentication)
        String correctUsername = "user123";
        String correctPassword = "pass123";

        // Prompt the user to enter their username
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        // Prompt the user to enter their password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the entered username and password match the correct ones
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Incorrect username or password. Please try again.");
        }

        // Close the scanner
        scanner.close();
    }
}
