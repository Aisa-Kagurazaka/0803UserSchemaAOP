package service;


import pojo.User;

public interface UserService {
	
	/**
	 * 根据用户ID删除用户
	 * @param id
	 */
	public void deleteUserById(Integer id);
	
	/**
	 * 新增用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 根据用户ID查找用户信息
	 * @param id
	 */
	public void getUserById(Integer id);
	
}
