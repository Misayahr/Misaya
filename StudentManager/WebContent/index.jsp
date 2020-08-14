<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息</title>
</head>
<body>
	<form action="pageServlet" method="post">
		<input type="hidden" name="check" value="4"> 年级：<select
			name="gid">
			<option value="0">请选择</option>
			<c:forEach items="${list}" varStatus="st" var="li">
				<c:choose>
					<c:when test="${li.gid!=null&&li.gid==gid}">
						<option value="${li.gid}" selected="selected">${li.gname}</option>
					</c:when>
					<c:otherwise>
						<option value="${li.gid}">${li.gname}</option>
					</c:otherwise>
				</c:choose>

			</c:forEach>
		</select>
		<c:if test="${likeName!= null}">
			<input type="text" name="likeName" value="${likeName}">
			<button type="submit">搜索</button>
		</c:if>
		<c:if test="${likeName == null}">
			<input type="text" name="likeName">
			<button type="submit">搜索</button>
		</c:if>

	</form>

	<table>
		<thead>
			<tr>
				<th>学生编号</th>
				<th>学生姓名</th>
				<th>学生性别</th>
				<th>学生年龄</th>
				<th>学生年级</th>
				<th>家庭住址</th>
				<th>手机号码</th>
				<th>邮箱地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.page.list}" varStatus="st" var="pa">
				<tr>
					<td>${pa.id}</td>
					<td>${pa.name}</td>
					<td>${pa.sex}</td>
					<td>${pa.age}</td>
					<td>${pa.grade.gname}</td>
					<td>${pa.address}</td>
					<td>${pa.phone}</td>
					<td>${pa.email}</td>
					<td><a href="#">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">总共${page.totalPage}页,共有${page.rowCount}条/当前第${page.pageNow}页</td>
				<c:if test="${page.pageNow gt 1}">
					<td><a href="pageServlet?pageNow=1">首页</a></td>
					<td><a href="pageServlet?pageNow=${pageNow-1}">上一页</a></td>
				</c:if>
				<c:if test="${page.pageNow eq 1}">
					<td>首页</td>
					<td>上一页</td>
				</c:if>
				<c:if test="${page.pageNow lt page.totalPage ? true:false}">
					<td><a href="pageServlet?pageNow=${pageNow+1}">下一页</a></td>
					<td><a href="pageServlet?pageNow=${page.totalPage}">末页</a></td>
				</c:if>
				<c:if test="${page.pageNow lt page.totalPage ? false:true}">
					<td>下一页</td>
					<td>末页</td>
				</c:if>
			</tr>
		</tfoot>
	</table>
</body>
</html>