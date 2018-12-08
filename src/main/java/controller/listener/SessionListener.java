package controller.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

/**
 * Created by User on 01.12.2018.
 */


public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent.getSession()
                .getServletContext().getAttribute("loggedUsers");
        String userName = (String) httpSessionEvent.getSession().getAttribute("userName");
        loggedUsers.remove(userName);
        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);

    }
}
