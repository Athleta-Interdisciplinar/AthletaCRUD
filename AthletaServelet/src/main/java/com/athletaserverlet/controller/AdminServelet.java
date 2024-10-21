package com.athletaserverlet.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.athletaserverlet.dao.AdminDao;

@WebServlet(name = "login", value = "/login")
public class AdminServelet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdminDao adminDao = new AdminDao();
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        try {
            ResultSet resultSet = adminDao.verificarSenha(email, senha);

            if (resultSet.next()) { // Verifica se o resultado existe
                boolean verificarAdm = resultSet.getBoolean("senha");
                if (verificarAdm) {
                    request.getRequestDispatcher("admin.html").forward(request, response);
                } else {
                    // Credenciais incorretas
                    request.setAttribute("erro", "E-mail ou senha incorretos.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // Não encontrou o usuário
                request.setAttribute("erro", "E-mail ou senha incorretos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (RuntimeException re) {
            request.getRequestDispatcher("errorCon.html").forward(request,response);
            response.sendError(400,"Erro de Conexão");
        } catch (SQLException e) {
            request.getRequestDispatcher("errorCon.html").forward(request,response);
            response.sendError(400,"Erro de Conexão");
        }
    }
}