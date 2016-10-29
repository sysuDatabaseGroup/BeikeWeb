<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE jsp>
<jsp lang="en">
<head>
	<title>贝壳易书管理后台</title>
	<%@ include file="meta_link_script.jsp"  %>
<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}

#newbook-list>tr>td:nth-child(2) {
	max-width: 150px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

#newbook-list>tr>td:nth-child(3) {
	padding-left: 20px;
}

#widget1container>p {
	text-indent: 2em;
	line-height: 1.4em;
	padding: 15px 0 5px 0;
}
</style>

<!-- Le jsp5 shim, for IE6-8 support of jsp5 elements -->
<!--[if lt IE 9]>
      <script src="http://jsp5shim.googlecode.com/svn/trunk/jsp5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value='/admin/lib/font-awesome/docs/assets/ico/apple-touch-icon-144-precomposed.png'/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value='/admin/lib/font-awesome/docs/assets/ico/apple-touch-icon-114-precomposed.png'/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value='/admin/lib/font-awesome/docs/assets/ico/apple-touch-icon-72-precomposed.png'/>">
<link rel="apple-touch-icon-precomposed"
	href="<c:url value='/admin/lib/font-awesome/docs/assets/ico/apple-touch-icon-57-precomposed.png'/>">
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
		<c:if test="${loginStatus}">
			<ul class="nav pull-right">
				<li id="fat-menu" class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i><c:out value="${districtAddrStr}" default="广州-中山大学-斋区托管点" /> <i class="icon-caret-down"></i> </a>

					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="#">我的账户信息</a></li>
						<li><a tabindex="-1" href="/backend/logout">退出</a></li>
					</ul>
				</li>
			</ul>
		</c:if>
			<div class="brand">
				<span class="second">贝壳易书管理后台</span>
			</div>
		</div>
	</div>

	<div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-user"></i>用户管理<i class="icon-chevron-up"></i></a>
        <ul id="dashboard-menu" class="nav nav-list collapse">
            <li ><a href="user/users.jsp">用户管理</a></li>
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-map-marker"></i>托管点管理<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="city/city.jsp">城市管理</a></li>
            <li ><a href="city/school.jsp">学校管理</a></li>
            <li ><a href="city/district.jsp">托管点管理</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-book"></i>书籍管理<i class="icon-chevron-up"></i></a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="book/class.jsp">书类</a></li>
            <li ><a href="book/books.jsp">书单</a></li>
            <li ><a href="book/bookadd.jsp">添加书本</a></li>
        </ul>

        <a href="#accounts-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-star"></i>订单情况<i class="icon-chevron-up"></i></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="sign-in.jsp">出售<span class="label label-info" style="float:right;margin-top:2px;">+3</span></a></li>
            <li ><a href="sign-up.jsp">出租<span class="label label-info" style="float:right;margin-top:2px;">+3</span></a></li>
            <li ><a href="order/allorder.jsp">全部订单（买书）</a></li>
            <li ><a href="order/allorder_borrow.jsp">全部订单（租书）</a></li>
        </ul>

        <a href="banner/banner.jsp" class="nav-header" ><i class="icon-gift"></i>活动推广</a>

        <a href="#money-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-star"></i>提现申请<i class="icon-chevron-up"></i></a>
        <ul id="money-menu" class="nav nav-list collapse">
            <li ><a href="money/money.jsp">未结算</a></li>
            <li ><a href="money/all_money.jsp">所有提现</a></li>
        </ul>

        <a href="method/method.jsp" class="nav-header" ><i class="icon-tags"></i>配送方式</a>

        <a href="announ/announ.jsp" class="nav-header" ><i class="icon-edit"></i>公告管理</a>
    </div>



	<div class="content">
		<div class="header">
			<div class="stats">
				<p class="stat">
					<span class="number"><c:out value="${numRentBook}"
							default="0" /> </span>租书
				</p>
				<p class="stat">
					<span class="number"><c:out value="${numSellBook}"
							default="0" /> </span>买书
				</p>
				<p class="stat">
					<span class="number"><c:out value="${numUsers}" default="0" />
					</span>用户
				</p>
			</div>
			<h1 class="page-title">数据动态</h1>
		</div>
		<ul class="breadcrumb">
			<li class="active">数据更新于 <c:out value="${dataTime}"
					default="2016年8月12日 19:32:21" /></li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">

				<div class="row-fluid">
					<div class="block">
						<a href="#page-stats" class="block-heading" data-toggle="collapse">总数据</a>
						<div id="page-stats" class="block-body collapse in">
							<div class="stat-widget-container">
								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">
											<c:out value="${numUsers}" default="0" />
										</p>
										<p class="detail">注册用户</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">
											<c:out value="${numSellBook}" default="0" />
										</p>
										<p class="detail">售出书籍</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">
											<c:out value="${numRentBook}" default="0" />
										</p>
										<p class="detail">出租书籍</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">
											￥
											<c:out value="${circulatingFund}" default="0" />
										</p>
										<p class="detail">资金流水</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="row-fluid">
					<div class="block span6">
						<a href="#tablewidget" class="block-heading"
							data-toggle="collapse">租书列表<span class="label label-warning">+10</span>
						</a>
						<div id="tablewidget" class="block-body collapse in">
							<table class="table">
								<thead>
									<tr>
										<th>用户名</th>
										<th>书籍名</th>
										<th>已领取</th>
									</tr>
								</thead>
								<tbody id="newbook-list">
									<c:forEach items="${rentInfos}" var="i" begin="0" end="5">
										<tr>
											<td><c:out value="${i.userNum}" /></td>
											<td><c:out value="${i.bookClassName}" /></td>
											<td><c:out value="${i.isTake}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<p>
								<a href="users.jsp">More...</a>
							</p>
						</div>
					</div>

					<div class="block span6">
						<a href="#widget1container" class="block-heading"
							data-toggle="collapse">成员公告</a>
						<div id="widget1container" class="block-body collapse in">
							<p>
								<c:out value="${announContent}" default="" />
							</p>
						</div>
					</div>
				</div>

				<div class="row-fluid">
					<div class="block span6">
						<div class="block-heading">
							<a href="#widget2container" data-toggle="collapse">买书<span
								class="label label-warning">+20</span> </a>
						</div>
						<div id="widget2container" class="block-body collapse in">
							<table class="table list">
								<tbody>
									<c:forEach items="${sellInfos}" var="i" begin="0" end="7">
										<tr>
											<td>
												<p>
													<i class="icon-user"></i>
													<c:out value="${i.userNum}" />
												</p>
											</td>
											<td>费用: ￥<c:out value="${i.sellPrice}" /></td>
											<td>购买时间: <c:out value="${i.datetime}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<p>
								<a href="users.jsp">More...</a>
							</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</jsp>