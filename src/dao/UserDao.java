package dao;

import org.apache.ibatis.annotations.Param;

import pojo.User;

public interface UserDao {
	
	/**
	 * ͳ���û�����
	 * @return
	 */
	public int count();
	
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * �����û�IDɾ���û�
	 * @param id
	 * @return
	 */
	public int deleteUserById(@Param("id") Integer id);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * �����û�ID�����û�
	 * @param id
	 * @return
	 */
	public User getUserById(@Param("id") Integer id);
	
}
