package controller;

import controller.command.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by User on 25.11.2018.
 */


public class Servlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(Servlet.class);
    private Map<String, Command> commandMap = new HashMap<>();

    @Override
    public void init(ServletConfig config)
            throws ServletException {
        log.trace("servlet inited");
        config.getServletContext().setAttribute("loggedUsers", new HashSet<String>());

        commandMap.put("exception", new ExceptionCommand());
        commandMap.put("login", new LoginCommand());
        commandMap.put("user", new UserCommand());
        commandMap.put("manager", new ManagerCommand());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace(request.getAttribute("login"));
        String path = request.getRequestURI();
        log.trace("path: " + path);
        path = path.substring(path.lastIndexOf("/") + 1);
        log.trace("path: " + path);
        Command command = commandMap.getOrDefault(path, (r) -> "/index.jsp");
        log.trace("command class is " + command.getClass());
        String page = command.execute(request);
        log.trace("page is: " + page);
        if(page.contains("redirect: ")) {
            response.sendRedirect(request.getContextPath() + page.replaceAll("redirect: ", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }



    }




}
