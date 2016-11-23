<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
	<script type="text/javascript">
	var school;
	$(document).ready(function(){
        $("#addSub").click(function() {
        	window.location.href="/user_information_submit?"+
        			"dorm="+$(".dorm").val();
        });
    });
	</script>
</head>
<body>
		<div class="edit">
		<h1>请设置你的宿舍</h1>
			<label>
					<span>城市</span>
					<input value="广州" type="text" disabled="disabled" name="city" required="required">
				</label>
				<label>
					<span>学校</span>
					<input value="中山大学" type="text" disabled="disabled" name="school" required="required">
				</label>
				<label>
					<span>宿舍</span>
					<input type="text" id="dorm" class="dorm" value="<c:out value='${user.dorm}'/>" placeholder="请输入宿舍及宿舍号" required/>
				</label>
				<input type="submit" id="addSub" value="修改"/>
			
	<div id="logo">
		<footer class="footer"></footer>
	</div>
	</div>
</body>	
</html>
