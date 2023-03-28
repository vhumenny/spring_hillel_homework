<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All orders info:</h2>
<br>

<c:forEach var="order" items="${param.orders}">
    <li><c:out value="${order}"/></li>
</c:forEach>

</body>
</html>
