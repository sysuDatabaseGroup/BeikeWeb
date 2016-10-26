<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
          width: 100px;
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
                            <li><a tabindex="-1" href="sign-in.jsp">退出</a></li>
                        </ul>
                    </li>
                </ul>
                <a class="brand" href="../index.jsp"><span class="second">贝壳易书管理后台</span></a>
        </div>
    </div>

    <div class="sidebar-nav">
        <a href="#user-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-user"></i>用户管理<i class="icon-chevron-up"></i></a>
        <ul id="user-menu" class="nav nav-list collapse">
            <li ><a href="../user/users.jsp">用户管理</a></li>
        </ul>

        <a href="#city-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-map-marker"></i>托管点管理<i class="icon-chevron-up"></i></a>
        <ul id="city-menu" class="nav nav-list collapse">
            <li ><a href="../city/city.jsp">城市管理</a></li>
            <li ><a href="../city/school.jsp">学校管理</a></li>
            <li ><a href="../city/district.jsp">托管点管理</a></li>
        </ul>

        <a href="#book-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-book"></i>书籍管理<i class="icon-chevron-up"></i></a>
        <ul id="book-menu" class="nav nav-list collapse">
            <li ><a href="../book/class.jsp">书类</a></li>
            <li ><a href="../book/books.jsp">书单</a></li>
            <li ><a href="../book/bookadd.jsp">添加书本</a></li>
        </ul>

        <a href="#order-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-star"></i>订单情况<i class="icon-chevron-up"></i></a>
        <ul id="order-menu" class="nav nav-list collapse">
            <li ><a href="../order/sell.jsp">买书<span class="label label-info" style="float:right;margin-top:2px;">+3</span></a></li>
            <li ><a href="../order/borrow.jsp">租书<span class="label label-info" style="float:right;margin-top:2px;">+3</span></a></li>
            <li ><a href="../order/allorder.jsp">全部订单（买书）</a></li>
            <li ><a href="../order/allorder_borrow.jsp">全部订单（租书）</a></li>
        </ul>

        <a href="../banner/banner.jsp" class="nav-header" ><i class="icon-gift"></i>活动推广</a>

        <a href="#money-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-star"></i>提现申请<i class="icon-chevron-up"></i></a>
        <ul id="money-menu" class="nav nav-list collapse">
            <li ><a href="../money/money.jsp">未结算</a></li>
            <li ><a href="../money/all_money.jsp">所有提现</a></li>
        </ul>

        <a href="../method/method.jsp" class="nav-header" ><i class="icon-tags"></i>配送方式</a>

        <a href="../announ/announ.jsp" class="nav-header" ><i class="icon-edit"></i>公告管理</a>
    </div>
    
    
    <div class="content">
        <div class="header">
            <h1 class="page-title">未解决订单（租书）</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
            <li>订单管理<span class="divider">/</span></li>
            <li class="active">租书</li>
        </ul>

<div class="container-fluid">
<div class="row-fluid">
                    
<div class="btn-toolbar">
<!--     <button class="btn btn-primary"><a href="booksadd.html" style="color:#fff;"><i class="icon-plus"></i> 增加书单</a></button>
    <button class="btn btn-danger"><a href="bookadd.html" style="color:#fff;"><i class="icon-plus"></i> 增加书本</a></button> -->
</div>

<div class="well">

        <table class="table">
          <thead>
            <tr>
              <th>#</th>
              <th width="150px">书名</th>
              <th>租书者</th>
              <th>数量</th>
              <th>收费</th>
              <th>配送方式</th>
              <th>取书号</th>
              <th>租书时间</th>
              <th width="80px;">状态</th>
              <th style="width:200px;">操作</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach items="${rentInfos}" var="i" begin="${pageNo*3}" end="${pageNo*3 + 3}">
				<tr>
					<td><c:out value="${i.id}" /></td>
					<td><c:out value="${i.bookClassName}" /></td>
					<td><c:out value="${i.userNum}" /></td>
					<td><c:out value="${i.num}" /></td>
					<td><c:out value="${i.prices}" /></td>
					<td><c:out value="${i.methodName}" /></td>
					<td><c:out value="${i.takeBookNum}" /></td>
					<td><c:out value="${i.datetime}" /></td>
					<td><span class="btn-danger" style="padding:5px;">
						<c:choose>
							<c:when test="${sendStatus}">已配送</c:when>
							<c:otherwise>未配送</c:otherwise>
						</c:choose></span>
					</td>
					<td>
						<a href="orderword_borrow.jsp"><i class="icon-edit"></i><span> 生成订单</span></a>
					</td>
				</tr>
			</c:forEach>
          </tbody>
        </table>

  <div class="pagination">
      <ul>
          <li><a href="borrow.jsp?pageNo=${pageNo - 1}">Prev</a></li>
          <li><span><c:out value="${pageNo}"/></span>
          <li><a href="borrow.jsp?pageNo=${pageNo + 1}"><c:out value="${pageNo + 1}"/></a></li>
          <li><a href="borrow.jsp?pageNo=${pageNo + 2}"><c:out value="${pageNo + 2}"/></a></li>
          <li><a href="borrow.jsp?pageNo=${pageNo + 3}"><c:out value="${pageNo + 3}"/></a></li>
          <li><a href="borrow.jsp?pageNo=${pageNo + 1}">Next</a></li>
      </ul>
  </div>

</div>
</div>
</div>
  </body>
</html>


