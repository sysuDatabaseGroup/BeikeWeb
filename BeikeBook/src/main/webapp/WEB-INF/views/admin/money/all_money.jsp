<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <h1 class="page-title">提现申请</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
            <li>提现管理<span class="divider">/</span></li>
            <li class="active">提现列表（所有）</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
</div>

<div class="well">
    <form class="form-search">
          <input type="text" class="input-medium search-query">
          <button type="submit" class="btn">搜索支付宝账户</button>
        </form>
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th width="150px">支付宝姓名</th>
          <th>支付宝账号</th>
          <th>提现费用</th>
          <th>手机号码</th>
        </tr>
      </thead>
      <tbody>
       	<c:forEach items="sellInfos" var="i" begin="${pageNo*5}" end="${pageNo*5 + 5}">
       		<tr>
       			<td><c:out value="${i.id}"/></td>
       			<td><c:out value="${i.alipayName}"/></td>
       			<td><c:out value="${i.alipayAccount}"/></td>
       			<td><c:out value="${i.moneyNum}"/></td>
       			<td><c:out value="${i.phone}"/></td>
				<td>
				    <a href="success.php"><i class="icon-ok"></i><span>已结算</span></a>
				</td>
       		</tr>
       	</c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="all_money.jsp?pageNo=${pageNo - 1}">Prev</a></li>
        <li><span><c:out value="${pageNo}"/></span></li>
        <li><a href="all_money.jsp?pageNo=${pageNo + 1}"><c:out value="${pageNo+1}"/></a></li>
        <li><a href="all_money.jsp?pageNo=${pageNo + 2}"><c:out value="${pageNo+2}"/></a></li>
        <li><a href="all_money.jsp?pageNo=${pageNo + 3}"><c:out value="${pageNo+3}"/></a></li>
        <li><a href="all_money.jsp?pageNo=${pageNo + 1}">Next</a></li>
    </ul>
</div>

            </div>
        </div>
    </div>