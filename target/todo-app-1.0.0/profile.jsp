<%@ page import="com.se4f7.prj301.entities.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <!-- Các tệp CSS và JS -->
</head>
<body>
<%-- Kiểm tra xem có thông tin người dùng không --%>
<% if (request.getAttribute("user") != null) {
    // Lấy thông tin người dùng từ request
    User user = (User) request.getAttribute("user");
%>
<div>
    <h1>User Profile</h1>
    <p><strong>Name:</strong> <%= user.getFirstName() %> <%= user.getLastName() %></p>
    <p><strong>Email:</strong> <%= user.getEmail() %></p>
    <p><strong>Title:</strong> <%= user.getTitle() %></p>
    <p><strong>Status:</strong> <%= user.getStatus() %></p>
    <p><strong>Position:</strong> <%= user.getPosition() %></p>
</div>
<% } else { %>
<p>User not found!</p>
<% } %>
</body>
</html>
