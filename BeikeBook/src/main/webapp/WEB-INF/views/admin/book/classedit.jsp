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
            <h1 class="page-title">编辑书类</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>书籍管理<span class="divider">/</span></li>
            <li><a href="categoryList">书类</a><span class="divider">/</span></li>
            <li class="active">编辑书类</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button onclick="save()" class="btn btn-primary"><i class="icon-save"></i> 修改</button>
    <a onclick="deleteConfirm(${id},'${categoryTitle}');return false;" href="" class="btn">删除</a>
</div>

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">书类名</a></li>
      <li><a href="#profile" data-toggle="tab">更新icon</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="tab" enctype="multipart/form-data">
            <label>书类</label>
            <input type="text" value="${categoryTitle}" name="name" class="input-xlarge">
			<input type="hidden" name="id" value="${id}">
        </form>
      </div>
      <div class="tab-pane fade" id="profile">
        <form id="tab2">
            <label>icon</label>
            <input type="file" class="file" id="pic" value="浏览" >
        </form>
      </div>
  </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除书类？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text" id="confirm_msg"><i class="icon-warning-sign modal-icon"></i>确认删除书类［计算机］？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-danger" onclick="deleteCategory()">删除</button>
  </div>
</div>
            </div>
        </div>
    </div>
<script type="text/javascript">
function save()
{
    var params = new FormData(document.getElementById("tab"));
	params.append("file",document.getElementById("pic").files[0]);
    $.ajax({
        url: "savecategory",
        type: "POST",
        dataType: "json",
		processData: false,
		contentType: false,
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
	var msg = '<i class="icon-warning-sign modal-icon"></i>确认删除书类['+name+"]?";
	document.getElementById("confirm_msg").innerHTML = msg;
	document.getElementById("myModal").setAttribute("delete_id",id+"");
	//alert("11");
	$("#myModal").modal('show');
}

function deleteCategory() {
	var params = {"id":document.getElementById("myModal").getAttribute("delete_id")};
	$.ajax({
		url: "deletecategory",
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


