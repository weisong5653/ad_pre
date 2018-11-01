<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/10/27
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="login" action="/dologin" method="post">
        <table>
            <tr>
                <td>账号:</td>
                <td><input type="text" name="teacherName" ></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
