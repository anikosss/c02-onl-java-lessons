<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Products</title>
</head>
<h2>Products:</h2>
<body>
    <c:forEach var="product" items="${products}">
        ID: ${product.id}
        Title: ${product.title}
        Description: ${product.description}
        Price: ${product.price}$
        <br>
    </c:forEach>
</body>
</html>