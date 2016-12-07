package com.manforum.service.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.manforum.dao.user.IUserDao;
import com.manforum.pojo.user.User;
import com.manforum.service.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.insert(user);
	}

}
