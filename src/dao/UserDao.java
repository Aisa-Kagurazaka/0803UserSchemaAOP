package dao;

import org.apache.ibatis.annotations.Param;

import pojo.User;

public interface UserDao {
	
	/**
	 * 统计用户总数
	 * @return
	 */
	public int count();
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 根据用户ID删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserById(@Param("id") Integer id);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 根据用户ID查找用户
	 * @param id
	 * @return
	 */
	public User getUserById(@Param("id") Integer id);
	
}
