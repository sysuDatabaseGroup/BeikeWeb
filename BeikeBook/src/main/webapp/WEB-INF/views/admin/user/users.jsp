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
</style>

	<div class="content">

		<div class="header">
			<h1 class="page-title">用户管理</h1>
		</div>
		<ul class="breadcrumb">
			<li><a href="index">首页</a> <span class="divider">/</span>
			</li>
			<li class="active">用户管理</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid" style="margin-top:10px;">
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>用户名</th>
								<!--<th>用户编号</th>-->
								<th>城市</th>
								<th>学校</th>
								<th>宿舍</th>
								<th style="width: 70px;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userInfos}" var="i" begin="0" end="${numOfItem}">
								<tr>
									<td><c:out value="${i.id}" />
									</td>
									<td><c:out value="${i.userNum}" />
									</td>
									<td><c:out value="${i.cityName}" />
									</td>
									<td><c:out value="${i.schoolName}" />
									</td>
									<td><c:out value="${i.dorm}" />
									</td>
									<td><a href="<c:url value='/backend/useredit?userNo=${i.id}' />"><i class="icon-pencil"></i><span>编辑</span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="pagination">
					<ul>
						<c:choose>
						<c:when test="${pageNo > 1}">
						<li><a href="userList?pageNo=${pageNo - 1}">Prev</a>
						</li>
						</c:when>
						<c:otherwise>
						<li><a href="userList?pageNo=${pageNo}">Prev</a>
						</li>
						</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="${beginPage}" end="${maxPage}">
						<c:choose>
						<c:when test="${i==pageNo}">
						<li><span><c:out value="${pageNo}"/></span>
						</li>
						</c:when>
						<c:otherwise>
						<li><a href="userList?pageNo=${i}"><c:out value="${i}"/></a>
						</li>
						</c:otherwise>
						</c:choose>
						</c:forEach>
						<c:choose>
						<c:when test="${pageNo==maxPage}">
						<li><a href="userList?pageNo=${pageNo}">Next</a>
						</li>
						</c:when>
						<c:otherwise>
						<li><a href="userList?pageNo=${pageNo + 1}">Next</a>
						</li>
						</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>