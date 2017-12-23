<%--
  Created by IntelliJ IDEA.
  User: lina
  Date: 2017/12/23
  Time: 下午8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 内置对象</title>
</head>
<body>

    <%
        out.println("Out内置对象：Hello World");

        out.println(config.getServletName());
    %>




    <jsp:include page="${filename}"/>
</body>
</html>
