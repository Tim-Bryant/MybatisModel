package com.timapp.mybatis.test;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timapp.mybatis.dao.UserDao;
import com.timapp.mybatis.domain.User;
import com.timapp.mybatis.util.RandomGUID;

/**
 * MybatisSpringTest:mybatis整合Spring操作数据库
 * @author liuxf
 * @date   2016年5月25日  下午1:48:43
 * @description
 */
public class MybatisSpringTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		//随机数
		Random random=new Random();
		int nextInt = random.nextInt(100);
		
		//随机32位ID
		RandomGUID gid=new RandomGUID();
		String uuid = gid.getUUID();
		
		User user = new User();
		// 添加两条数据
		user.setId(uuid);
		user.setName("测试人员"+nextInt);
		user.setAge(String.valueOf(nextInt));
		userDao.addUser(user);
		System.out.println("-----添加成功------");
		// 查询数据
		
		User userObj = userDao.getUser("A06C2EF7B7D0DF8143024039CBA08CBE");
		System.out.println(userObj.getName());
		System.out.println("-----查询成功------");
		
		// 修改数据
		userObj.setName(userObj.getName()+nextInt);
		userObj.setAge(String.valueOf(nextInt));
		userDao.updateUser(userObj);
		System.out.println("-----修改"+userObj.getName()+"成功------");
		// 删除数据

		//userDao.deleteUser(user.getId());
		//System.out.println("-----删除成功------");
		
		
		System.out.println("-----批量查询start------");
		
		//批量查询
		List<User> userList = userDao.getUserList("%测试%");
		for(User tempUser:userList){
			System.out.println(tempUser.getName());
		}
		System.out.println("-----批量查询end------");
	}

}
