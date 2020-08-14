package com.gec.dao;

import com.gec.bean.PageBean;
import com.gec.bean.Student;

public interface StudentDao {

	PageBean<Student> findByPage(int pageNow);
	
	boolean save(Student stu);
	
	boolean del(int id);
	
	boolean update(Student stu);
	
	Student findById(int id);
	
	PageBean<Student> findLike(int pageNow,int gid,String name);
}
