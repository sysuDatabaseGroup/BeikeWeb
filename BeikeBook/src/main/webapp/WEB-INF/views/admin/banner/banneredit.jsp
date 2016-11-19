<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>贝壳易书管理后台</title>
    <%@ include file="../meta_link_script.jsp"  %>
    <script src="<c:url value='/admin/js/ajaxfileupload.js'/>"></script>
    <script type="text/javascript">
    $(document).ready(function(){
		$("#update").click(function(){
			$.ajaxFileUpload
            (
                {
                    url: '/BeikeBook/backend/banner_edit', //用于文件上传的服务器端请求地址
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

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
   <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i><c:out value="${districtAddrStr}" default="广州-中山大学-斋区托管点" />
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">我的账户信息</a></li>
                            <li><a tabindex="-1" href="#">退出</a></li>
                        </ul>
                    </li>
                </ul>
                <a class="brand" href="<c:url value='/backend/index'/>"><span class="second">贝壳易书管理后台</span></a>
        </div>
    </div>

<div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-user"></i>用户管理<i class="icon-chevron-up"></i></a>
        <ul id="dashboard-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/users' />">用户管理</a></li>
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-map-marker"></i>托管点管理<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/city' />">城市管理</a></li>
            <li ><a href="<c:url value='/backend/school' />">学校管理</a></li>
            <li ><a href="<c:url value='/backend/district' />">托管点管理</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-book"></i>书籍管理<i class="icon-chevron-up"></i></a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/book_category' />">书类</a></li>
            <li ><a href="<c:url value='/backend/books' />">书单</a></li>
            <li ><a href="<c:url value='/backend/booksadd' />">添加书本</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-star"></i>订单情况<i class="icon-chevron-up"></i></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/sell' />">出售<span class="label label-info" style="float:right;margin-top:2px;">+3</span></a></li>
            <li ><a href="<c:url value='/backend/rent' />">出租<span class="label label-info" style="float:right;margin-top:2px;">+3</span></a></li>
            <li ><a href="<c:url value='/backend/selling_order' />">全部订单（买书）</a></li>
            <li ><a href="<c:url value='/backend/renting_order' />">全部订单（租书）</a></li>
        </ul>

        <a href="<c:url value='/backend/banner' />" class="nav-header" ><i class="icon-gift"></i>活动推广</a>

        <a href="#money-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-star"></i>提现申请<i class="icon-chevron-up"></i></a>
        <ul id="money-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/encashment' />">未结算</a></li>
            <li ><a href="<c:url value='/backend/all_encashment' />">所有提现</a></li>
        </ul>

        <a href="<c:url value='/backend/method' />" class="nav-header" ><i class="icon-tags"></i>配送方式</a>

        <a href="<c:url value='/backend/announ' />" class="nav-header" ><i class="icon-edit"></i>公告管理</a>
    </div>    
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
    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除活动［义务助学活动］？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button id="delete" class="btn btn-danger" data-dismiss="modal">删除</button>
  </div>
</div>
            </div>
        </div>
    </div>
  </body>
</html>


