<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Please enter order id to get order info:</h2>
<form action="orders/orderById" method="get">
    <input type="number" name="id" placeholder="Write order id"/>
    <input type="submit">
</form>
<br>
<a href="orders/allOrders">To get all orders info</a>

</body>
</html>
