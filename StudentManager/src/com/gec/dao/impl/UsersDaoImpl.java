package com.gec.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gec.bean.Users;
import com.gec.dao.UserDao;
import com.gec.util.DBUtil;

public class UsersDaoImpl extends DBUtil<Users> implements UserDao {
	
	@Override
	public Users findById(int id) {
		return query("select * from users where uid=?", id).get(0);
	}

	@Override
	public Users login(String account, String password) {
		List<Users> list = query("select * from users where account=? and password=?", account,password);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	@Override
	public boolean register(Users user) {
		List<Object> obj = new ArrayList<>();
		obj.add(user.getAccount());
		obj.add(user.getPassword());
		obj.add(user.getUname());
		obj.add(user.getAddress());
		return update("insert into users values(null,?,?,?,?)", obj);
	}

	@Override
	public Users getEntity(ResultSet rs) throws Exception {
		Users user = new Users();
		user.setUid(rs.getInt(1));
		user.setAccount(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setUname(rs.getString(4));
		user.setAddress(rs.getString(5));
		return user;
	}
}
