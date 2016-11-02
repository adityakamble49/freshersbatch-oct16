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
@WebServlet("/show_cart")
public class ShowCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String> histList = new ArrayList<String>();

        histList.addAll(Arrays.asList(request.getParameterValues("book_name")));
        session.setAttribute("hist_list", histList);

        System.out.println(histList);

        @SuppressWarnings("unchecked")
        ArrayList<String> compList = (ArrayList<String>) session
                .getAttribute("comp_list");
        compList.addAll(histList);

        response.sendRedirect("show_cart.jsp");

    }

}
