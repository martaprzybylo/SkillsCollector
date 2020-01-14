<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 12.01.2020
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona Logowania</title>

</head>
<body>

<jsp:include page="fragments/header.jsp"/>

<form action="/login" method="post">
    <label>Nazwa użytkownika:</label><br/>
    <input type="text" name="username" placeholder="login" required><br/><br/>
    <label>Hasło:</label><br/>
    <input type="password" , name="password" placeholder="********" required><br/><br/><br/>
    <input type="submit" name="Zaloguj">
    <br/>
    <br/>
    <br/>
    <c:if test="${error != null}">
        <p>${error}</p>
    </c:if>
    <br/>
    <br/>
    <br/>
    <br/>
</form>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>
