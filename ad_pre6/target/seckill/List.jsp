<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="image.entity.Image" %><%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/10/24
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--这个..在这里很重要，不加的话找不到这个jquery库--%>
    <script src="../jquery-3.3.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("tr").click(function () {
                var td = $( this ).find(  "td" );
                imgid = td.eq(0).text();
                imgpath = td.eq(1).attr("title");
                imgtitle= td.eq(2).text();
                imgissuer= td.eq(3).text();
                mylist = {imgid:imgid,imgpath:imgpath,imgtitle:imgtitle,imgissuer:imgissuer}
                $.ajax({
                    type:"post",
                    //url路径一定要加/
                    url:"/todetail",
                    contentType:"application/json; charset=utf-8",
                    data:JSON.stringify(mylist),
                    success:function x(res) {
                        window.location.href="/detail.jsp";
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
    <%--${list.get(0).imgissuer}--%>

    <form id="form2" method="post" action="../Add.jsp">
        <input type="submit" value="Add">
    </form>

    <form id="form3" method="post">
        <table border="1px"width="30%" style="text-align: center">
            <tr>
                <th>序号</th>
                <th>图片</th>
                <th>标题</th>
                <th>发布人</th>
            </tr>
            <c:forEach items="${list}" var="list">
                <tr>
                    <td>${list.imgid}</td>
                    <td  title="${list.imgpath}"><input type="image" src="/Picture/${list.imgpath}" width="20px"height="20px"></td>
                    <td>${list.imgtitle}</td>
                    <td>${list.imgissuer}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <p>
        <%--..的原因是返回上一层，否则第二次请求<a>元素时会404--%>
        <a href="../List/0">首页    </a>
        <a href="../List/1">1   </a>
        <a href="../List/2">2   </a>
        <a href="../List/3">3   </a>
        <a href="../List/4">4   </a>
        <a href="../List/5">5   </a>
        <a href="../List/6">6   </a>
        <a href="../List/7">7   </a>
        <a href="../List/8">8   </a>
        <a href="../List/9">9   </a>
        <a href="../List/10">10  </a>
        <a href="../List/11">末页</a>
    </p>
</body>

</html>