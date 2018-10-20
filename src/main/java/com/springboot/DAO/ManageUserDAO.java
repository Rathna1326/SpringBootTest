package com.springboot.DAO;

import com.springboot.VO.UserDetailsVO;

public interface ManageUserDAO {

	
	public boolean addUser(UserDetailsVO user) throws Exception;
	
}
