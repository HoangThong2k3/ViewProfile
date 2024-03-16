<%@ page import="java.util.List" %>
<%@ page import="com.se4f7.prj301.entities.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="./css/mdb.min.css" rel="stylesheet">
    <link href="./css/login-style.css" rel="stylesheet">
  </head>
  <%
      List<User> list = (List<User>) request.getAttribute("list");
  %>

  <body>
    <table class="table align-middle mb-0 bg-white">
  <thead class="bg-light">
    <tr>
      <th>Name</th>
      <th>Title</th>
      <th>Status</th>
      <th>Position</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
  <%for(User user : list){%>
    <tr>
      <td>
        <div class="d-flex align-items-center">
          <a href="./profile?id=<%= user.getId() %>">

          <img
              src="https://mdbootstrap.com/img/new/avatars/8.jpg"
              alt=""
              style="width: 45px; height: 45px"
              class="rounded-circle"
              />
            </a>
          <div class="ms-3">
            <p class="fw-bold mb-1"><%=user.getFirstName()%> <%=user.getLastName()%></p>
            <p class="text-muted mb-0"><%=user.getEmail()%></p>
          </div>
        </div>
      </td>
      <td>
        <p class="fw-normal mb-1"><%=user.getTitle()%></p>
      </td>
      <td>
        <span class="badge badge-success rounded-pill d-inline"><%=user.getStatus()%></span>
      </td>
      <td>Senior</td>
      <td>
        <button type="button" class="btn btn-link btn-sm btn-rounded">
          Edit
        </button>
      </td>
    </tr>
    <%}%>
  </tbody>
</table>
    <script type="text/javascript" src="./js/mdb.min.js"></script>
  </body>

  </html>