<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 5/11/24
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Author</title>
</head>
<body>
<h1>Add/edit author</h1>
<form:form method="post" modelAttribute="author" action="/authorForm">
    <form:hidden path="id"/>
    <label>First name:
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </label>
    <hr/>
    <label>Last name:
        <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </label>
    <hr/>
    <label>Email:
        <form:input path="email"/>
        <form:errors path="email"/>
    </label>
    <hr/>
    <label>PESEL:
        <form:input path="pesel"/>
        <form:errors path="pesel"/>
    </label>
    <hr/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>