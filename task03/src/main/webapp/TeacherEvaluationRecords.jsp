<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/10/28
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px solid">
        <c:forEach items="${teacherEvaluationRecords}" var="teacherEvaluationre">
            <tr>
                <td>${teacherEvaluationre.subject}</td>
                <td>${teacherEvaluationre.content}</td>
                <td>${teacherEvaluationre.score}</td>
                <td>${teacherEvaluationre.time}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
