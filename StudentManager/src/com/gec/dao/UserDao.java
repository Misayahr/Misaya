package com.gec.dao;

import com.gec.bean.Users;

public interface UserDao {
	
	Users findById(int id);
	
	Users login(String account,String password);
	
	boolean register(Users user);
}
