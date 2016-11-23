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
    </style>
    
    <div class="content">
        <div class="header">
            <h1 class="page-title">配送方式</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
            <li>配送管理<span class="divider">/</span></li>
            <li class="active">配送方式</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="methodadd.jsp" style="color:#fff;"><button class="btn btn-primary"><i class="icon-plus"></i> 增加方式</button></a>
</div>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>配送方式</th>
          <th>收费</th>
          <th style="width: 100px;">操作</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach items="${methodInfos}" var="i" begin="${pageNo*5}" end="${pageNo*5 + 5}">
			<tr>
				<td><c:out value="${i.methodID}" /></td>
				<td><c:out value="${i.methodName}" /></td>
				<td><c:out value="${i.price}" /></td>
				<td>
				    <a href="methodedit.jsp"><i class="icon-pencil"></i><span>编辑</span></a>
				    <a href="#myModal" role="button" data-toggle="modal" style="margin-left:5px;"><i class="icon-remove"></i><span>删除</span></a>
				</td>
			</tr>
		</c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="method.jsp?pageNo=${pageNo - 1}">Prev</a></li>
        <li><span><c:out value="${pageNo}"/></span></li>
        <li><a href="method.jsp?pageNo=${pageNo + 1}"><c:out value="${pageNo+1}"/></a></li>
        <li><a href="method.jsp?pageNo=${pageNo + 2}"><c:out value="${pageNo+2}"/></a></li>
        <li><a href="method.jsp?pageNo=${pageNo + 3}"><c:out value="${pageNo+3}"/></a></li>
        <li><a href="method.jsp?pageNo=${pageNo + 1}">Next</a></li>
    </ul>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">删除配送方式？</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除配送方式［自取］？</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" data-dismiss="modal">删除</button>
    </div>
</div>
            </div>
        </div>
    </div>


