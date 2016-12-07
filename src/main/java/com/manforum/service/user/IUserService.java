package com.manforum.service.user;

import com.manforum.pojo.user.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public int insertUser(User user);
}
