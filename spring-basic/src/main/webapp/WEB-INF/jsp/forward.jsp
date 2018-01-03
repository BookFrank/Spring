<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 2018/1/3
  Time: 上午10:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Date date = new Date();
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
    </p>
</body>
</html>
