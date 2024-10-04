package com.athletaserverlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/login")
public class AdminServelet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            AdminDao adminDao = new AdminDao();
            adminDao.cadastrarAdm(2,"teste",email,senha);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + email + "</h1>");
            out.println("<h1>" + senha + "</h1>");
            out.println("</body></html>");

    }
}
