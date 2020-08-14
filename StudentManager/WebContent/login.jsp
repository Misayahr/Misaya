<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
	<%Integer count = (Integer)application.getAttribute("count");
	if(count==null){
		count = 1;
	}else{
		count +=1;
	} %>
	<form action="student_list.jsp" method="post">
		用户名:<input name="account" ><br/>
		密码:<input type="password" name="pwd" ><br/>
		<input type="submit" value="登 录"><button onclick="javascript:href='register.jsp'">注册</button>
	</form>
	<%out.print("欢迎来到粤嵌学堂,当前浏览量为"+count); %>
</body>
</html>