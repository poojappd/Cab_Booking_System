import java.util.regex.*;

public class Validation {

    public static boolean validatePassword(String password) {
        if (password.length() >= 8 && password.matches(".*\\d.*")
                && password.matches("[a-z&&A-Z]+")) {
            System.out.println("Success");
        }

return true
    }
}

