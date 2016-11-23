<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
								<a href="<c:url value='/backend/rentOrderList' />">More...</a>
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
								<a href="<c:url value='/backend/sellOrderList' />">More...</a>
							</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>