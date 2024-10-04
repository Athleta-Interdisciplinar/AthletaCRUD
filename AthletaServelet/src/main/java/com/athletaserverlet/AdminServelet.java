package com.athletaserverlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import com.athletaserverlet.AdminDao;

@WebServlet(name = "login", value = "/login")
public class AdminServelet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            AdminDao adminDao = new AdminDao();
            adminDao.cadastrarAdm(2,"teste",email,senha);
    }
}
