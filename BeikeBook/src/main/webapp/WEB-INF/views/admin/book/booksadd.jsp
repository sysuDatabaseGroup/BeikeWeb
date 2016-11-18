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
            <h1 class="page-title">添加书单</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="index">首页</a><span class="divider">/</span></li>
            <li>书籍管理<span class="divider">/</span></li>
            <!--<li><a href="booksList">书类</a><span class="divider">/</span></li>-->
            <li class="active">添加书单</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary" onclick="addBooks()"><i class="icon-save"></i> 添加</button>
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
        <form id="books" method="POST" action="booksadd" enctype="multipart/form-data">
            <label>书名</label>
            <input type="text" name="name" class="input-xlarge">
            <label>类别</label>
            <select name="category" id="DropDownDorm" class="input-xlarge">
              <option value="未选择" selected="selected">未选择</option>
				<c:forEach items="${categoryInfos}" var="category">
                <option value="${category.getId()}">${category.getTitle()}</option>
				</c:forEach>
            </select>
            <label>书籍封面图</label>
            <input type="file" class="file" name="file" value="浏览" >
            <label>作者</label>
            <input type="text" name="author" class="input-xlarge">
            <label>出版社</label>
            <input type="text" name="press" class="input-xlarge">
            <label>版本</label>
            <input type="text" name="edition" class="input-xlarge">
            <label>出售参考价</label>
            <input type="text" name="sellingPrice" class="input-large"><span style="padding:0 10px">元</span>
            <label>出租参考价（年）</label>
            <input type="text" name="rentalPrice" class="input-large"><span style="padding:0 10px">元</span>
        </form>
      </div>
  </div>

</div>
            </div>
        </div>
    </div>
<script>
function addBooks()
{
	document.getElementById("books").submit();
}
</script>


