<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <h1 class="page-title">学校</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li><a href="school.jsp">学校</a><span class="divider">/</span></li>
            <li class="active">编辑学校</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary"><i class="icon-save"></i> 修改</button>
    <a href="#myModal" data-toggle="modal" class="btn">删除</a>
</div>

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">基础信息</a></li>
      <li><a href="#profile" data-toggle="tab">密码</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="school">
            <label>学校</label>
            <input type="text" value="${schoolName}" class="input-xlarge">
            <label>学校缩写</label>
            <input type="text" value="${schoolAbbreviate}" class="input-xlarge">
            <label>所在城市</label>
            <select name="DropDownTimezone" id="DropDownDorm" class="input-xlarge">
              <option value="0">未选择</option>
              <option value="1" <c:if test="${cityNum == 1}"><c:out value='selected="selected"'/></c:if>>广州</option>
              <option value="2" <c:if test="${cityNum == 2}"><c:out value='selected="selected"'/></c:if>>上海</option>
              <option value="3" <c:if test="${cityNum == 3}"><c:out value='selected="selected"'/></c:if>>深圳</option>
            </select>
            <label>管理账号</label>
            <strong><c:out value="${schoolAdmin}"/></strong>
        </form>
      </div>
      <div class="tab-pane fade" id="profile">
        <form id="tab2">
            <label>输入新密码</label>
            <input type="password" id="password" class="input-xlarge">
            <label>确认新密码</label>
            <input type="password" id="repassword" class="input-xlarge">
        </form>
      </div>
    </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除学校？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除学校［深圳大学］？</p>
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


