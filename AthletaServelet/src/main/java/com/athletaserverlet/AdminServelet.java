package com.athletaserverlet;

import dao.AdminDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cadastro", value = "/cadastro")
public class AdminServelet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var admin = new AdminDao();
        String email = request.getParameter("email");
        String nomeCompleto = request.getParameter("nomeCompleto");
        String nomeUsuario = request.getParameter("nomeUsuario");

        admin.cadastrarAdm(2,nomeCompleto,email,"senhaforte");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Nota 1: " + "</h1>");
        out.println("</body></html>");

    }
}
