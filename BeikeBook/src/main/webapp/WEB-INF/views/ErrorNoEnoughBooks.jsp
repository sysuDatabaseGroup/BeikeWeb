<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>

<body>
	<div class="wrong">
		<div class="box">
			<div id="icon"></div>
			<span>不好意思，所购买的书数量不足</span>
			<input type="button" id="back" value="返回" onclick="javascript:history.back(-1);" >
		</div>
	</div>
</body>	
</html>