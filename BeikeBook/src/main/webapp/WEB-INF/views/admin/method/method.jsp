<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    $(document).ready(function(){
    	$(".delete").click(function(){
    	   if(confirm("确认删除")){
    		   $.post("/backend/method_delete",{
      				id : $(this).val()
   	   			}, function(data,status){
   	   				alert(data);
   	   				window.location.replace('/backend/method');
   	   			});
    	   }
    	});
    });
    </script>
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
            <h1 class="page-title">配送方式</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="<c:url value="/backend/index" />">首页</a><span class="divider">/</span></li>
            <li>配送管理<span class="divider">/</span></li>
            <li class="active">配送方式</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="<c:url value='/backend/method_add'/>" style="color:#fff;"><button class="btn btn-primary"><i class="icon-plus"></i> 增加方式</button></a>
</div>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>配送方式</th>
          <th>收费</th>
          <th style="width: 100px;">操作</th>
        </tr>
      </thead>
      
      <tbody>
		<c:forEach items="${methods}" var="i">
			<tr>
				<td><c:out value="${i.id}" /></td>
				<td><c:out value="${i.name}" /></td>
				<td><c:out value="${i.price}" /></td>
				<td>
				    <a href="<c:url value='/backend/method_edit/${i.id}' />"><i class="icon-pencil"></i><span>编辑</span></a>
				    <button class="delete" value="${i.id}"><i class="icon-remove"></i><span>删除</span></button>
				</td>
			</tr>
		</c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
    </ul>
</div>

            </div>
        </div>
    </div>


