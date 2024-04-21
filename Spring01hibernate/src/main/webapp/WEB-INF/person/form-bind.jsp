<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 4/21/24
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method = "post" modelAttribute="person">
    <label>
        Login: <form:input path="login"/>
    </label>
    <label>
        Password: <form:input path="password"/>
    </label>
    <label>
        Email: <form:input path="email"/>
    </label>
    <label>
        <input type="submit" value = "Submit form">
    </label>
</form:form>
</body>
</html>
