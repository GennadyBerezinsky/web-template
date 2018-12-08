package controller.command;

import controller.CommandUtility;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 08.12.2018.
 */


public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        CommandUtility.logout(request, login);
        return "redirect: /index.jsp";
    }
}
