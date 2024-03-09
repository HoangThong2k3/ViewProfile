package com.se4f7.prj301.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se4f7.prj301.service.ToDoService;
import com.se4f7.prj301.service.impl.TodoServiceImpl;

@WebServlet("/todo-delete")
public class TodoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 2860215007883522580L;

	private ToDoService todoService;

	public void init() {
		todoService = new TodoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			todoService.delete(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("./todo-list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
