
package Backend;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Choose an option:");
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (choice == 1) {
            System.out.println("Select User Type:");
            System.out.println("1. Student");
            System.out.println("2. Admin");
            System.out.println("3. Restaurant");
            int userTypeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            String userType = "";
            if (userTypeChoice == 1) {
                userType = "student";
            } else if (userTypeChoice == 2) {
                userType = "admin";
            } else if (userTypeChoice == 3) {
                userType = "restaurant";
            } else {
                System.out.println("Invalid choice!");
                return;
            }

            System.out.println("Enter email:");
            String email = scanner.nextLine();

            // Check email format based on user type
            if (!UserSignUp.isValidEmail(email, userType)) {
                System.out.println("Invalid email format!");
                return;
            }

            String password = "";
            while (true) {
                System.out.println("Enter password (must be strong):");
                password = scanner.nextLine();
                if (UserSignUp.isStrongPassword(password)) {
                    break;
                } else {
                    System.out.println("Weak password! Please enter a stronger password.");
                }
            }

            String result = UserSignUp.registerUser(email, password, userType);
            System.out.println(result);

        } else if (choice == 2) {
            System.out.println("Enter email:");
            String email = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            String result = UserLogin.loginUser(email, password);
            System.out.println(result);
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}

