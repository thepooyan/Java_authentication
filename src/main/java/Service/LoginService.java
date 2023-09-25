package Service;

import Model.User;
import Repository.UserRepo;

import java.util.Optional;

public class LoginService {
    UserRepo userRepo = new UserRepo();
    public Optional<User> login(String username, String password) {
        User user = User.builder().username(username).password(password).build();
        return userRepo.authenticateUser(user);
    }

    public Optional<User> signup(String name,String lastName,String username,String password) {
        User user = User.builder().name(name).lastName(lastName).username(username).password(password).build();
        return userRepo.addUser(user);
    }
}
