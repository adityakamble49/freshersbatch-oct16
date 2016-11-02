package com.adityakamble49;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Books
 */
@WebServlet("/books")
public class Books extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<String> compList = new ArrayList<String>();

        compList.addAll(Arrays.asList(request.getParameterValues("book_name")));
        session.setAttribute("comp_list", compList);

        System.out.println(compList);
        response.sendRedirect("books_list_2.html");

    }

}
