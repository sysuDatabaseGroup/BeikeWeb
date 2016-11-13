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
            <h1 class="page-title">托管点</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li><a href="districtList">托管点</a><span class="divider">/</span></li>
            <li class="active">增加托管点</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="addDistrict()"><i class="icon-save"></i> 添加</button>
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
        <form id="district">
            <label>托管点名</label>
            <input type="text" name="name" class="input-xlarge" placeholder="格式：xx托管点">
             <label>所在学校</label>
				<c:choose>
				<c:when test="${isRoot}">
					<select name="school" id="DropDownDorm" class="input-xlarge">
					  <option value="未选择" selected="selected">未选择</option>
						<c:forEach items="${schoolInfos}" var="school">
						<option value="${school.getId()}">${school.getName()}</option>
						</c:forEach>
					</select>
				</c:when>
				<c:otherwise>
				<input type="hidden" id="school" name="school" value="${schoolId}">
				</c:otherwise>
				</c:choose>
            <label>托管点地址</label>
            <input type="text" name="address" class="input-xlarge" placeholder="格式：xx宿舍xx室">
            <!--<label>配送员</label>
            <input type="text" class="input-xlarge">
            <label>手机号码</label>
            <input type="text" class="input-xlarge" placeholder="格式：长号/校园短号">-->        
        </form>
      </div>
    </div>
</div>
            </div>
        </div>
    </div>
<script>
function addDistrict()
{
	document.getElementById("district").submit();
}
</script>



