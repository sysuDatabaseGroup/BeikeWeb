<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
    
    
    <div class="content">
        <div class="header">
            <h1 class="page-title">学校</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li class="active">学校</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="schooladd" style="color:#fff;"><button class="btn btn-primary"><i class="icon-plus"></i> 增加学校</button></a>
</div>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>学校</th>
          <th>城市</th>
          <th>学校缩写</th>
          <th>学校账号</th>
          <th style="width: 100px;">操作</th>
        </tr>
      </thead>
      <tbody>
	      <c:forEach items="${schoolInfos}" var="i" begin="0" end="${numOfItem}">
				<tr>
					<td><c:out value="${i.getId()}" /></td>
					<td><c:out value="${i.getName()}" /></td>
					<td><c:out value="${cities.get(i.getId())}" /></td>
					<td><c:out value="${i.getNum()}" /></td>
					<td><c:out value="${i.getAdmin()}" /></td>
					<td>
					    <a href="schooledit?id=${i.getId()}"><i class="icon-pencil"></i><span>编辑</span></a>
					    <a onclick="deleteConfirm(${i.getId()},'${i.getName()}');return false;" href="" style="margin-left:5px;"><i class="icon-remove"></i><span>删除</span></a>
					</td>
				</tr>
			</c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
		<c:choose>
		<c:when test="${pageNo > 1}">
		<li><a href="schoolList?pageNo=${pageNo - 1}">Prev</a>
		</li>
		</c:when>
		<c:otherwise>
		<li><a href="schoolList?pageNo=${pageNo}">Prev</a>
		</li>
		</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${beginPage}" end="${maxPage}">
		<c:choose>
		<c:when test="${i==pageNo}">
		<li><span><c:out value="${pageNo}"/></span>
		</li>
		</c:when>
		<c:otherwise>
		<li><a href="schoolList?pageNo=${i}"><c:out value="${i}"/></a>
		</li>
		</c:otherwise>
		</c:choose>
		</c:forEach>
		<c:choose>
		<c:when test="${pageNo==maxPage}">
		<li><a href="schoolList?pageNo=${pageNo}">Next</a>
		</li>
		</c:when>
		<c:otherwise>
		<li><a href="schoolList?pageNo=${pageNo + 1}">Next</a>
		</li>
		</c:otherwise>
		</c:choose>
    </ul>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">删除学校？</h3>
    </div>
    <div class="modal-body">
        <p id="confirm_msg" class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除学校［深圳大学］？</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" onclick="deleteSchool()">删除</button>
    </div>
</div>
            </div>
        </div>
    </div>
	<script>
		function deleteConfirm(id,name){
			var msg = '<i class="icon-warning-sign modal-icon"></i>确认删除学校['+name+"]?";
			document.getElementById("confirm_msg").innerHTML = msg;
			document.getElementById("myModal").setAttribute("delete_id",id+"");
			//alert("11");
			$("#myModal").modal('show');
		}
		
		function deleteSchool() {
			var params = {"id":document.getElementById("myModal").getAttribute("delete_id")};
			$.ajax({
				url: "deleteschool",
				type: "POST",
				dataType: "json",
				data: params,
				success: function(res){
					if(res.code == 0){
						location.reload(true);
					}
					else{
						alert(res.msg);
					}
				},
			});
		}
	</script>


