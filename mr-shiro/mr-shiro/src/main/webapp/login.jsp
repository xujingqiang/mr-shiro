<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/25
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        登陆页面
    ${errorMsg}
    <form href="/login" method="post">
        用户名<input name="username">
        <br>
        密码<input type="password" name="password">
        <br>
        <input type="submit">
    </form>
</body>
</html>
