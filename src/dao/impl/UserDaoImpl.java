package dao.impl;

import org.apache.ibatis.session.SqlSession;

import pojo.User;
import util.MyBatisUtil;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public int count(){
		SqlSession session = MyBatisUtil.createSqlSession();
		int num = session.getMapper(UserDao.class).count();
		return num;
	}
	
	@Override
	public int addUser(User user) {
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
		return num;
	}

	@Override
	public int deleteUserById(Integer id) {
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
		return num;
	}

	@Override
	public int updateUser(User user) {
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
		return num;
	}

	@Override
	public User getUserById(Integer id) {
		SqlSession session = MyBatisUtil.createSqlSession();
		User user = session.getMapper(UserDao.class).getUserById(id);
		return user;
	}
	
}
