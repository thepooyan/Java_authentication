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

@WebServlet(name = "signup", value = "/signup")
public class signupServlet extends HttpServlet {
    LoginService loginService = new LoginService();
    Validator validator = new Validator();

    private void throwLoginError(String errorMsg, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        req.getSession().setAttribute("error", errorMsg);
        resp.sendRedirect("signup.jsp");
    }

    private void clearLoginErrors(HttpServletRequest req) {
        req.getSession().setAttribute("error", null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!validator.isPasswordValid(name)) {
            throwLoginError("invalid name", resp, req);
            return;
        }
        if (!validator.isPasswordValid(lastName)) {
            throwLoginError("invalid last name", resp, req);
            return;
        }
        if (!validator.isPasswordValid(username)) {
            throwLoginError("invalid username", resp, req);
            return;
        }
        if (!validator.isPasswordValid(password)) {
            throwLoginError("invalid password", resp, req);
            return;
        }

        Optional<User> result = loginService.signup(name, lastName, username, password);

        if (result.isPresent()) {
           req.getSession().setAttribute("isLoggedIn", result.get());
           resp.sendRedirect("profile.jsp");
           clearLoginErrors(req);
        } else {
            throwLoginError("something went wrong", resp, req);
            return;
        }
    }
}
