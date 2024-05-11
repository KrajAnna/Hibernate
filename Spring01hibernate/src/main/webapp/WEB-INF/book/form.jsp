<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 4/21/24
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form:form modelAttribute="book" method="post" action="/bookForm/form">
    <form:hidden path="id"/>

    <label>
        <p> Title: <form:input path="title"/><form:errors path="title"/></p>
    </label>
    <label>
        <p>
            Rating: <form:input path="rating" type="number"/>
            <form:errors path="rating"/>
        </p>

    </label>
    <label>
        <p> Description: <form:textarea path="description" rows="5" cols="20"/>
            <form:errors path="description"/>
        </p>

    </label>
    <label>
        <p>
                <%--    name to atrubut z publishera--%>
            Publisher: <form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}"/>
            <form:errors path="publisher"/>
        </p>
    </label>
    <label>
        <p>
            <input type="submit" value="SUBMIT">
        </p>
    </label>
</form:form>
</body>
</html>
