<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/28
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dep</title>
</head>
<body>
    部门页面
    <shiro:hasPermission name="department:save">
        <a href="/department/save">部门增加</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="department:delete">
        <a href="/department/delete">部门删除</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="department:update">
        <a href="/department/update">部门修改</a>
    </shiro:hasPermission>
</body>
</html>
