package com.gec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gec.bean.Users;
import com.gec.service.UsersService;
import com.gec.service.impl.UsersServiceImpl;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UsersService us = new UsersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取到页面传递的数据
		String name = req.getParameter("account");
		String pwd = req.getParameter("pwd");
		Users user = us.login(name, pwd);
		if(user!=null){
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			resp.sendRedirect("studentServlet");
		}else{
			resp.sendRedirect("lv");
		}
	}
}
