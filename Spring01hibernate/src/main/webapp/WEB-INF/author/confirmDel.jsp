<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 5/11/24
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm delete</title>
</head>
<body>
<h1>Delete confirmation</h1>
<p>Are you sure you want to delete author with id <b>${author.id}</b> and name <b>${author.fullName}</b></p>
<a href="/authorForm/list">No, cancel</a><br>
<a href="/authorForm/delete/${author.id}">Yes, delete</a>
</body>
</html>