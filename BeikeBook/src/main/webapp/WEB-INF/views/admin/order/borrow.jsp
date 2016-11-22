<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
    
    <div class="content">
        <div class="header">
            <h1 class="page-title">未解决订单（租书）</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
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
        <form class="form-search" action="rentOrderList" method="GET">
          <input type="text" name="take_book_num" class="input-medium search-query">
          <button type="submit" class="btn">搜索取书号</button>
        </form>
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
          	<c:forEach items="${rentInfos}" var="i" begin="0" end="${numOfItem}">
				<tr>
					<td><c:out value="${i.getId()}" /></td>
					<td><c:out value="${bookName.get(i.getId())}" /></td>
					<td><c:out value="${i.userNum}" /></td>
					<td><c:out value="${i.getAmount()}" /></td>
					<td><c:out value="${prices.get(i.getId())}" /></td>
					<td><c:out value="${methodName.get(i.getId())}" /></td>
					<td><c:out value="${i.getTakingBookNum()}" /></td>
					<td><c:out value="${formatedDate.get(i.getId())}" /></td>
					<td><span class="btn-danger" style="padding:5px;">
						<c:choose>
							<c:when test="${i.getTook() == 1}">已领取</c:when>
							<c:otherwise>未领取</c:otherwise>
						</c:choose></span>
					</td>
					<td>
						<c:if test="${i.getTook() == 0}">
						<a href="rentOrderDone?url=${redirectUrl}&id=${i.getId()}"><i class="icon-edit"></i><span>已领取</span></a>
						</c:if>
						<a href="deleteRentOrder?url=${redirectUrl}&id=${i.getId()}"><i class="icon-edit"></i><span>删除</span></a>
					</td>
				</tr>
			</c:forEach>
          </tbody>
        </table>

  <div class="pagination">
      <ul>
    <c:choose>
    <c:when test="${pageNo > 1}">
    <li><a href='${preUrl}pageNo=${pageNo - 1}'>Prev</a>
    </li>
    </c:when>
    <c:otherwise>
    <li><a href='${preUrl}pageNo=${pageNo}'>Prev</a>
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
    <li><a href='${preUrl}pageNo=${i}'><c:out value="${i}"/></a>
    </li>
    </c:otherwise>
    </c:choose>
    </c:forEach>
    <c:choose>
    <c:when test="${pageNo==maxPage}">
    <li><a href='${preUrl}pageNo=${pageNo}'>Next</a>
    </li>
    </c:when>
    <c:otherwise>
    <li><a href='${preUrl}pageNo=${pageNo + 1}'>Next</a>
    </li>
    </c:otherwise>
    </c:choose>
      </ul>
  </div>

</div>
</div>
</div>


