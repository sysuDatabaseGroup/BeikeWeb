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
		form{
			position: relative;
		}
		ul,li{
			padding: 0;
			margin: 0;
			list-style-type:none;
		}
		#search_result{
			position: absolute;
			border: 1px solid #cccccc;
			font-size: 14px;
			box-sizing: border-box;
		}
		#search_result>li{
			height: 20px;
			line-height: 20px;
			padding: 4px 6px;
		}
		#search_result>li:hover{
			color: white;
			background: #414959;
		}
    </style>
    
    <div class="content">
        <div class="header">
            <h1 class="page-title">添加书本</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>书籍管理<span class="divider">/</span></li>
            <li><a href="booksList">书单</a><span class="divider">/</span></li>
            <li class="active">添加书本</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="addDealedBook()"><i class="icon-save"></i> 添加</button>
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
        <form id="dealedBook" method="POST" action="dealedbookadd">
            <label>书名</label>
            <input autocomplete="off" oninput="search()" id="book_name" type="text" name="name" class="input-large">
			<input type="hidden" name="book_id" id="book_id">
			<ul id="search_result"></ul>
            <!--<label>数量</label>
            <input type="text" class="input-large"><span style="padding:0 10px">本</span>
            <label>出售价</label>
            <input type="text" class="input-large"><span style="padding:0 10px">元</span>
            <label>出租价</label>
            <input type="text" class="input-large"><span style="padding:0 10px">元</span>-->
            <hr>
            <label>托管点</label>
            <select name="district" id="DropDownDistrict" class="input-xlarge">
              <option value="未选择" selected="selected">未选择</option>
				<c:forEach items="${districtInfos}" var="district">
                <option value="${district.getId()}">${district.getName()}</option>
				</c:forEach>
            </select>
            <label>托管者</label>
            <input type="text" name="user" class="input-xlarge">
        </form>
      </div>
  </div>
</div>
            </div>
        </div>
    </div>
<script>
function addDealedBook()
{
	document.getElementById("dealedBook").submit();
}
function search()
{
	var name = document.getElementById("book_name").value;
	$.ajax({
		url: "searchbooks",
		type: "POST",
		dataType: "html",
		data: {"name":name},
		success: function(data){
			if(data){
				var ul = document.getElementById("search_result");
				var name_input = document.getElementById("book_name");
				ul.innerHTML = data;
				ul.style.width = name_input.offsetWidth + "px";
				ul.style.left = name_input.offsetLeft + "px";
				ul.style.top = (name_input.offsetTop + name_input.offsetHeight) + "px";
				ul.style.display = "block";
			}
			else{
				document.getElementById("search_result").style.display = "none";
			}
		}
	});
}
(function(){
	$("body").on("click","#search_result>li",function(){
		var _self = this;
		document.getElementById("book_name").value = _self.innerHTML;
		document.getElementById("book_id").value = _self.getAttribute("data-id");
		document.getElementById("search_result").style.display = "none";
	});
})();
</script>


