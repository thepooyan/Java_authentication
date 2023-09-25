package Repository;

import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class UserRepo {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dev";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "1234";
    public UserRepo() {
        // Initialize database connection (You should handle exceptions properly)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Optional<User> authenticateUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
             "SELECT * FROM users WHERE username = ? AND password = ?")) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword()); // You should hash the password in a real application

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { // If a matching user is found, authentication is successful

                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));

                return Optional.of(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty(); // Authentication failed or encountered an error
    }

    public Optional<User> addUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
         "INSERT INTO users (name, lastName, username, password) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 1) {
                return Optional.ofNullable(user);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


}
