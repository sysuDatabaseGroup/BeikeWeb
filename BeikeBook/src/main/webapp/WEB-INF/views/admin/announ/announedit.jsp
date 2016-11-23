<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    $(document).ready(function(){
		$("#update").click(function(){
			$.post("/backend/announ_edit",{
				id : $("#id").val(),
				title : $("#title").val(),
				content : $("#content").val()
			}, function(data,status){
				alert(data);
				window.location.replace('/backend/announ');
			});
		});
		$("#delete").click(function(){
			$.post("/backend/announ_delete",{
				id : $("#id").val()
			}, function(data,status){
				alert(data);
				window.location.replace('/backend/announ');
			});
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
            <h1 class="page-title">编辑公告</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="<c:url value="/backend/index" />">首页</a><span class="divider">/</span></li>
            <li>公告管理<span class="divider">/</span></li>
            <li><a href="<c:url value="/backend/announ" />">公告</a><span class="divider">/</span></li>
            <li class="active">编辑公告</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button id="update" class="btn btn-primary"><i class="icon-save"></i> 修改</button>
    <a href="#myModal" data-toggle="modal" class="btn">删除</a>
</div>

<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        	<input id="id" name="id" hidden="true" value="<c:out value='${id}'/>">
            <label>公告标题</label>
            <input id="title" name="title" type="text" value="<c:out value='${announ.title}' />" class="input-xlarge">
            <label>公告内容</label>
            <textarea id="content" name="content" class="input-xlarge"><c:out value='${announ.title}' /></textarea>
      </div>
  </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除公告？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除公告？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button id="delete" class="btn btn-danger" data-dismiss="modal">删除</button>
  </div>
</div>
            </div>
        </div>
    </div>



