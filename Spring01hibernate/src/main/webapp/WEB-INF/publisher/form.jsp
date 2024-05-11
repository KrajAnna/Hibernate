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
    <title>Publisher</title>
</head>
<body>
<h1>Add/edit publisher</h1>
<form:form method="post" modelAttribute="publisher" action="/publisherForm">
    <form:hidden path="id"/>
    <label>Name:
        <form:input path="name"/>
        <form:errors path="name"/>
    </label>
    <hr/>
    <label>NIP:
        <form:input path="nip"/>
        <form:errors path="nip"/>
    </label>
    <hr/>
    <label>REGON:
        <form:input path="regon"/>
        <form:errors path="regon"/>
    </label>
    <hr/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>