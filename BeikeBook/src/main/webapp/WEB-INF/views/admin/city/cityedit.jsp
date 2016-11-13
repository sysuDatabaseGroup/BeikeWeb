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
            <h1 class="page-title">城市</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>托管点管理<span class="divider">/</span></li>
            <li><a href="cityList">城市</a><span class="divider">/</span></li>
            <li class="active">编辑城市</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button onclick="save()" class="btn btn-primary"><i class="icon-save"></i> 修改</button>
    <a onclick="deleteConfirm(${id},'${cityName}');return false;" href="" class="btn">删除</a>
</div>

<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="city">
            <label>城市名</label>
            <input type="text" id="cityName" name="name" value="${cityName}" class="input-xlarge">
            <label>城市缩写</label>
            <input type="text" value="${cityAbbreviate}" id="cityNum" name="num" class="input-xlarge">
            <input type="hidden" value="${id}" id="cityId">
        </form>
      </div>
  </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除城市？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text" id="confirm_msg"><i class="icon-warning-sign modal-icon"></i>确认删除城市［深圳］？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-danger" onclick="deleteCity()">删除</button>
  </div>
</div>
            </div>
        </div>

<script type="text/javascript">
function save()
{
    var params = {};
    params.name = document.getElementById("cityName").value;
    params.num = document.getElementById("cityNum").value;
    params.id = document.getElementById("cityId").value;
    $.ajax({
        url: "savecity",
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
	var msg = '<i class="icon-warning-sign modal-icon"></i>确认删除城市['+name+"]?";
	document.getElementById("confirm_msg").innerHTML = msg;
	document.getElementById("myModal").setAttribute("delete_id",id+"");
	//alert("11");
	$("#myModal").modal('show');
}

function deleteCity() {
	var params = {"id":document.getElementById("myModal").getAttribute("delete_id")};
	$.ajax({
		url: "deletecity",
		type: "POST",
		dataType: "json",
		data: params,
		success: function(res){
			if(res.code == 0){
				location.href = 'cityList';
			}
			else{
				alert(res.msg);
			}
		},
	});
}
</script>

