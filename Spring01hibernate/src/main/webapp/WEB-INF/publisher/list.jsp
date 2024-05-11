<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 5/11/24
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Publishers list</title>
</head>
<body>
<h1>Publishers list</h1>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${publishers}" var="p">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>
        <a href="/publisherForm/edit/${p.id}">Edit</a>
        <a href="/publisherForm/confirmDel/${p.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>