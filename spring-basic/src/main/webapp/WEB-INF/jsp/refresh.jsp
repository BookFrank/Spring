<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 2018/1/3
  Time: 上午11:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Date date = new Date();
%>
<html>
<head>
    <title>Servlet跳转 -- 刷新（Refresh）</title>
</head>
<body>
    <h2>刷新（Refresh）</h2>
    <p>
        当前时间为：
        <%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date) %>
    </p>
</body>
</html>
