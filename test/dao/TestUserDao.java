package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import pojo.User;
import util.MyBatisUtil;

public class TestUserDao {

	//测试统计用户总记录数
	@Test
	public void testCount() {
		SqlSession session = MyBatisUtil.createSqlSession();
		int num = session.getMapper(UserDao.class).count();
		System.out.println("共有用户记录数：" + num);
	}

	//测试新增用户记录
	@Test
	public void testAddUser(){
		User user = new User();
		user.setName("name");
		user.setPassword("password");
		int num = 0;
		SqlSession session = MyBatisUtil.createSqlSession();
		try {
			num = session.getMapper(UserDao.class).addUser(user);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			num = 0;
			e.printStackTrace();
		}
		System.out.println("成功添加" + num + "条用户信息");
	}
	
	//测试根据用户ID查找用户
	@Test
	public void testGetUserById(){
		SqlSession session = MyBatisUtil.createSqlSession();
		User user = session.getMapper(UserDao.class).getUserById(30);
		System.out.println(user);
	}
	
	//测试根据用户ID删除用户
	@Test
	public void testdDeleteUserById(){
		int num = 0;
		SqlSession session = MyBatisUtil.createSqlSession();
		try {
			num = session.getMapper(UserDao.class).deleteUserById(1002);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			num = 0;
			e.printStackTrace();
		}
		System.out.println("成功删除了" + num + "条用户信息");
	}
	
	//测试更新用户信息
	@Test
	public void testUpdateUser(){
		User user = new User();
		user.setId(1006);
		user.setName("张十三");
		user.setPassword("123");
		int num = 0;
		SqlSession session = MyBatisUtil.createSqlSession();
		try {
			num = session.getMapper(UserDao.class).updateUser(user);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			num = 0;
			e.printStackTrace();
		}
		System.out.println("成功更新了" + num + "条用户信息");
	}
	
}
