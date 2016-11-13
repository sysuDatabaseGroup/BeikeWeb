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
            <h1 class="page-title">学校</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="index.jsp">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li><a href="schoolList">学校</a><span class="divider">/</span></li>
            <li class="active">增加学校</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="addSchool()"><i class="icon-save"></i> 添加</button>
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
        <form id="school">
            <label>学校</label>
            <input type="text" name="name" class="input-xlarge">
            <label>学校缩写</label>
            <input type="text" name="num" class="input-xlarge">
            <label>所在城市</label>
            <select name="city" id="DropDownDorm" class="input-xlarge">
              <option value="未选择" selected="selected">未选择</option>
				<c:forEach items="${cityInfos}" var="city">
                <option value="${city.getId()}">${city.getName()}</option>
				</c:forEach>
            </select>
            <label>管理账号</label>
            <input type="text" name="admin" class="input-xlarge">
            <label>密码</label>
            <input type="password" id="password" name="password" class="input-xlarge">
            <label>确认密码</label>
            <input type="password" id="repassword" name="repassword" class="input-xlarge">
        </form>
      </div>
  </div>

</div>
            </div>
        </div>
    </div>
<script>
function addSchool()
{
	document.getElementById("school").submit();
}
</script>


