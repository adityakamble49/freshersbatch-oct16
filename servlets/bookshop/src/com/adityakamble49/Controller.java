package com.adityakamble49;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String forward = request.getParameter("forward");

        switch (forward) {

        case "login":
            request.getRequestDispatcher("login").forward(request, response);
            break;

        case "add_books":
            request.getRequestDispatcher("books").forward(request, response);
            break;

        case "show_cart":
            request.getRequestDispatcher("show_cart").forward(request,
                    response);
            break;

        case "logout":
            request.getRequestDispatcher("logout").forward(request, response);
            break;

        default:
            break;
        }
    }

}
