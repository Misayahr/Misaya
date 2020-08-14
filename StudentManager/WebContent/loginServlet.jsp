<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gec.service.*,com.gec.service.impl.*" %>
<%@ page import="com.gec.bean.*" %>
<%
	UsersService us = new UsersServiceImpl();
	//第一个内置对象,request
	String name = request.getParameter("account");
	String pwd = request.getParameter("pwd");
	Users user = us.login(name, pwd);
	if(user!=null){
		//第二个内置对象 session保存用户
		session.setAttribute("user", user);
		//第三个内置对象response
		response.sendRedirect("studentServlet.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
%>