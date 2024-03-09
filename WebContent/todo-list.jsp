<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Todo List</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link href="./css/mdb.min.css" rel="stylesheet">
<link href="./css/login-style.css" rel="stylesheet">
</head>

<body>
	<div class="card">
		<div class="card-header">
			<div class="row">
				<div class="col">TODO LIST</div>
				<div class="col">
					<a href="./todo-form" class="btn btn-primary"
						style="float: right;">Create Task</a>
				</div>
			</div>
		</div>
		<div class="card-body">
			<table class="table align-middle mb-0 bg-white">
				<thead class="bg-light">
					<tr>
						<th>Name</th>
						<th>Date Start</th>
						<th>Date End</th>
						<th>Status</th>
						<th>Description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todo" items="${todoList}">
						<tr>
							<td><c:out value="${todo.name}" /></td>
							<td><c:out value="${todo.planStart}" /></td>
							<td><c:out value="${todo.planEnd}" /></td>
							<td><c:out value="${todo.status}" /></td>
							<td><c:out value="${todo.description}" /></td>
							<td><a href="./todo-form?id=<c:out value='${todo.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="./todo-delete?id=<c:out value='${todo.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="./js/mdb.min.js"></script>
</body>

</html>