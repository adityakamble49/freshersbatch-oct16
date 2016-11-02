package com.aditya.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet(urlPatterns = "/authenticate", initParams = @WebInitParam(name = "messageDriver", value = "com.message.Driver") )
public class Authenticate extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String driverName = config.getInitParameter("databaseDriver");
        System.out.println(driverName);
        String messageName = config.getInitParameter("messageDriver");
        System.out.println(messageName);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        if (authenticateUser(username, password)) {
            out.write("Login Successful");
        } else {
            out.write("Login Failed");
        }

    }

    private boolean authenticateUser(String username, String password) {
        if (username.equals("aditya") && password.equals("aditya123")) {
            return true;
        }
        return false;
    }

}
