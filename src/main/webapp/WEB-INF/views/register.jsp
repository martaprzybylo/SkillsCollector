<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 12.01.2020
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<form action="/register" method="post">
    <label>Nazwa użytkownika:</label><br/>
    <input type="text" name="username" placeholder="Login" value="${user.username}" required><br/><br/>
    <label>Hasło:</label><br/>
    <input type="password" name="password" placeholder="********" required><br/><br/>
    <label>Imię</label><br/>
    <input type="text" name="firstName" placeholder="Twoję imię" value="${user.firstName}"><br/><br/>
    <label>Nazwisko: </label><br/>
    <input type="text" name="lastName" placeholder="Twoje nazwisko" value="${user.lastName}"><br/><br/><br/>
    <a href="/login"><input type="submit" value="Zarejestruj"></a>
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
