package com.se4f7.prj301.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se4f7.prj301.entities.ToDoEntity;
import com.se4f7.prj301.service.ToDoService;
import com.se4f7.prj301.service.impl.TodoServiceImpl;

@WebServlet("/todo-list")
public class TodoListController extends HttpServlet {
	private static final long serialVersionUID = 2860215007883522580L;

	private ToDoService todoService;

	public void init() {
		todoService = new TodoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<ToDoEntity> lists = todoService.searchByName(null);
			request.setAttribute("todoList", lists);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("todo-list.jsp");
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
