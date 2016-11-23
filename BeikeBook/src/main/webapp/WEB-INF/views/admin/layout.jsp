<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>贝壳易书管理后台</title>
    <%@ include file="meta_link_script.jsp"  %>
    <!-- Demo page code -->

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
                            <!--<li><a tabindex="-1" href="#">我的账户信息</a></li>-->
                            <li><a tabindex="-1" href="<c:url value='/backend/logout' />">退出</a></li>
                        </ul>
                    </li>
                </ul>
                <a class="brand" href="<c:url value='/backend/index' />"><span class="second">贝壳易书管理后台</span></a>
        </div>
    </div>
	
    <div class="sidebar-nav">
        <a href="#user-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-user"></i>用户管理<i class="icon-chevron-up"></i></a>
        <ul id="user-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/userList' />">用户管理</a></li>
        </ul>

        <a href="#city-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-map-marker"></i>托管点管理<i class="icon-chevron-up"></i></a>
        <ul id="city-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/cityList' />">城市管理</a></li>
            <!--<li ><a href="<c:url value='/backend/schoolList' />">学校管理</a></li>-->
            <li ><a href="<c:url value='/backend/districtList' />">托管点管理</a></li>
        </ul>

        <a href="#book-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-book"></i>书籍管理<i class="icon-chevron-up"></i></a>
        <ul id="book-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/categoryList' />">书类</a></li>
            <li ><a href="<c:url value='/backend/booksList' />">书单</a></li>
            <li ><a href="<c:url value='/backend/dealedbookadd' />">添加托管书本</a></li>
        </ul>

        <a href="#order-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-star"></i>订单情况<i class="icon-chevron-up"></i></a>
        <ul id="order-menu" class="nav nav-list collapse">
            <li ><a href="<c:url value='/backend/sellOrderList' />">待处理（买书）</a></li>
            <li ><a href="<c:url value='/backend/rentOrderList' />">待处理（租书）</a></li>
            <li ><a href="<c:url value='/backend/totalSellOrderList' />">全部订单（买书）</a></li>
            <li ><a href="<c:url value='/backend/totalRentOrderList' />">全部订单（租书）</a></li>
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
	
<c:import url="${page}"></c:import>
  </body>
</html>
