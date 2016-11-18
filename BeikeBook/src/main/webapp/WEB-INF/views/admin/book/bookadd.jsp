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
            <h1 class="page-title">添加书本</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
            <li>书籍管理<span class="divider">/</span></li>
            <li><a href="books.jsp">书单</a><span class="divider">/</span></li>
            <li class="active">添加书本</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary"><i class="icon-save"></i> 添加</button>
</div>
<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="book">
            <label>书名</label>
            <input type="text" class="input-large">
            <label>数量</label>
            <input type="text" class="input-large"><span style="padding:0 10px">本</span>
            <label>出售价</label>
            <input type="text" class="input-large"><span style="padding:0 10px">元</span>
            <label>出租价</label>
            <input type="text" class="input-large"><span style="padding:0 10px">元</span>
            <hr>
            <label>托管点</label>
            <select name="DropDownDistrict" id="DropDownDistrict" class="input-xlarge">
              <option value="未选择" selected="selected">未选择</option>
              <option value="斋区托管点">斋区托管点</option>
              <option value="西南托管点">西南托管点</option>
              <option value="南区托管点">南区托管点</option>
            </select>
            <label>托管者编号</label>
            <input type="text" class="input-xlarge">
        </form>
      </div>
  </div>
</div>
            </div>
        </div>
    </div>



