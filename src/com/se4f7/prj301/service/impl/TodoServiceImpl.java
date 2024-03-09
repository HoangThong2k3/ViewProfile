package com.se4f7.prj301.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.se4f7.prj301.constants.ErrorConstants;
import com.se4f7.prj301.dto.request.TodoRequestDto;
import com.se4f7.prj301.entities.ToDoEntity;
import com.se4f7.prj301.repository.TodoRepository;
import com.se4f7.prj301.service.ToDoService;

public class TodoServiceImpl implements ToDoService {

	private TodoRepository todoRepository = new TodoRepository();

	@Override
	public boolean create(TodoRequestDto todo) throws SQLException {
		return todoRepository.create(todo);
	}

	@Override
	public boolean update(int id, TodoRequestDto todo) throws SQLException {
		return todoRepository.update(id, todo);
	}

	@Override
	public boolean delete(int id) throws SQLException {
		return todoRepository.deleteById(id);
	}

	@Override
	public ToDoEntity getById(int id) throws SQLException {
		ToDoEntity todo = todoRepository.getById(id);
		if (todo == null) {
			throw new RuntimeException(ErrorConstants.RECORD_NOT_FOUND);
		}
		return todo;
	}

	@Override
	public List<ToDoEntity> searchByName(String name) throws SQLException {
		return todoRepository.searchByName(name);
	}

}
