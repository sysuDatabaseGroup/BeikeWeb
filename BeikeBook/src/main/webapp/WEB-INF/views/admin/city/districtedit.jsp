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
            <li class="active">编辑托管点</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="save()"><i class="icon-save"></i> 修改</button>
</div>

<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="district">
            <label>托管点名</label>
            <input type="text" value="${districtName}" id="districtName" class="input-xlarge">
             <label>所在学校</label>
				<c:choose>
				<c:when test="${isRoot}">
            <select name="school" id="DropDownDorm" class="input-xlarge">
              <option value="0">未选择</option>
					<c:forEach items="${schools}" var="school">
              <option value="school.getId()" <c:if test="${schoolId == school.getId9)}"><c:out value='selected="selected"'/></c:if>>${school.getName()}</option>
              </c:forEach>
            </select>
				</c:when>
				<c:otherwise>
				<input type="hidden" id="school" name="school" value="${schoolId}">
				</c:otherwise>
				</c:choose>
            <label>托管点地址</label>
            <input type="text" value="${address}" id="address" class="input-xlarge">
				<input type="hidden" id="districtId" value="${districtId}">
        </form>
      </div>
    </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除托管点？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text" id="confirm_msg"><i class="icon-warning-sign modal-icon"></i>确认删除托管点［斋区托管点］？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-danger" onclick="deleteDistrict()">删除</button>
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
    params.address = document.getElementById("address").value;
    var selectList = document.getElementById("DropDownDorm");
	if(selectList){
		params.school = selectList.options[selectList.selectedIndex].value;
	}
	else{
		params.school = document.getElementById("school").value;
	}
	params.id = document.getElementById("districtId").value;
    $.ajax({
        url: "savedistrict",
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
	var msg = '<i class="icon-warning-sign modal-icon"></i>确认删除仓库['+name+"]?";
	document.getElementById("confirm_msg").innerHTML = msg;
	document.getElementById("myModal").setAttribute("delete_id",id+"");
	//alert("11");
	$("#myModal").modal('show');
}

function deleteDistrict() {
	var params = {"id":document.getElementById("myModal").getAttribute("delete_id")};
	$.ajax({
		url: "deleteDistrict",
		type: "POST",
		dataType: "json",
		data: params,
		success: function(res){
			if(res.code == 0){
				location.href = 'districtList';
			}
			else{
				alert(res.msg);
			}
		},
	});
}
</script>

