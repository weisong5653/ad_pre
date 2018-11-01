<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/10/23
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-3.3.1.min.js"></script>
</head>
<body>
    <form name="form1" enctype="multipart/form-data" action="/createimg" method="post">
        <table>
            <tr>
                <td>标题</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>图片</td>
                <td><input type="file" name="image"></td>
            </tr>
            <tr>
                <td><input type="submit" value="保存"></td>
            </tr>
        </table>
    </form>

</body>
</html>
