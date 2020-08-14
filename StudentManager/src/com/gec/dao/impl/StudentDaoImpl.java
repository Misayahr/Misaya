package com.gec.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gec.bean.PageBean;
import com.gec.bean.Student;
import com.gec.dao.GradeDao;
import com.gec.dao.StudentDao;
import com.gec.util.DBUtil;

public class StudentDaoImpl extends DBUtil<Student> implements StudentDao {

	GradeDao gd = new GradeDaoImpl();
	@Override
	public PageBean<Student> findByPage(int pageNow) {
		PageBean<Student> pb = new PageBean<>();
		pb.setPageNow(pageNow);
		String sql = "select count(id) from student";
		pb.setRowCount(queryCount(sql));
		sql = "select * from student limit ?,?";
		pb.setList(query(sql, (pageNow-1)*pb.getPageSize(),pb.getPageSize()));
		return pb;
	}
	
	@Override
	public PageBean<Student> findLike(int pageNow, int gid, String name) {
		PageBean<Student> pb = new PageBean<>();
		pb.setPageNow(pageNow);
		String sql = "select count(id) from student";
		if(gid>0){
			sql = sql+" where gid=? and name like ?";
			pb.setRowCount(queryCount(sql, gid,name));
			sql = "select * from student where gid=? and name like ?";
			pb.setList(query(sql, gid,name));
		}else{
			sql = sql+" where name like ?";
			pb.setRowCount(queryCount(sql, name));
			sql = "select * from student where name like ?";
			pb.setList(query(sql, name));
		}
		return pb;
	}

	@Override
	public boolean save(Student stu) {
		List<Object> obj = new ArrayList<>();
		obj.add(stu.getName());
		obj.add(stu.getSex());
		obj.add(stu.getAge());
		obj.add(stu.getGrade().getGid());
		obj.add(stu.getAddress());
		obj.add(stu.getPhone());
		obj.add(stu.getEmail());
		String sql = "insert into student values(null,?,?,?,?,?,?,?)";
		return update(sql, obj);
	}

	@Override
	public boolean del(int id) {
		List<Object> obj = new ArrayList<>();
		obj.add(id);
		return update("delete from student where id=?", obj);
	}

	@Override
	public boolean update(Student stu) {
		List<Object> obj = new ArrayList<>();
		obj.add(stu.getName());
		obj.add(stu.getSex());
		obj.add(stu.getAge());
		obj.add(stu.getGrade().getGid());
		obj.add(stu.getAddress());
		obj.add(stu.getPhone());
		obj.add(stu.getEmail());
		obj.add(stu.getId());
		String sql = "update set name=?,sex=?,age=?,gid=?,address=?,phone=?,email=? where id=?";
		return update(sql, obj);
	}

	@Override
	public Student findById(int id) {
		String sql="select * from student where id=?";
		List<Student> list = query(sql, id);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	@Override
	public Student getEntity(ResultSet rs) throws Exception {
		Student stu = new Student();
		stu.setId(rs.getInt(1));
		stu.setName(rs.getString(2));
		stu.setSex(rs.getString(3));
		stu.setAge(rs.getInt(4));
		stu.setGrade(gd.findById(rs.getInt(5)));
		stu.setAddress(rs.getString(6));
		stu.setPhone(rs.getString(7));
		stu.setEmail(rs.getString(8));
		return stu;
	}
}
