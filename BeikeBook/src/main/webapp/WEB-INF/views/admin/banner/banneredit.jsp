<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <script src="<c:url value='/admin/js/ajaxfileupload.js'/>"></script>
    <script type="text/javascript">
    $(document).ready(function(){
		$("#update").click(function(){
			$.ajaxFileUpload
            (
                {
                    url: '/backend/banner_edit', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'picFile', //文件上传域的ID
                    dataType: 'txt', //返回值类型 一般设置为json
                    data : { 
                    	id : $("#id").val(),
                    	title : $("#title").val(),
                    	link : $("#link").val(),
                    	prior : $("#prior").val(),
                	},
                    success: function (data, status)  //服务器成功响应处理函数
                    {
                    	alert(data);
                        window.location.replace("/backend/banner");
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
            )
		});
		$("#delete").click(function(){
			$.post("/backend/banner_delete",{
				id : $("#id").val()
			}, function(data,status){
				alert("数据: " + data + "\n状态: " + status);
				window.location.replace('/backend/banner');
			});
		});
    });
    </script>
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
            <h1 class="page-title">编辑活动</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="<c:url value='/backend/index'/>">首页</a><span class="divider">/</span></li>
            <li>活动推广<span class="divider">/</span></li>
            <li><a href="<c:url value='/backend/banner' />">活动列表</a><span class="divider">/</span></li>
            <li class="active">活动编辑</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button id="update" class="btn btn-primary"><i class="icon-save"></i> 修改</button>
    <a href="#myModal" data-toggle="modal" class="btn">删除</a>
</div>

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">活动</a></li>
      <li><a href="#profile" data-toggle="tab">更新活动图片</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="banner">
            <input id="id" name="id" hidden="true" value="<c:out value='${id}'/>">
            <label>活动标题</label>
            <input id="title" type="text" value="${banner.title}" class="input-xlarge">
            <label>活动图片</label>
            <img src="<c:url value='${banner.picPath}' />">
            <label>活动链接</label>
            <input id="link" type="text" value="${banner.link}" class="input-xlarge">
            <label>优先级</label>
            <input id="prior" value="${banner.prior}" type="text" value="2" class="input-small">
        </form>
      </div>
      <div class="tab-pane fade" id="profile">
            <label>活动封面图</label>
            <input name="picFile" id="picFile" accept="image/*" type="file" class="file" value="浏览" >
      </div>
  </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除活动？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除活动？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button id="delete" class="btn btn-danger" data-dismiss="modal">删除</button>
  </div>
</div>
            </div>
        </div>
    </div>


