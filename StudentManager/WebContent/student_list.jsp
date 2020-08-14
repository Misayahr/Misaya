<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息展示</title>
</head>
<body>
	<form action=${studentServlet.java } method="post">
		<input type=hidden name=check value=4 /> 年级 <select name=gid>
			<option value=0>请选择</option>

			<c:forEach items="${list}" var="grade">
			<option value=${grade.gid() }>${grade.gname() }</option>
				<c:choose>
					<c:when test="${gid==grade.gid}">
						<option value=${grade.gid } selected=selected>${grade.gname}</option>
					</c:when>
					<c:otherwise>
						<option value=${grade.gid() }>${grade.gname() }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> &nbsp;学生姓名:

		<c:choose>
			<c:when test="${likeName != null }">
				<input name='likeName' value=${likeName }>
			</c:when>
			<c:otherwise>
				<input name='likeName'>
			</c:otherwise>
		</c:choose>
		<input type=submit value='搜 索'>
	</form>
	<table>
		<thead>
			<tr>
				<td>学生编号</td>
				<td>学生姓名</td>
				<td>学生性别</td>
				<td>学生年龄</td>
				<td>所在年级</td>
				<td>家庭住址</td>
				<td>手机号码</td>
				<td>邮箱地址</td>
				<td>操作</td>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${pb.List().size()>0 }">
				<tbody>
					<c:forEach items="${pb.list}" var="stu">
						<tr>
							<td>${stu.Id()}</td>
							<td>${stu.Name}</td>
							<td>${stu.Sex()}</td>
							<td>${stu.Age()}</td>
							<td>${stu.Grade().Gname()}</td>
							<td>${stu.Address()}</td>
							<td>${stu.Phone()}</td>
							<td>${stu.Email()}</td>
							<td><a href='studentServlet.jsp?id=${stu.Id()}&check=3'>编辑&nbsp;&nbsp;</a>
								<a href='studentServlet.jsp?id=${stu.Id()}&check=2'>删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan=6>总共${pb.PageCount()}页/每页${=pb.PageSize()}条,共有${pb.RowCount()}条/当前${pb.PageNow()}页,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<c:choose>
								<c:when test="${pb.PageNow>1 }">

									<a href=studentServlet.jsp?pageNow=1>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href=studentServlet.jsp?pageNow= ${(pb.PageNow-1)}>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:when>
								<c:otherwise>
				首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</c:otherwise>
							</c:choose> 
							<c:choose>
								<c:when test="${pb.PageNow<pb.PageCount}">

									<a href="studentServlet.jsp?pageNow=${(pb.PageNow+1)}">下一页</a>&nbsp;&nbsp;&nbsp;
									<a href="studentServlet.jsp?pageNow=${pb.PageCount}">末页</a>
								</c:when>
								<c:otherwise>下一页&nbsp;&nbsp;&nbsp;末页
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</tfoot>
			</c:when>
			<c:otherwise>
				<tbody>
				<tr>
					<td colspan=6 style='text-align: center;'>无内容输出</td>
				</tr>
				</tbody>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<a href="addStudent.jsp">添加学生</a>
</body>
</html>