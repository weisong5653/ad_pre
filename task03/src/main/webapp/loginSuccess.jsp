<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/10/28
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="jquery-3.3.1.min.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        $(function () {
           $("#sub").click(function () {
               var content = $("#tableevaluation :checked").attr("value");
               var subject = $("#tableevaluation :checked").attr("name");
               var studentId = $("#ts :checked").attr("value");
               var teacherName = $("#teacherName").text();
               var teacherId = $("#teacherId").text();
               var list = {content:content,studentId:studentId,teacherName:teacherName,teacherId:teacherId,subject:subject};
                   $.ajax({
                       type:"post",
                       //url路径一定要加/
                       url:"/createEvaluation",
                       contentType:"application/json;charset=utf-8",
                       data:JSON.stringify(list),
                       success:function x(res) {
                           alert("提交成功!")
                           window.location.href="/TeacherEvaluationRecords.jsp";
                       },
                       error:function x(res) {
                           alert("failure!");
                       }
                   })
           })
        })
    </script>
</head>
<body>
        <table border="1px" style="text-align: center">
            <tr>
                <td>
                    <table border="1px">
                        <tr>
                            <td>姓名:</td>
                            <td id="teacherName">${teacher.teacherName}</td>
                        </tr>
                        <td>授课班级:</td>
                        <td>${teacher.className}</td>
                        </td>
                        <tr>
                            <td>当前时间:</td>
                            <td>${teacher.now}</td>
                        </tr>
                        <tr style="display: none">
                            <td>teacherID:</td>
                            <td id="teacherId">${teach.teacherId}</td>
                        </tr>
                    </table>
                    <br>
                    <h1>本班上课的同学有:</h1>
                    <table id="ts">
                        <c:forEach items="${students}" var="student">
                            <tr>
                                <td>
                                    <input type="radio" value="${student.studentId}" name="stn">
                                </td>
                                <td>${student.name}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table id="tableevaluation" border="1px">
                        <c:forEach items="${evaluations}" var="evaluation">
                            <tr>
                                <td><input type="checkbox" value="${evaluation.content}" name="${evaluation.subject}"></td>
                                <td>${evaluation.content}</td>
                                <td>${evaluation.scores}</td>
                                <td>${evaluation.subject}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td><input type="button" value="提交" id="sub"></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
</body>
</html>
