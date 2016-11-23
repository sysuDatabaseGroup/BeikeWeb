<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
    $(document).ready(function(){
    	$("button").click(function(){
    	   if(confirm("确认结算")){
    		   $.post("/backend/encash",{
   				id : $(this).val()
	   			}, function(data,status){
	   				alert("数据: " + data + "\n状态: " + status);
	   				window.location.replace('/backend/encashment');
	   			});
    	   }
    	});
    });
    </script>
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
            <li><a href="<c:url value='/backend/index' />">首页</a><span class="divider">/</span></li>
            <li>提现管理<span class="divider">/</span></li>
            <li class="active">提现列表（未结算）</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
</div>

<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th width="150px">支付宝姓名</th>
          <th>支付宝账号</th>
          <th>提现费用</th>
          <th>手机号码</th>
          <th style="width:100px;">操作</th>
        </tr>
      </thead>
      
      <tbody>
       	<c:forEach items="${encashments}" var="i">
			<tr>
       			<td><c:out value="${i.id}"/></td>
       			<td><c:out value="${i.alipayName}"/></td>
       			<td><c:out value="${i.alipayAccount}"/></td>
       			<td><c:out value="${i.encashingAmount}"/></td>
       			<td><c:out value="${i.phone}"/></td>
				<td>
				    <a href="#"><button id="encash" value="${i.id}">结算</button></a>
				</td>
       		</tr>
       	</c:forEach>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
    </ul>
</div>

            </div>
        </div>
    </div>

