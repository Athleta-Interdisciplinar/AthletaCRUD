package com.athletaserverlet.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.athletaserverlet.dao.AdminDao;

@WebServlet(name = "login", value = "/login")
public class AdminServelet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            AdminDao adminDao = new AdminDao();
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            ResultSet resultSet = adminDao.verificarSenha(email,senha);
            boolean verificarAdm = Boolean.parseBoolean(String.valueOf(resultSet));
            if (verificarAdm){
                request.getRequestDispatcher("eror.jsp").forward(request,response);
            } else {
                response.setContentType("text/html");

                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + "Senha errada ou e-mail invalido" + "</h1>");
                out.println("</body></html>");

            }
    }
}
