package com.timapp.mybatis.dao;

import java.util.List;

import com.timapp.mybatis.domain.User;

public interface UserDao {
	//这里面有一个方法名 selectUserByID 必须与 User.xml 里面配置的 select 的id 对应（<select id="selectUserByID"）
	
	public User getUser(String id);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(String UserId);
	
	public List<User> getUserList(String name);
}
