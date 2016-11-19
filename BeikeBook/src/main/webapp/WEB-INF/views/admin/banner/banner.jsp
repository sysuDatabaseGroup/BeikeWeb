<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>贝壳易书管理后台</title>
    <%@ include file="../meta_link_script.jsp"  %>
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

        tr>td>img{
          width: 300px;
          height: auto;
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
      
      <!-- 防止页数为空或负数 -->
      <c:if test="${empty page or page < 1}">
      	<c:set var="page" value="1"/>
      </c:if>
      
      <!--  每页显示多少个记录 -->
      <c:set var="count" value="10" />
      <fmt:parseNumber var="pagenum" integerOnly="true" type="number" value="${fn:length(banners)/count+1}" />
      
      <c:if test="${pagenum <= 1}">
      	<c:set var="pagenum" value="1"/>
      </c:if>
      
      <tbody>
		<c:forEach items="${banners}" var="i" begin="${(page-1)*count}" end="${(page-1)*count + count-1}">
			<tr>
				<td><c:out value="${i.id}" /></td>
				<td><c:out value="${i.title}" /></td>
				<td><img src="<c:url value='${i.picPath}'/>" alt="" /></td>
				<td><c:out value="${i.link}" /></td>
				<td><fmt:formatDate type="date" value="${i.datetime}" /></td>
				<td><c:out value="${i.prior}" /></td>
				<td>
				    <a href="<c:url value='/backend/banner_edit/${i.id}' />"><i class="icon-pencil"></i><span>编辑</span></a>
				    <a href="#myModal" role="button" data-toggle="modal" style="margin-left:5px;"><i class="icon-remove"></i><span>删除</span></a>
				</td>
			</tr>
		</c:forEach>
      </tbody>
    </table>
</div>

<div class="pagination">
    <ul>
   		 <c:choose>
    		<c:when test="${page == 1}">
				<li><a href="#">上一页 </a></li>
				<li><a href="#">1</a></li>
    		</c:when>
    		<c:otherwise>
				<li><a href="<c:url value='/backend/banner/${page-1}' />">上一页</a></li>
				<li><a href="<c:url value='/backend/banner/1' />">1</a></li>
				<c:if test="${page != 2}">
					<li><span>...</span></li>
					<li><a href="<c:url value='/backend/banner/${page-1}' />">${page-1}</a></li>
				</c:if>
				<li><a href="javascript:;" style="color: #6CF;">${page}</a></li>
    		</c:otherwise>
    	</c:choose>
		<c:if test="${page != pagenum}">
			<c:if test="${page+1 != pagenum}">
				<li><a href="<c:url value='/backend/banner/${page+1}' />">${page+1}</a></li>
				<li><span>...</span></li>
			</c:if>
			<li><a href="<c:url value='/backend/banner/${pagenum}' />">${pagenum}</a></li>
			<li><a href="<c:url value='/backend/banner/${page+1}' />">下一页</a></li>
		</c:if>
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
  </body>
</html>


