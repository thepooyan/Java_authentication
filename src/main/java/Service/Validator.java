package Service;

public class Validator {
    public boolean isUsernameValid(String username) {
        return username.trim().length() > 0;
    }
    public boolean isPasswordValid(String password) {
        return password.trim().length() > 0;
    }
}
