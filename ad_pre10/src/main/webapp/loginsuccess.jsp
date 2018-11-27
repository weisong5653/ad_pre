<%--
  Created by IntelliJ IDEA.
  User: weisong5653
  Date: 2018/11/20
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link href="resources/css/bodycss.css" rel="stylesheet">--%>
    <script src="resources/jquery-3.3.1.min.js"></script>
    <style type="text/css">
        .headimg{
            width: 20px;
            height: 20px;
        }
        table{
            border: solid 1px #666;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            //请求论文数据
            $.ajax({
                type:"post",
                url:"/LoginSuccessController",
                dataType:"json",
                success:function (data) {
                    var student = data.student;
                    listThesis = data.listThesis;
                    var studentName  = student.studentName;
                    $("#studentName").attr("value",studentName);
                    for (var i = 0;i < listThesis.length;i++) {
                        var trHTML = "<tr><td>"+listThesis[i].title+"</td><td>"+listThesis[i].publicTime+"</td><td><input type='checkbox' class='delList' id = 'thesis"+listThesis[i].id+"'value='"+listThesis[i].id+"' </td></tr>"
                        $("#thesisTable").append(trHTML);
                        // alert(listThesis[i].content);
                    }
                    // $("#studentName").text(data[studentName]);
                },
                error:function (data) {
                    alert(data["student"]);
                    alert("拉取数据失败");
                }
            });

            //点击论文所在行查看论文
            $("table tbody").on("click","tr",function () {
                var index = $(this).index();
                var content = listThesis[index].content;
                alert(content);
            })

            //添加论文
            $("#addRegisteButton").click(function () {
                window.location.href="makethesis.jsp";
            })
            //删除论文
            $("#delThesisButton").click(function () {

                var delList = new Array();
                //遍历选中的复选框
                $("input[type='checkbox']:checkbox:checked").each(function(i,d){
                    delList.push(d.value);
                });
                var list = {delList:delList};
                $.ajax({
                    type:"post",
                    contentType:"application/x-www-form-urlencoded;charset=utf-8",
                    url:"/DelThesisController",
                    data:list,
                    traditional: true,
                    dataType:"json",
                    success:function (data) {
                        alert("删除成功");
                        delListThesised = data.delListThesised;
                        for (var i =0;i < delListThesised.length;i++) {
                            var thesisid = "thesis"+delListThesised[i];
                            $("#"+thesisid).parent().parent().remove();
                        }
                    },
                    error:function () {
                        alert("failure!");
                    }
                })
            })

            // 编辑论文
            $("#modificationThesisButton").click(function () {
                var delList = new Array();
                //遍历选中的复选框
                $("input[type='checkbox']:checkbox:checked").each(function(i,d){
                    delList.push(d.value);
                });
                if (delList.length>=2) {
                    alert("请只选择一篇论文进行修改");
                } else {
                    var thesisId = delList[0];
                    for (var i = 0;i < listThesis.length;i++) {
                        if (listThesis[i].id == thesisId) {
                            $("#modificationThesisDiv").css("display","block");
                            $("#modificationThesisSpace").val(listThesis[i].content);
                            $("#thesisTitle").val(listThesis[i].title);
                        }
                        // alert(listThesis[i].content);
                    }

                }
            })
        //     确定修改论文
            $("#modificationThesisEnsureButton").click(function () {
                var delList = new Array();
                //遍历选中的复选框
                $("input[type='checkbox']:checkbox:checked").each(function(i,d){
                    delList.push(d.value);
                });

                var thesisId = delList[0];
                for (var i = 0;i < listThesis.length;i++) {
                    if (listThesis[i].id == thesisId) {
                        listThesis[i].title = $("#thesisTitle").val();
                        listThesis[i].content = $("#modificationThesisSpace").val();
                        //这里的thesisModifion就是一个JSON对象,所以data那里直接传
                        var thesisModifion = listThesis[i];
                        // var thesis = {thesisModifion:thesisModifion};
                        $.ajax({
                            type:"post",
                            contentType:"application/x-www-form-urlencoded;charset=utf-8",
                            url:"/ThesisModifierController",
                            data:thesisModifion,
                            success:function () {
                                alert("修改成功");
                                $("#modificationThesisDiv").css("display","none");
                            },
                            error:function () {
                                alert("failure");
                            }
                        })
                    }
                }
            })

        //    取消修改论文
            $("#modificationThesisCacelButton").click(function () {
                $("#modificationThesisDiv").css("display","none");
            })

            //跳转修改个人信息
            $("#modificationPersonalButton").click(function () {
                window.location.href = "Personal.jsp";
            })

        })
    </script>
    <title>写论文</title>
</head>
<body>
    <div id="modificationThesisDiv" style="padding:0px; position: absolute;top: 30%;left: 30%;width: 50%;height: 50%; display:none; float: left">
        <table style="width: 50%;height: 50%">
            <tr><td><input type="text" style="width: 100%" id="thesisTitle"></td>
            <tr><td><textarea id="modificationThesisSpace" cols="60" rows="35"></textarea></td>
            </tr>
        </table>
        <tr>
            <td><input type="button" value="确定" id="modificationThesisEnsureButton"></td>
            <td><input type="button" value="取消" id="modificationThesisCacelButton"></td>
        </tr>


    </div>
    <div>
        <table id="thesisTable" style="text-align: center">
            <thead>
                <tr><td><input type="image" src="resources/pictures/mountain.jpg" class="headimg"></td>
                    <td><input type="text" id="studentName" style="border: none"  readonly="readonly"></td>
                </tr>
                <tr>
                    <th>标题</th>
                    <th>发表时间</th>
                    <th></th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
        <input type="button" id="modificationPersonalButton" value="修改个人信息">
        <input type="button" id="delThesisButton" value="删除">
        <input type="button" id="addRegisteButton" value="添加论文">
        <input type="button" id="modificationThesisButton" value="修改">
    </div>
</body>
</html>
