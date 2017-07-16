package com.sun.service;

import com.sun.dao.UserDao;
import com.sun.dto.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/15.
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public User getUserInfo(int id) {
		return userDao.selectUserById(id);
	}
}
