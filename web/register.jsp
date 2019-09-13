<%--
  Created by IntelliJ IDEA.
  User: ShenMouMou
  Date: 2019/9/13
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">

    <table border="1" cellspacing="0" cellpadding="" align="center" width="60%" height="80%">
        <caption><h1>用户注册</h1></caption>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="password" />
                <img src="${pageContext.request.contextPath}/checkcode" onclick="changeImag()" id="myimg"/>
            </td>
        </tr>
        <tr>

            <td colspan="2" align="center"><input type="submit" value="注册" />

            </td>
        </tr>
    </table>
</form>

<script>
    function changeImag() {
        document.getElementById("myimg").src= "${pageContext.request.contextPath}/checkcode?time="+new Date().getTime();
    }


</script>

</body>
</html>
