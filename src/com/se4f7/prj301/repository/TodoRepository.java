package com.se4f7.prj301.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.se4f7.prj301.dto.request.TodoRequestDto;
import com.se4f7.prj301.entities.ToDoEntity;
import com.se4f7.prj301.utils.DBUtil;

public class TodoRepository {

	private static final String INSERT_SQL = "INSERT INTO todo"
			+ "(name, description, planStart, planEnd, status, createdDate, updatedDate) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_SQL = "UPDATE todo"
			+ " SET name = ?, description = ?, planStart = ?, planEnd = ?, status = ?, updatedDate = ?"
			+ " WHERE id = ?;";
	private static final String GET_BY_ID_SQL = "SELECT * FROM todo WHERE id = ?";
	private static final String DELETE_BY_ID_SQL = "DELETE FROM todo WHERE id = ?";
	private static final String SEARCH_LIST_SQL = "SELECT * FROM todo WHERE name LIKE ?";

	public boolean create(TodoRequestDto todo) throws SQLException {
		// Open connection and set SQL query into PreparedStatement.
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
			// Set parameters.
			preparedStatement.setString(1, todo.getName());
			preparedStatement.setString(2, todo.getDescription());
			preparedStatement.setDate(3, Date.valueOf(todo.getPlanStart()));
			preparedStatement.setDate(4, Date.valueOf(todo.getPlanEnd()));
			preparedStatement.setInt(5, 1);
			preparedStatement.setDate(6, new Date(0));
			preparedStatement.setDate(7, new Date(0));
			// Show SQL query.
			System.out.println(preparedStatement);
			// Execute query.
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.printSQLException(e);
		}
		return false;
	}

	public boolean update(int id, TodoRequestDto todo) throws SQLException {
		// Open connection and set SQL query into PreparedStatement.
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
			// Set parameters.
			preparedStatement.setString(1, todo.getName());
			preparedStatement.setString(2, todo.getDescription());
			preparedStatement.setDate(3, Date.valueOf(todo.getPlanStart()));
			preparedStatement.setDate(4, Date.valueOf(todo.getPlanEnd()));
			preparedStatement.setInt(5, 1);
			preparedStatement.setDate(6, new Date(0));
			preparedStatement.setInt(7, id);
			// Show SQL query.
			System.out.println(preparedStatement);
			// Execute query.
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.printSQLException(e);
		}
		return false;
	}

	public ToDoEntity getById(int id) throws SQLException {
		// Open connection and set SQL query into PreparedStatement.
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL)) {
			// Set parameters.
			preparedStatement.setInt(1, id);
			// Show SQL query.
			System.out.println(preparedStatement);
			// Execute query.
			ResultSet rs = preparedStatement.executeQuery();
			ToDoEntity todoEntity = new ToDoEntity();
			while (rs.next()) {
				todoEntity.setId(rs.getInt("id"));
				todoEntity.setName(rs.getString("name"));
				todoEntity.setDescription(rs.getString("description"));
				todoEntity.setPlanStart(rs.getDate("planStart"));
				todoEntity.setPlanEnd(rs.getDate("planEnd"));
				todoEntity.setStatus(rs.getInt("status"));
			}
			return todoEntity;
		} catch (SQLException e) {
			DBUtil.printSQLException(e);
		}
		return null;
	}

	public boolean deleteById(int id) throws SQLException {
		// Open connection and set SQL query into PreparedStatement.
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL)) {
			// Set parameters.
			preparedStatement.setInt(1, id);
			// Show SQL query.
			System.out.println(preparedStatement);
			// Execute query.
			return preparedStatement.execute();
		} catch (SQLException e) {
			DBUtil.printSQLException(e);
		}
		return false;
	}

	public List<ToDoEntity> searchByName(String name) throws SQLException {
		// Open connection and set SQL query into PreparedStatement.
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_LIST_SQL)) {
			// Set parameters.
			preparedStatement.setString(1, name != null ? "%" + name + "%" : "%%");
			// Show SQL query.
			System.out.println(preparedStatement);
			// Execute query.
			ResultSet rs = preparedStatement.executeQuery();
			List<ToDoEntity> todos = new ArrayList<ToDoEntity>();
			while (rs.next()) {
				ToDoEntity todoEntity = new ToDoEntity();
				todoEntity.setId(rs.getInt("id"));
				todoEntity.setName(rs.getString("name"));
				todoEntity.setDescription(rs.getString("description"));
				todoEntity.setPlanStart(rs.getDate("planStart"));
				todoEntity.setPlanEnd(rs.getDate("planEnd"));
				todoEntity.setStatus(rs.getInt("status"));
				todoEntity.setCreatedDate(rs.getDate("createdDate"));
				todoEntity.setUpdatedDate(rs.getDate("updatedDate"));
				todos.add(todoEntity);
			}
			return todos;
		} catch (SQLException e) {
			DBUtil.printSQLException(e);
		}
		return null;
	}
}
