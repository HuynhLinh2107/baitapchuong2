package com.LTWeb.controller;

import java.io.IOException;

import com.LTWeb.business.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Ho tro du lieu tieng Viet
        request.setCharacterEncoding("UTF-8");

        // Lay hanh dong tu form
        String action = request.getParameter("action");

        if ("add".equals(action)) {

            // Lay thong tin nguoi dung
            String firstName =
                    request.getParameter("firstName");

            String lastName =
                    request.getParameter("lastName");

            String email =
                    request.getParameter("email");

            // Kiem tra du lieu
            if (firstName == null || firstName.isBlank()
                    || lastName == null || lastName.isBlank()
                    || email == null || email.isBlank()) {

                request.getRequestDispatcher("/index.jsp")
                       .forward(request, response);
                return;
            }

            // Tao doi tuong User
            User user = new User(firstName, lastName, email);

            // Gui du lieu sang JSP
            request.setAttribute("user", user);

            // Chuyen den trang ket qua
            request.getRequestDispatcher("/thanks.jsp")
                   .forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(request.getContextPath() + "/");
    }
}
