package com.se4f7.prj301.controller;

import com.se4f7.prj301.entities.User;
import com.se4f7.prj301.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoadData")
public class LoadData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        UserRepository repo = new UserRepository();
        List<User> list = new ArrayList();
        list = repo.getAllUsers();

        request.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
