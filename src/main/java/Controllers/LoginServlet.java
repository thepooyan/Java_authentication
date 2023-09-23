package Controllers;

import Model.User;
import Service.LoginService;
import Service.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "login", value = "/login")
public class LoginServlet  extends HttpServlet {
    LoginService loginService = new LoginService();
    Validator validator = new Validator();

    private void throwLoginError(String errorMsg, HttpServletResponse resp, HttpServletRequest req) throws IOException {
       req.getSession().setAttribute("error", errorMsg);
       resp.sendRedirect("login.jsp");
    }
    private void clearLoginErrors(HttpServletRequest req) {
        req.getSession().setAttribute("error", null);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ( !validator.isUsernameValid(username)) {
            throwLoginError("username is not valid", resp, req);
            return;
        }

        if (!validator.isPasswordValid(password)) {
            throwLoginError("password is not valid", resp, req);
            return;
        }

        Optional<User> user = loginService.login(username, password);

        if (user.isPresent()) {
           resp.sendRedirect("Profile.jsp");
           req.getSession().setAttribute("isLoggedIn" ,user.get());
           clearLoginErrors(req);
        } else {
            throwLoginError("username or password wrong!", resp, req);
            return;
        }
    }
}
