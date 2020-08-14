package com.gec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gec.bean.Grade;
import com.gec.bean.PageBean;
import com.gec.bean.Student;
import com.gec.service.GradeService;
import com.gec.service.StudentService;
import com.gec.service.impl.GradeServiceImpl;
import com.gec.service.impl.StudentServiceImpl;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService gs = new GradeServiceImpl();
	StudentService ss = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = request.getParameter("check");
		String now = request.getParameter("pageNow");
		List<Grade> list = gs.findAll();  //获取所有年级
		PageBean<Student> pb = null;  //定义分页对象
		int pageNow = 1;
		//第二获取时,now不为空的,需要转换
		if(now!=null){
			pageNow = Integer.parseInt(now);
		}
		if("1".equals(check)){
			
		}else if("4".equals(check)){  //模糊查询
			String name = request.getParameter("likeName");
			int gid = Integer.parseInt(request.getParameter("gid"));
			pb = ss.findLike(pageNow, gid, name);
			request.setAttribute("likeName", name);
			request.setAttribute("gid", gid);
		}else{
			
			pb = ss.findByPage(pageNow);
		}
		request.setAttribute("list", list);
		for (Grade gr : list) {
			System.out.println(gr);
		}
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("studentView").forward(request, response);
	}

}
