package Backend;
public class UserLogin {

    // Check if the login credentials are valid
    public static String loginUser(String email, String password) {
        // In a real application, check user credentials in the database

        if (email.equals("example@svecw.edu.in") && password.equals("StrongPass123!")) {
            return "Login successful!";
        } else {
            return "Invalid email or password!";
        }
    }
}
