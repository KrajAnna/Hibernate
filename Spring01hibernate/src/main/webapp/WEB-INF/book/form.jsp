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
    Title: <form:input path="title"/>
  </label>
  <label>
    Rating: <form:input path="rating" type = "number"/>
  </label>
  <label>
    Description: <form:textarea path="description" rows="5" cols="20"/>
  </label>
  <label>
    Publisher: <form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}"/>
<%--    name to atrubut z publishera--%>
  </label>
  <label>
    <input type="submit" value="SUBMIT">
  </label>
</form:form>
</body>
</html>
