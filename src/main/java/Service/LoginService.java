package Service;

import Model.User;
import Repository.UserRepository;

import java.util.Optional;

public class LoginService {
    UserRepository userRepository = new UserRepository();
    public Optional<User> login(String username, String password) {
        User user = User.builder().username(username).password(password).build();
        return userRepository.authenticateUser(user);
    }

    public Optional<User> signup(String name,String lastName,String username,String password) {
        User user = User.builder().name(name).lastName(lastName).username(username).password(password).build();
        return userRepository.addUser(user);
    }
}
