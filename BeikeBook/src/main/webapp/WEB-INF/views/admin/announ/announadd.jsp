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
            <h1 class="page-title">新增公告</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
            <li>公告管理<span class="divider">/</span></li>
            <li><a href="announ.jsp">公告</a><span class="divider">/</span></li>
            <li class="active">增加公告</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary"><i class="icon-save"></i> 添加</button>
</div>
<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="announ">
            <label>公告标题</label>
            <input type="text" class="input-xlarge">
            <label>内容</label>
            <textarea class="input-xlarge"></textarea>
        </form>
      </div>
  </div>

</div>
            </div>
        </div>
    </div>


