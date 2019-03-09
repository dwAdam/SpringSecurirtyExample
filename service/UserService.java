package com.sbsse.service;

import com.sbsse.model.User;

public interface UserService {
	
	public User findUserByEmail(String email);
	
	public void saveUser(User user);

}
