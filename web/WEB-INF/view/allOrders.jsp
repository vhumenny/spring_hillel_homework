<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<ul>
    <c:forEach items="${all_orders}" var="order">
        <tr>
            <td>Order ID: <c:out value="${order.id}"/></td>
            <br>
            <td>Order date: <c:out value="${order.date}"/></td>
            <br>
            <td>Order cost: <c:out value="${order.cost}"/></td>
            <br>
            <td>Order products: <c:out value="${order.products}"/></td>
            <br><br>
        </tr>
    </c:forEach>
</ul>

</body>
</html>
