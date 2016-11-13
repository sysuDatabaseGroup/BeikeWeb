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
		.error{
			color: red;
		}
		.error:before{
			content: "*";
		}
		.success{
			color: green;
		}
    </style>
    
    <div class="content">
        <div class="header">
            <h1 class="page-title">城市</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li><a href="cityList">城市</a><span class="divider">/</span></li>
            <li class="active">增加城市</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="addCity()"><i class="icon-save"></i> 添加</button>
</div>
<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
		<c:if test="${! empty error_msg}">
		<div class="error">${error_msg}</div>
		</c:if>
		<c:if test="${! empty success_msg}">
		<div class="success">${success_msg}</div>
		</c:if>
        <form id="city" method="POST" action="cityadd">
            <label>城市名</label>
            <input type="text" name="name" id="cityName" class="input-xlarge">
            <label>城市缩写</label>
            <input type="text" name="num" id="cityNum" class="input-xlarge">
        </form>
      </div>
  </div>
</div>
            </div>
        </div>
    </div>
<script>
function addCity()
{
	document.getElementById("city").submit();
}
</script>

