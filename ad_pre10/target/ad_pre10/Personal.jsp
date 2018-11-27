<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/11/27
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/LoginSuccessController",
                success:function x(data) {

                    student = data.student;
                    var studentName = student.studentName;
                    var age = student.age;
                    var sex = student.sex;
                    var password = student.password;
                    $("#studentName").attr("value",studentName);
                    $("#age").attr("value",age);
                    $("#password").attr("value",password);
                    if(sex == "woman") {
                        $("[value='woman']").attr("checked","checked");
                    } else {
                        $("[value='man']").attr("checked","checked");
                    }
                },
                error:function x() {
                    alert("failure!");
                }
            });
            $("#submit").click(function () {
                var message = "updateStudent";
                var id = student.id;
                var studentName = $("#studentName").val();
                var password = $("#password").val();
                var sex = $(".sex:checked").val();
                var age = $("#age").val();
                var data = {message:message,id:id,studentName:studentName,password:password,sex:sex,age:age};
                $.ajax({
                    type:"post",
                    contentType:"application/x-www-form-urlencoded;charset=utf-8",
                    data:data,
                    url:"/StudentModifyController",
                    success:function x() {
                        alert("修改成功!");
                        window.location.href = "/login.jsp"
                    },
                    error:function x() {
                        alert("failure");
                    }
                })
            });
            $("#delStudentButton").click(function () {
                var message = "delStudent";
                var id = student.id;
                var studentName = $("#studentName").val();
                var password = $("#password").val();
                var sex = $(".sex:checked").val();
                var age = $("#age").val();
                var data = {message:message,id:id,studentName:studentName,password:password,sex:sex,age:age};
                $.ajax({
                    type:"post",
                    contentType:"application/x-www-form-urlencoded;charset=utf-8",
                    data:data,
                    url:"/StudentModifyController",
                    success:function () {
                        alert("删除成功!");
                        window.location.href = "/login.jsp"
                    },
                    error:function () {
                        alert("failure");
                    }
                })
            })
        })
    </script>
</head>
<body>
    <table>
        <tr>
            <td><input type="text" id="studentName"></td>
            <td><input type="text" id="password"></td>
            <td><input type="text" id="age"></td>
            <td><input type="radio" value="man" class="sex">男&nbsp&nbsp&nbsp&nbsp<input type="radio" value="woman" class="sex">女</td>
        </tr>
        <tr><td><input type="button" id="submit" value="提交"></td>
            <td><input type="button" id="delStudentButton" value="删除个人信息"></td>
        </tr>

    </table>
</body>
</html>
