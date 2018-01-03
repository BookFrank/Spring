<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.DayOfWeek" %><%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 2017/12/23
  Time: 下午8:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目根目录</title>
</head>
<body>
<h1>Spring Basic</h1>
<p>
    <%
        LocalDate date = LocalDate.now();
        DayOfWeek num = date.getDayOfWeek();
    %>
    今天是 <%= num.name()%>
</p>
<p>
    模块介绍：Basic 模块，采用最原始的 Java Web 开发。
</p>
</body>
</html>
