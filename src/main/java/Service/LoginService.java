package Service;

import Model.User;
import Repository.UserRepo;

import java.util.Optional;

public class LoginService {
    public Optional<User> login(String username, String password) {
        User user = User.builder().username(username).password(password).build();
        UserRepo userRepo = new UserRepo();
        return userRepo.authenticateUser(user);
    }

    public Optional<User> signup(String name,String lastName,String username,String password) {
        User user = User.builder().name(name).lastName(lastName).username(username).password(password).build();
        System.out.println(user);
        return Optional.ofNullable(user);
    }
}
