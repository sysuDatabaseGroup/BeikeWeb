<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script type="text/javascript">
    $(document).ready(function(){
    	$(".delete").click(function(){
    	   if(confirm("确认删除")){
    		   $.post("/backend/banner_delete",{
      				id : $(this).val()
   	   			}, function(data,status){
   	   				alert(data);
   	   				window.location.replace('/backend/banner');
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

        tr>td>img{
          width: 300px;
          height: auto;
        }
    </style>
    
    <div class="content">
        <div class="header">
            <h1 class="page-title">活动推广</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="<c:url value='/backend/index'/>">首页</a><span class="divider">/</span></li>
            <li>活动推广<span class="divider">/</span></li>
            <li class="active">活动列表</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="<c:url value='/backend/banner_add'/>" style="color:#fff;"><button class="btn btn-danger"><i class="icon-plus"></i> 增加活动</button></a>
</div>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th width="150px">活动标题</th>
          <th>活动图片</th>
          <th>活动链接</th>
          <th>添加日期</th>
          <th>优先级</th>
          <th style="width:100px;">操作</th>
        </tr>
      </thead>
      
      <tbody>
		<c:forEach items="${banners}" var="i">
			<tr>
				<td><c:out value="${i.id}" /></td>
				<td><c:out value="${i.title}" /></td>
				<td><img src="<c:url value='${i.picPath}'/>" alt="" /></td>
				<td><c:out value="${i.link}" /></td>
				<td><fmt:formatDate type="date" value="${i.datetime}" /></td>
				<td><c:out value="${i.prior}" /></td>
				<td>
				    <a href="<c:url value='/backend/banner_edit/${i.id}' />"><i class="icon-pencil"></i><span>编辑</span></a>
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

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">删除活动？</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除活动［义务助学活动］？</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" data-dismiss="modal">删除</button>
    </div>
</div>
            </div>
        </div>
    </div>


