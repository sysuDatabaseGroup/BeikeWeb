<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    $(document).ready(function(){
    	
    	$("#add").click(function(){
    		if($("#name").val().length == 0 || 
        			$("#price").val().length == 0) {
        		alert("请补全所有数据");
        		return;
        	}
    		$.post("/backend/method_add",{
    			name : $("#name").val(),
    			price : $("#price").val()
    		}, function(data,status){
    			alert(data);
    			window.location.replace('/backend/method');
    		});
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
    </style>

    <div class="content">
        <div class="header">
            <h1 class="page-title">添加配送方式</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="<c:url value="/backend/index" />">首页</a><span class="divider">/</span></li>
            <li>配送管理<span class="divider">/</span></li>
            <li><a href="<c:url value="/backend/method" />">配送方式</a><span class="divider">/</span></li>
            <li class="active">新增方式</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button id="add" class="btn btn-primary"><i class="icon-save"></i> 添加</button>
</div>
<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
            <label>配送方式</label>
            <input id="name" type="text" class="input-xlarge">
            <label>收费价格</label>
            <input id="price" type="text" class="input-small"><span> 元</span>
      </div>
  </div>

</div>
            </div>
        </div>
    </div>



