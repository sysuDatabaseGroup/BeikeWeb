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
            <h1 class="page-title">学校</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li><a href="schoolList">学校</a><span class="divider">/</span></li>
            <li class="active">编辑学校</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="save()"><i class="icon-save"></i> 修改</button>
    <a onclick="deleteConfirm(${schoolId},'${schoolName}');return false;" href="" class="btn">删除</a>
</div>

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">基础信息</a></li>
      <li><a href="#profile" data-toggle="tab">密码</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="school">
            <label>学校</label>
            <input type="text" value="${schoolName}" id="schoolName" class="input-xlarge">
            <label>学校缩写</label>
            <input type="text" value="${schoolNum}" id="schoolNum" class="input-xlarge">
            <label>所在城市</label>
            <select name="city" id="DropDownDorm" class="input-xlarge">
              <option value="0">未选择</option>
					<c:forEach items="${cities}" var="city">
              <option value="${city.getId()}" <c:if test="${cityId == city.getId()}"><c:out value='selected="selected"'/></c:if>>${city.getName()}</option>
					</c:forEach>
            </select>
            <label>管理账号</label>
            <strong><c:out value="${schoolAdmin}"/></strong>
				<input type="hidden" id="schoolId" value="${schoolId}">
        </form>
      </div>
      <div class="tab-pane fade" id="profile">
        <form id="tab2">
            <label>输入新密码</label>
            <input type="password" id="password" class="input-xlarge">
            <label>确认新密码</label>
            <input type="password" id="repassword" class="input-xlarge">
        </form>
      </div>
    </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除学校？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text" id="confirm_msg"><i class="icon-warning-sign modal-icon"></i>确认删除学校［深圳大学］？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-danger" onclick="deleteSchool()">删除</button>
  </div>
</div>
            </div>
        </div>
    </div>
<script type="text/javascript">
function save()
{
    var params = {};
    params.name = document.getElementById("schoolName").value;
    params.num = document.getElementById("schoolNum").value;
    var selectList = document.getElementById("DropDownDorm");
	params.city = selectList.options[selectList.selectedIndex].value;
	params.id = document.getElementById("schoolId").value;
	if(document.getElementById("password").value){
		params.password = document.getElementById("password").value;
		params.repassword = document.getElementById("repassword").value;
	}
    $.ajax({
        url: "saveschool",
        type: "POST",
        dataType: "json",
        data: params,
        success: function(res){
            if(res.code == 0){
                alert("更新成功");
            }
            else{
                alert(res.msg);
            }
        },
    });
}
function deleteConfirm(id,name){
	var msg = '<i class="icon-warning-sign modal-icon"></i>确认删除学校['+name+"]?";
	document.getElementById("confirm_msg").innerHTML = msg;
	document.getElementById("myModal").setAttribute("delete_id",id+"");
	//alert("11");
	$("#myModal").modal('show');
}

function deleteSchool() {
	var params = {"id":document.getElementById("myModal").getAttribute("delete_id")};
	$.ajax({
		url: "deleteschool",
		type: "POST",
		dataType: "json",
		data: params,
		success: function(res){
			if(res.code == 0){
				location.href = 'schoolList';
			}
			else{
				alert(res.msg);
			}
		},
	});
}
</script>

