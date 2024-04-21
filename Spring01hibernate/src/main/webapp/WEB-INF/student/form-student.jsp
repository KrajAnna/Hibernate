<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 4/21/24
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form student</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    <label>
        First Name: <form:input path="firstName"/>
    </label><br>
    <label>
        Last Name: <form:input path="lastName"/>
    </label><br>
    <label>
        Gender:
        Male <form:radiobutton path="gender" value="M"/>
        Female <form:radiobutton path="gender" value="F"/>
    </label><br>
    <label>
        Country: <form:select path="country" items="${countries}"/>
    </label><br>
    <label>
        Notes: <form:textarea path="notes" />
    </label><br>
    <label>
        Mailing List: <form:checkbox path="mailingList" />
    </label><br>
    <label>
        Programming skills: <form:select path="programmingSkills"  multiple="true" items="${studentSkills}"/>
    </label><br>
    <label>
        Hobby: <form:checkboxes path="hobbies" items="${studentHobbies}"/>
    </label><br>
    <label>
        <input type="submit" value="SUBMIT">
    </label><br>

</form:form>
</body>
</html>
