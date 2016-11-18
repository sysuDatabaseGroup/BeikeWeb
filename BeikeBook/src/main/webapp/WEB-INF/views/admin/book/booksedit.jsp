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
            <h1 class="page-title">编辑书单</h1>
        </div>

        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>书籍管理<span class="divider">/</span></li>
            <li><a href="booksList">书单</a><span class="divider">/</span></li>
            <li class="active">编辑书单</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="save()"><i class="icon-save"></i> 修改</button>
    <a onclick="deleteConfirm(${book.getId()},'${book.getTitle()}');return false;" href="" class="btn">删除</a>
</div>

<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">书籍</a></li>
      <li><a href="#profile" data-toggle="tab">更新书籍封面</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="books" enctype="multipart/form-data">
            <label>书名</label>
            <input type="text" value="${book.getTitle()}" name="name" class="input-xlarge">
            <label>类别</label>
            <select name="category" id="DropDownDorm" class="input-xlarge">
              <option value="未选择">未选择</option>
				<c:forEach items="${categoryInfos}" var="category">
              <option value="${category.getId()}" <c:if test="${book.getBookCategoryId() == category.getId()}"><c:out value='selected="selected"'/></c:if>>${category.getTitle()}</option>
				</c:forEach>
            </select>
            <label>作者</label>
            <input type="text" value="${book.getAuthor()}" name="author" class="input-xlarge">
            <label>出版社</label>
            <input type="text" value="${book.getPress()}" name="press" class="input-xlarge">
            <label>版本</label>
            <input type="text" value="${book.getEdition()}" name="edition" class="input-xlarge">
            <label>出售参考价</label>
            <input type="text" value="${book.getSellingPrice()}" name="sellingPrice" class="input-large"><span style="padding:0 10px">元</span>
            <label>出租参考价（年）</label>
            <input type="text" value="${book.getRentalPrice()}" name="rentalPrice" class="input-large"><span style="padding:0 10px">元</span>
			<input type="hidden" value="${book.getId()}" name="id">
        </form>
      </div>
      <div class="tab-pane fade" id="profile">
        <form id="tab2">
            <label>书籍封面图</label>
            <input id="pic" type="file" class="file" name="file" value="浏览" >
        </form>
      </div>
  </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除书单？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text" id="confirm_msg"><i class="icon-warning-sign modal-icon"></i>确认删除书单［毛泽东与邓小平理论知识毛泽东与邓小平理论知识］？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-danger" onclick="deleteBooks()">删除</button>
  </div>
</div>
            </div>
        </div>
    </div>
<script type="text/javascript">
function save()
{
    var params = new FormData(document.getElementById("books"));
	params.append("file",document.getElementById("pic").files[0]);
    $.ajax({
        url: "savebooks",
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
	var msg = '<i class="icon-warning-sign modal-icon"></i>确认删除书单['+name+"]?";
	document.getElementById("confirm_msg").innerHTML = msg;
	document.getElementById("myModal").setAttribute("delete_id",id+"");
	//alert("11");
	$("#myModal").modal('show');
}

function deleteBooks() {
	var params = {"id":document.getElementById("myModal").getAttribute("delete_id")};
	$.ajax({
		url: "deletebooks",
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


