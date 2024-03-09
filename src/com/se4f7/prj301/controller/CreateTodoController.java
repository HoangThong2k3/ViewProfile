package com.se4f7.prj301.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se4f7.prj301.dto.request.TodoRequestDto;
import com.se4f7.prj301.entities.ToDoEntity;
import com.se4f7.prj301.service.ToDoService;
import com.se4f7.prj301.service.impl.TodoServiceImpl;

@WebServlet("/todo-form")
public class CreateTodoController extends HttpServlet {

	private static final long serialVersionUID = 2860215007883522580L;

	private ToDoService todoService;

	public void init() {
		todoService = new TodoServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String idStr = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			LocalDate planStart = LocalDate.parse(request.getParameter("planStart"));
			LocalDate planEnd = LocalDate.parse(request.getParameter("planEnd"));
			int status = Integer.parseInt(request.getParameter("status"));
			if (idStr == null) {
				todoService.create(new TodoRequestDto(name, description, planStart, planEnd, status));
			} else {
				todoService.update(Integer.parseInt(idStr),
						new TodoRequestDto(name, description, planStart, planEnd, status));
			}
			response.sendRedirect("todo-list");
		} catch (Exception e) {
			response.sendRedirect("todo-form.jsp?error=");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("id") != null) {
				ToDoEntity todo = todoService.getById(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("todo", todo);
				RequestDispatcher dispatcher = request.getRequestDispatcher("todo-form.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("todo-form.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}