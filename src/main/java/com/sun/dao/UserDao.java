package com.sun.dao;

import com.sun.dto.User;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface UserDao {
	User selectUserById(int id);
}
