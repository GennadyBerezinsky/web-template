package controller.command;

import controller.CommandUtility;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 29.11.2018.
 */

public class LoginCommand implements Command {
        Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login").toString();
        String pass = request.getParameter("pass").toString();
        if(login == null || login.equals("") || pass == null || pass.equals("")){
            return "/login";
        }
        if(CommandUtility.isLogged(request, login)){
            log.trace("user already logged");
            return "redirect: /logout";
        }
        //todo: implement real user checking

        if(login.equals("user")){
            CommandUtility.login(request, User.ROLE.USER, login);
            return "redirect: /user";
        }
        if(login.equals("manager")){
            CommandUtility.login(request, User.ROLE.ADMIN, login);
            return "redirect: /manager";
        }
        else {
            return "login";
        }
    }
}
