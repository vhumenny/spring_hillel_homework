<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<body>

<ul>
    <c:forEach items="${all_orders}" var="order">
        <tr>
            <td>Order ID: <c:out value="${order.id}"/></td>
            <td>Order date: <c:out value="${order.date}"/></td>
            <td>Order cost: <c:out value="${order.cost}"/></td>
            <td>Order products: <c:out value="${order.products}"/></td>
        </tr>
    </c:forEach>
</ul>

</body>
</html>
