<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 5/11/24
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Confirm Del</title>
</head>
<body>
<h1>Delete confirmation</h1>
<p>Are you sure you want to delete book with id <b>${book.id}</b> and title <b>${book.title}</b></p>
<a href="/bookForm/list">No, cancel</a><br>
<a href="/bookForm/delete/${book.id}">Yes, delete</a>
</body>
</html>
