package controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 08.12.2018.
 */


public class ManagerCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/manager/managerbasis.jsp";
    }
}
