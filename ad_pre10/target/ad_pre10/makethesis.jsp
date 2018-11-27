<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/11/23
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="resources/jquery-3.3.1.min.js"></script>
    <%--<link href="resources/css/bodycss.css">--%>
    <script type="text/javascript">
        $(function () {
            $("#addThesisButton").click(function () {
                var publicTime = getTime();
                var title = $("#title").val();
                var content = $("#content").val();
                var
                list = {title:title,content:content,publicTime:publicTime}
                $.ajax({
                    type:"post",
                    url:"/createThesis",
                    contentType : "application/x-www-form-urlencoded;charset=utf-8",
                    data:list,
                    success:function x(res){
                        alert("提交成功!");
                        window.location.href= "loginsuccess.jsp";
                    },
                    error:function x(res) {
                        alert("failure!");
                    }
                })
            })
        })
        function regular(s) {
            return s < 10 ? '0' + s: s;
        }
        function getTime() {
            var myDate = new Date();//获取当前年
            var year=myDate.getFullYear();//获取当前月
            var month=myDate.getMonth()+1;//获取当前日
            var date=myDate.getDate();
            var h=myDate.getHours();       //获取当前小时数(0-23)
            var m=myDate.getMinutes();     //获取当前分钟数(0-59)
            var s=myDate.getSeconds();
            var now=year+'-'+regular(month)+"-"+regular(date)+" "+regular(h)+':'+regular(m)+":"+regular(s);
            return now;
        }
    </script>
    <style type="text/css">
        textarea{
            width: 300px;
            height: 300px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>
                标题:<input type="text" placeholder="标题" id="title">
            </td>
        </tr>
        <tr>
            <td>
                <textarea id="content"></textarea>
            </td>
        </tr>
        <tr>
            <td><input type="button" id="addThesisButton" value="提交"></td>
        </tr>
    </table>
</body>
</html>
