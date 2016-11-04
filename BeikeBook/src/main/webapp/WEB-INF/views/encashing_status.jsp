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
			<span>${message}</span>
			<a href="<c:url value='/center' />">
				<input type="button" id="back" value="返回"  >
			</a>
		</div>
	</div>
</body>	
</html>