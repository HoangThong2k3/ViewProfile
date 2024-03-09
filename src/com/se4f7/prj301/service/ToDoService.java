package com.se4f7.prj301.service;

import java.sql.SQLException;
import java.util.List;

import com.se4f7.prj301.dto.request.TodoRequestDto;
import com.se4f7.prj301.entities.ToDoEntity;

public interface ToDoService {

	boolean create(TodoRequestDto todo) throws SQLException;

	boolean update(int id, TodoRequestDto todo) throws SQLException;

	boolean delete(int id) throws SQLException;

	ToDoEntity getById(int id) throws SQLException;

	List<ToDoEntity> searchByName(String name) throws SQLException;

}
