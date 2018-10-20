package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.VO.UserDetailsVO;
import com.springboot.DAO.ManageUserDAO;

@Service
public class ManageUserServiceImpl implements ManageUserService {

	@Autowired
	ManageUserDAO userDAO;
	
	public boolean addUser(UserDetailsVO user) throws Exception{
		return userDAO.addUser(user);
	}
	
}
