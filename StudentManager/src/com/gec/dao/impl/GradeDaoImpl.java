package com.gec.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.gec.bean.Grade;
import com.gec.dao.GradeDao;
import com.gec.util.DBUtil;

public class GradeDaoImpl extends DBUtil<Grade> implements GradeDao {

	@Override
	public List<Grade> findAll() {
		return query("select * from grade");
	}

	@Override
	public Grade findById(int gid) {
		return query("select * from grade where gid=?", gid).get(0);
	}

	@Override
	public Grade getEntity(ResultSet rs) throws Exception {
		Grade grade = new Grade();
		grade.setGid(rs.getInt(1));
		grade.setGname(rs.getString(2));
		return grade;
	}

}
