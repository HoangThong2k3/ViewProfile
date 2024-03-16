package com.se4f7.prj301.controller;

import com.se4f7.prj301.entities.User;
import com.se4f7.prj301.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profile", urlPatterns = "/profile")
public class profile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));

            User user = new User();
            UserRepository repo = new UserRepository();

            user = repo.getUser(id);
        System.out.println(user);
            request.setAttribute("user", user);
            request.getRequestDispatcher("profile.jsp").forward(request,response);
        }
    }

