package utils;

public class InputValidator {


    private static InputValidator instance;

    // Private constructor to prevent instantiation, its empty  to prevent instance
    private InputValidator() {}

    // Static method to get the singleton instance
    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    // regex email
    public boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }

    //  regex phone 10digits
    public boolean validatePhoneNumber(String phoneNumber) {
        String phoneRegex = "^[0-9]{10}$";
        return phoneNumber != null && phoneNumber.matches(phoneRegex);
    }

    // string not empty
    public boolean validateNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // password length
    public boolean validatePassword(String password) {
        return password != null && password.length() >= 6;
    }

}
