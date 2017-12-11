<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path +"/";
%>
<html>
<body>
<h2>Hello World!</h2>
<%= basePath %>
</body>
</html>
