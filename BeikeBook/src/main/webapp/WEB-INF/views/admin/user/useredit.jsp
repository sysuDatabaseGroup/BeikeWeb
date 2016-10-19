<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>贝壳易书管理后台</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
    <link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">
    <script src="../lib/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="../lib/bootstrap/js/bootstrap.js"></script>
    <script src="../js/main.js"></script>
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
        strong{
          padding: 5px;
        }

        label{
          padding-top: 5px;
        }
    </style>
	<script type="text/javascript">
		function saveUser() {
			var city = document.getElementById("DropDownCity").value;
			var cityNum = city.options[city.selectedIndex].value;
			var school = document.getElementById("DropDownSchool").value;
			var cityNum = school.options[school.selectedIndex].value;
			var domitory = document.getElementById("DropDownDorm").value;
			var dorm = domitory.options[domitory.selectedIndex].value;
		}
	</script>
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
    <h1 class="page-title">用户编辑</h1>
  </div>
  <ul class="breadcrumb">
    <li><a href="../index.jsp">首页</a> <span class="divider">/</span></li>
    <li><a href="users.jsp">用户管理</a> <span class="divider">/</span></li>
    <li class="active">用户编辑</li>
  </ul>

  <div class="container-fluid">
    <div class="row-fluid">
      <div class="btn-toolbar">
          <button class="btn btn-primary"><i class="icon-save"></i> 保存</button>
      </div>
      <div class="well">
        <div id="myTabContent" class="tab-content">
          <div class="tab-pane active in" id="home">
          <form id="user">
              <label>用户名</label>
              <strong><c:out value="${userNum}"/></strong>

              <label>用户编号</label>
              <strong><c:out value="${userNo}"/></strong>

              <label>城市</label>
              <select name="DropDownTimezone" id="DropDownCity" class="input-xlarge">
                <option value="0">未选择</option>
                <option value="1" selected="<c:if test="${cityNum == 1}">selected</c:if>">广州</option>
              </select>

              <label>学校</label>
              <select name="DropDownTimezone" id="DropDownSchool" class="input-xlarge">
                <option value="0">未选择</option>
                <option value="1" selected="<c:if test="${schoolNum == 1}">selected</c:if>">中山大学</option>
              </select>

              <label>宿舍</label>
              <select name="DropDownTimezone" id="DropDownDorm" class="input-xlarge">
                <option value="0">未选择</option>
                <option value="1" selected="<c:if test="${fn:contains(dorm, '至善园1号')}"><c:out value="selected"/></c:if>">至善园1号</option>
                <option value="2" selected="<c:if test="${fn:contains(dorm, '至善园2号')}"><c:out value="selected"/></c:if>">至善园2号</option>
              </select>
          </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
    
</body>
</html>