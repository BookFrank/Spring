<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 2018/1/3
  Time: 上午10:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Date date = new Date();
    String hello = "Hello World";
%>
<html>
<head>
    <title>Servlet跳转 -- 转向（Forward）</title>
</head>
<body>
    <h2>转向（Forward）</h2>
    <p>
        RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/forward.jsp");
        <br/>
        dis.forward(req, resp);
        <br/>
        <%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date) %>
        <br/>
        <%-- 第一个Hello不会输出任何内容，在<%%>中定义的变量，无法被${}访问 --%>
        ${hello}
        <%= hello%>

    </p>
</body>
</html>
