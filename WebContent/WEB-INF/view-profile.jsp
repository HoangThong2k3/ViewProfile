<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
<h1>User Profile</h1>

<c:set var="username" value="${user.username}" />
<c:set var="fullName" value="${user.fullName}" />
<c:set var="email" value="${user.email}" />
<c:set var="position" value="${user.position}" />

<c:if test="${not empty username}">
    <p><strong>Username:</strong> ${username}</p>
</c:if>
<c:if test="${not empty fullName}">
    <p><strong>Full Name:</strong> ${fullName}</p>
</c:if>
<c:if test="${not empty email}">
    <p><strong>Email:</strong> ${email}</p>
</c:if>
<c:if test="${not empty position}">
    <p><strong>Position:</strong> ${position}</p>
</c:if>

</body>
</html>
