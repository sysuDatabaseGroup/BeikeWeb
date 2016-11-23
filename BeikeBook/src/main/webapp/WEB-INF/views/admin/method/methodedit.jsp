<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <h1 class="page-title">编辑配送方式</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
            <li>配送管理<span class="divider">/</span></li>
            <li><a href="method.jsp">配送方式</a><span class="divider">/</span></li>
            <li class="active">编辑方式</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <button class="btn btn-primary"><i class="icon-save"></i> 修改</button>
    <a href="#myModal" data-toggle="modal" class="btn">删除</a>
</div>

<div class="well">
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in">
        <form id="method">
            <label>配送方式</label>
            <input type="text" class="input-xlarge" value="${methodName}">
            <label>收费价格</label>
            <input type="text" class="input-small" value="${methodName}"><span> 元</span>
        </form>
      </div>
  </div>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">删除配送方式？</h3>
  </div>
  <div class="modal-body">
    <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确认删除配送方式［上门收书］？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-danger" data-dismiss="modal">删除</button>
  </div>
</div>
            </div>
        </div>
    </div>
