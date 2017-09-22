<%--
  Created by IntelliJ IDEA.
  User: ink
  Date: 17-9-22
  Time: 下午7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>check测试界面</title>
</head>
<body>
    <%--测试页面跳转--%>
    <h3>check check check</h3>

    <%
        String ins = request.getParameter("testA");
    %>

    <%= ins%>
</body>
</html>
