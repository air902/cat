<%--
  Created by IntelliJ IDEA.
  User: ko
  Date: 2020/5/2
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="/transfer/front/LoginServlet" method="post"><h1><a href="index.jsp"><img src="img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="name" value="" placeholder="账号"></p>
        <p><input type="text" name="password" value="" placeholder="密码"></p>
        <p>
            <input style="width: 15px;height: 15px" type="radio" name="rank" value="玩家" checked="checked">玩家
            <input style="width: 15px;height: 15px" type="radio" name="rank" value="战队管理层" checked="checked">战队管理层
        </p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.html">免费注册</a><a href="forget.html">忘记密码？</a></p></form>
</div>
</body>
</html>