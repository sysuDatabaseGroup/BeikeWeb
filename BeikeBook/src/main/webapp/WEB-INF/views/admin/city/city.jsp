<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <!-- Demo page code -->

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
            <h1 class="page-title">城市</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="<c:url value='/backend/index' />">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li class="active">城市</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="cityadd" style="color:#fff;"><button class="btn btn-primary"><i class="icon-plus"></i> 增加城市</button></a>
</div>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>城市名</th>
          <th>城市缩写</th>
          <th style="width: 100px;">操作</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach items="${cityInfos}" var="i" begin="0" end="${numOfItem}">
			<tr>
				<td><c:out value="${i.getId()}" /></td>
				<td><c:out value="${i.getName()}" /></td>
				<td><c:out value="${i.getNum()}" /></td>
				<td>
				    <a href="<c:url value='/backend/cityedit?id=${i.getId()}' />"><i class="icon-pencil"></i><span>编辑</span></a>
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
		<li><a href="cityList?pageNo=${pageNo - 1}">Prev</a>
		</li>
		</c:when>
		<c:otherwise>
		<li><a href="cityList?pageNo=${pageNo}">Prev</a>
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
		<li><a href="cityList?pageNo=${i}"><c:out value="${i}"/></a>
		</li>
		</c:otherwise>
		</c:choose>
		</c:forEach>
		<c:choose>
		<c:when test="${pageNo==maxPage}">
		<li><a href="cityList?pageNo=${pageNo}">Next</a>
		</li>
		</c:when>
		<c:otherwise>
		<li><a href="cityList?pageNo=${pageNo + 1}">Next</a>
		</li>
		</c:otherwise>
		</c:choose>
    </ul>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">删除城市？</h3>
    </div>
    <div class="modal-body">
        <p class="error-text" id="confirm_msg"><i class="icon-warning-sign modal-icon"></i>确认删除城市？</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" onclick="deleteCity()">删除</button>
    </div>
</div>
            </div>
        </div>
    </div>
	
	<script>
		function deleteConfirm(id,name){
			var msg = '<i class="icon-warning-sign modal-icon"></i>确认删除城市['+name+"]?";
			document.getElementById("confirm_msg").innerHTML = msg;
			document.getElementById("myModal").setAttribute("delete_id",id+"");
			//alert("11");
			$("#myModal").modal('show');
		}
		
		function deleteCity() {
			var params = {"id":document.getElementById("myModal").getAttribute("delete_id")};
			$.ajax({
				url: "deletecity",
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


