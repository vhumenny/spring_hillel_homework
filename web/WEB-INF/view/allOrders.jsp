<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<ul>
  <c:forEach var="order" items="${all_order}">
    <li>
        ${order}
    </li>
  </c:forEach>
</ul>

</body>
</html>
