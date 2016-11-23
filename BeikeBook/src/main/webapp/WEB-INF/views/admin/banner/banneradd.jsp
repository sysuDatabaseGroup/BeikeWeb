<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="../meta_link_script.jsp"  %>
    <script src="<c:url value='/admin/js/ajaxfileupload.js'/>"></script>
    <script type="text/javascript">
    $(document).ready(function(){
		$("#add").click(function(){
			$.ajaxFileUpload
            (
                {
                    url: '/BeikeBook/backend/banner_add', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'picFile', //文件上传域的ID
                    dataType: 'txt', //返回值类型 一般设置为json
                    data : { 
                    	title : $("#title").val(),
                    	link : $("#link").val(),
                    	prior : $("#prior").val(),
                	},
                    success: function (data, status)  //服务器成功响应处理函数
                    {
                    	alert("数据: " + data + "\n状态: " + status);
                        window.location.replace("/BeikeBook/backend/banner");
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
            )
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
            <h1 class="page-title">新增活动</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="<c:url value='/backend/index'/>">首页</a><span class="divider">/</span></li>
            <li>活动推广<span class="divider">/</span></li>
            <li><a href="<c:url value="/backend/banner" />">活动列表</a><span class="divider">/</span></li>
            <li class="active">添加活动</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button id="add" class="btn btn-primary"><i class="icon-save"></i> 添加</button>
</div>
<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
            <label>活动标题</label>
            <input id="title" type="text" class="input-xlarge">
            <label>活动链接</label>
            <input id="link" type="text" class="input-xlarge">
            <label>活动封面图</label>
            <input name="picFile" id="picFile" accept="image/*" type="file" class="file" value="浏览" >
            <label>排序</label>
            <input id="prior" type="text" class="input-small"><span> 输入数字，范围在”1-99“</span>
      </div>
  </div>

</div>
            </div>
        </div>
    </div>


