package com.gec.service.impl;

import com.gec.bean.PageBean;
import com.gec.bean.Student;
import com.gec.dao.StudentDao;
import com.gec.dao.impl.StudentDaoImpl;
import com.gec.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao sd = new StudentDaoImpl();
	@Override
	public PageBean<Student> findByPage(int pageNow) {
		// TODO Auto-generated method stub
		return sd.findByPage(pageNow);
	}

	@Override
	public boolean save(Student stu) {
		// TODO Auto-generated method stub
		return sd.save(stu);
	}

	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return sd.del(id);
	}

	@Override
	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		return sd.update(stu);
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return sd.findById(id);
	}

	@Override
	public PageBean<Student> findLike(int pageNow, int gid, String name) {
		name = "%"+name+"%";
		return sd.findLike(pageNow, gid, name);
	}

}
