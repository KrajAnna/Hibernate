<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 4/21/24
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
</head>
<body>
<h1>BookList
</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Rating</th>
        <th>Description</th>
        <th>Publisher</th>
        <th>EditBook</th>
        <th>RemoveBook</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items = "${books}" var="b">
        <td>${b.id}</td>
        <td>${b.title}</td>
        <td>${b.rating}</td>
        <td>${b.description}</td>
        <td>${b.publisher.name}</td>
        <td><a href="/book/edit/${b.id}">Edit</a></td>
        <td><a href="/book/confirmDel/${b.id}">Del</a></td>
    </tbody>
    </c:forEach>
</table>
</body>
</html>
