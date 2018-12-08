package controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 25.11.2018.
 */


public class ExceptionCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        throw new RuntimeException("Generated exception");
    }
}
