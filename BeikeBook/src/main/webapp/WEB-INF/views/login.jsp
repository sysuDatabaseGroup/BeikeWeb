<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<h2>登录</h2>
<form action="" method="POST">
	username: <input type="text" name="username" value=""> <br>
	password: <input type="password" name="password" value=""> <br>
	<input type="submit" value="登录" >
	<input name="_csrf" type="hidden">
</form>
<h2>${message}</h2>
</body>
</html>