<%--
  Created by IntelliJ IDEA.
  User: ink
  Date: 17-9-22
  Time: 下午6:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面测试</title>
</head>
<body>

    <h2>测试测试</h2>
    <%
        class testFunction{
            int a;
            double b;

            int sumNum(int a,int b) {
                return a + b;
            }
        }

        testFunction tf = new testFunction();
        tf.a = 5;
        tf.b = 55.555;

        int a = 6;
        int b = 6;
        int c = tf.sumNum(a,b);
    %>


    <%= "jsp语言 测试测试<br>"%>
    <%--不知道怎么一次输出多个值--%>
    <%= c%>
    <%--服务器端跳转--%>
    <jsp:forward page="cheakTest.jsp">
        <jsp:param name="testA" value="你好呀" />
        <jsp:param name="testB" value="Hello" />
    </jsp:forward>


</body>
</html>
