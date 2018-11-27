<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/11/20
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/css/bodycss.css" rel="stylesheet">
    <script src="resources/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#registeButton").click(function () {
                var studentName = $("#studentName").val();
                var password = $("#password").val();
                var age = $("#age").val();
                var sex = $(".sex:checked").val();
                list = {studentName:studentName,password:password,age:age,sex:sex};
                $.ajax({
                    type:"post",
                    //application/json;charset=utf-8的话request无法拿到参数值
                    contentType : "application/x-www-form-urlencoded;charset=utf-8",
                    // contentType : "application/json;charset=utf-8",
                    url:"/RegisteController",
                    data:list,
                    success:function x(res) {
                        alert("注册成功!");
                        window.location.href = "loginsuccess.jsp" ;
                    },
                    error:function x(res) {
                        alert("failure!");
                    }
                })
            })
        })
    </script>
    <title>Title</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <td>名字:<input type="text" placeholder="name" id="studentName" name="studentName"></td>
                <td>密码:<input type="password" placeholder="password" id="password" name="password"></td>
                <td>年龄:<input type="text" placeholder="请输入您的年龄" id="age" name="age"></td>
                <td>性别:<input type="radio"  class="sex" name="sex" value="man">男&nbsp&nbsp
                        <input type="radio" name="sex" class="sex" value="woman">女</td>
            </tr>
            <tr style="text-align: center">
                <td colspan="4"><input type="button" id="registeButton" value="注册"></td>
            </tr>
        </table>
    </div>
</body>
</html>
