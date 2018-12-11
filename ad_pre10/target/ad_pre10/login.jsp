<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/11/24
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="resources/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#loginButton").click(function () {
                var studentName = $("#studentName").val();
                var password = $("#password").val();
                var studentId = "11";
                //这里的list是一个JSON对象
                list = {studentName:studentName,password:password,studentId:studentId};
                $.ajax({
                    type:"post",
                    url:"/LoginController",
                    //原生ajax用这个contentType发送json数据后台服务器才会接收，表单提交的contentType也是这个
                    contentType:"application/x-www-form-urlencoded;charset=utf-8",
                    data:list,
                    dataType:"json",
                    success:function x(res) {
                        //将json对象转为json字符串
                        // loginState = JSON.stringify(res);
                        //将json字符串转为JSON对象
                        // result = JSON.parse(loginState);
                        // alert(loginState+"     "+result);

                        var loginState = res.isLoginSuccess;
                        if (loginState == "true") {
                            window.localStorage.setItem("token",res.token);
                            console.log(window.localStorage.getItem("token"))
                        } else {
                            alert("请检查用户名或密码是否正确");
                        }
                        // for (var key in res){
                        //     // alert(key);
                        //     // alert(res[key]);
                        //
                        // }

                    },
                    error:function  x(res) {
                        alert("failure!")
                    }

                })
            })
        })
    </script>
    <title>Title</title>
</head>
<body>
    <table id="loginTabe" >
        <tr><td>用户名:</td><td><input type="text" id="studentName" placeholder="学生名"></td></tr>
        <tr><td>密码</td><td><input type="password" id="password" placeholder="密码"></td></tr>
        <tr><td><input type="button" id="loginButton" value="登陆"></td></tr>
    </table>
</body>
</html>
