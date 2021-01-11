<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

<c:forEach items="${products}" var="product">
    ${product.id}<br>
    ${product.title}<br>
    ${product.description}<br>
    ${product.price}<br>
</c:forEach>

</body>
</html>
