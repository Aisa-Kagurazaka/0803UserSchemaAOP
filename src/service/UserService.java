package service;


import pojo.User;

public interface UserService {
	
	/**
	 * �����û�IDɾ���û�
	 * @param id
	 */
	public void deleteUserById(Integer id);
	
	/**
	 * �����û�
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * �����û�ID�����û���Ϣ
	 * @param id
	 */
	public void getUserById(Integer id);
	
}
