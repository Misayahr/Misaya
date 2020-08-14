package com.gec.service.impl;

import java.util.List;

import com.gec.bean.Grade;
import com.gec.dao.GradeDao;
import com.gec.dao.impl.GradeDaoImpl;
import com.gec.service.GradeService;

public class GradeServiceImpl implements GradeService {

	GradeDao gd = new GradeDaoImpl();
	@Override
	public List<Grade> findAll() {
		// TODO Auto-generated method stub
		return gd.findAll();
	}

	@Override
	public Grade findById(int gid) {
		// TODO Auto-generated method stub
		return gd.findById(gid);
	}

}
