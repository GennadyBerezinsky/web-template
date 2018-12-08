package controller;

import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 01.12.2018.
 */

public class CommandUtility {

    public static void setRole(HttpServletRequest request, String login, User.ROLE role){
        HttpSession session = request.getSession();
        session.setAttribute("user", login);
        session.setAttribute("role", role);

    }

    public static boolean isLogged(HttpServletRequest request, String login) {
        Set<String> loggedUsers = getLoggedUsers(request);
        return loggedUsers.stream().anyMatch(login::equals);
    }

    private static Set<String> getLoggedUsers(HttpServletRequest request){
        return (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");
    }

    private static void setLoggedUsers(HttpServletRequest request, Set<String> loggedUsers){
        request.getServletContext().setAttribute("loggesUsers", loggedUsers);
    }

    public static void login(HttpServletRequest request, User.ROLE role, String login){
        Set<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.add(login);
        setRole(request, login, role);
        setLoggedUsers(request, loggedUsers);
    }

    public static void logout(HttpServletRequest request, String  login){
        Set<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.remove("login");
        setLoggedUsers(request, loggedUsers);
    }



}


