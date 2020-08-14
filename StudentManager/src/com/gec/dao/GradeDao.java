package com.gec.dao;

import java.util.List;

import com.gec.bean.Grade;

public interface GradeDao {

	List<Grade> findAll();
	
	Grade findById(int gid);
}
