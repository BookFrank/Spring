<%--
  Created by IntelliJ IDEA.
  User: lina
  Date: 2017/12/12
  Time: 上午11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Taglib 指令测试</title>
</head>
<body>
    <c:forEach var="i" items="${cars}">
        <c:out value="${i}">
        </c:out>
    </c:forEach>
</body>
</html>
