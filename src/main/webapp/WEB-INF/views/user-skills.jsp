<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 12.01.2020
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista umiejętności</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<%int counter = 1;%>

<table border="yes">

    <tr>
        <td> <b> Lp.</b> </td>
        <td> <b> Nazwa Umiejętności </b> </td>
        <td> <b> Poziom Umiejętności </b> </td>
    </tr>

<c:forEach items="${userSkills}" var="userSkills">
    <tr>
    <td><%=counter++%></td>
    <td>${userSkills.name}</td>

        </c:forEach>
</table>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
