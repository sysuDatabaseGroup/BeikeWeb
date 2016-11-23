<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        strong{
          padding: 5px;
        }

        label{
          padding-top: 5px;
        }
    </style>
	<script type="text/javascript">
		function saveUser() {
			var params = {};
			var city = document.getElementById("DropDownCity");
			params["city"] = city.options[city.selectedIndex].value;
			var school = document.getElementById("DropDownSchool");
			params["school"] = school.options[school.selectedIndex].value;
			//var domitory = document.getElementById("DropDownDorm").value;
			params["dorm"] = document.getElementById("dorm").value;
			params["userNo"] = document.getElementById("userNo").value;
			$.ajax({
				url: "saveUser",
				type: "POST",
				dataType: "json",
				data: params,
				success: function(res){
					console.log(res);
					if(res.code == 0){
						alert("用户修改成功");
					}
					else{
						alert("错误："+res.msg);
					}
				},
			});
		}
	</script>
    
<div class="content">
  <div class="header">
    <h1 class="page-title">用户编辑</h1>
  </div>
  <ul class="breadcrumb">
    <li><a href="index">首页</a> <span class="divider">/</span></li>
    <li><a href="users">用户管理</a> <span class="divider">/</span></li>
    <li class="active">用户编辑</li>
  </ul>

  <div class="container-fluid">
    <div class="row-fluid">
      <div class="btn-toolbar">
          <button class="btn btn-primary" onclick="saveUser()"><i class="icon-save"></i> 保存</button>
      </div>
      <div class="well">
        <div id="myTabContent" class="tab-content">
          <div class="tab-pane active in" id="home">
          <form id="user">
              <label>用户名</label>
              <strong><c:out value="${userNum}"/></strong>

              <label>城市</label>
              <select name="DropDownTimezone" id="DropDownCity" class="input-xlarge">
                <option value="0">未选择</option>
				<c:forEach items="${cities}" var="city">
                <option value="${city.id}" <c:if test="${cityNum == city.id}"><c:out value='selected="selected"'/></c:if>>${city.name}</option>
				</c:forEach>
				   </select>
              <label>学校</label>
              <select name="DropDownTimezone" id="DropDownSchool" class="input-xlarge">
                <option value="0">未选择</option>
				<c:forEach items="${schools}" var="school">
                <option value="${school.id}" <c:if test="${schoolNum == school.id}"><c:out value='selected="selected"'/></c:if>>${school.name}</option>
				</c:forEach>
              </select>

              <label>宿舍</label>
					<input value="${dorm}" name="dorm" id="dorm"/>
					<input name="userNo" id="userNo" type="hidden" value="${userNo}" />
          </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
