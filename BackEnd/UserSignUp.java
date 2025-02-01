package Backend;
import java.util.regex.Pattern;

public class UserSignUp {

    // Validate email format based on user type
    public static boolean isValidEmail(String email, String userType) {
        String studentRegex = "^[0-9a-zA-Z]{10}@svecw\\.edu\\.in$";
        String adminRegex = "^[a-zA-Z]+@svecw\\.edu\\.in$";
        String restaurantRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (userType.equals("student")) {
            return Pattern.matches(studentRegex, email);
        } else if (userType.equals("admin")) {
            return Pattern.matches(adminRegex, email);
        } else if (userType.equals("restaurant")) {
            return Pattern.matches(restaurantRegex, email);
        }

        return false;
    }

    // Register a user (store them, etc.)
    public static String registerUser(String email, String password, String userType) {
        // In a real scenario, save user to the database

        System.out.println("User of type " + userType + " registered with email: " + email);
        return "User registered successfully!";
    }

    // Check if the password is strong
    public static boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&   // At least one uppercase letter
               password.matches(".*[a-z].*") &&   // At least one lowercase letter
               password.matches(".*[0-9].*") &&   // At least one digit
               password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"); // Special character
    }
}
