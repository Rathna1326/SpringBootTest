package com.springboot.service;

import com.springboot.VO.UserDetailsVO;

public interface ManageUserService {

	public boolean addUser(UserDetailsVO user) throws Exception;
}
