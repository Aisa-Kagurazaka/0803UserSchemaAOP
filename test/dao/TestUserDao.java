package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import pojo.User;
import util.MyBatisUtil;

public class TestUserDao {

	//����ͳ���û��ܼ�¼��
	@Test
	public void testCount() {
		SqlSession session = MyBatisUtil.createSqlSession();
		int num = session.getMapper(UserDao.class).count();
		System.out.println("�����û���¼����" + num);
	}

	//���������û���¼
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
		System.out.println("�ɹ����" + num + "���û���Ϣ");
	}
	
	//���Ը����û�ID�����û�
	@Test
	public void testGetUserById(){
		SqlSession session = MyBatisUtil.createSqlSession();
		User user = session.getMapper(UserDao.class).getUserById(30);
		System.out.println(user);
	}
	
	//���Ը����û�IDɾ���û�
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
		System.out.println("�ɹ�ɾ����" + num + "���û���Ϣ");
	}
	
	//���Ը����û���Ϣ
	@Test
	public void testUpdateUser(){
		User user = new User();
		user.setId(1006);
		user.setName("��ʮ��");
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
		System.out.println("�ɹ�������" + num + "���û���Ϣ");
	}
	
}
