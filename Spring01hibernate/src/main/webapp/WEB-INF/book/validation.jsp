<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 5/11/24
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Validation</title>
</head>
<body>
<c:forEach var = "item" items="${result}">
    ${item}<br>
</c:forEach>
</body>
</html>
