package controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 07.12.2018.
 */


public class UserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/user/userbasis.jsp";
    }
}
