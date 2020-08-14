package com.gec.service.impl;

import com.gec.bean.Users;
import com.gec.dao.UserDao;
import com.gec.dao.impl.UsersDaoImpl;
import com.gec.service.UsersService;

public class UsersServiceImpl implements UsersService {

	UserDao ud = new UsersDaoImpl();

	@Override
	public Users login(String account, String password) {
		// TODO Auto-generated method stub
		return ud.login(account, password);
	}

	@Override
	public boolean register(Users user) {
		// TODO Auto-generated method stub
		return ud.register(user);
	}
	
	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return ud.findById(id);
	}

}
