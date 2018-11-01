<%@ page import="java.io.PrintWriter" %>
<%@ page import="image.entity.Image" %><%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/10/24
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table>
        <tr style="text-align: left;">
            <td>标题:${image.imgtitle}</td>
            <td></td>
        </tr>
        <tr>
            <td>图片:</td>
            <td><input type="image" src="Picture/${image.imgpath}" width="20px" height="20px"></td>
        </tr>
        <tr>
            <td>发布人:${image.imgissuer}</td>
            <td></td>
        </tr>
    </table>
</body>
</html>
