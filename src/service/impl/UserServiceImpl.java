package service.impl;

import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDaoImpl userDaoImpl;
	
	public UserServiceImpl() {
		super();
	}

	public UserServiceImpl(UserDaoImpl userDaoImpl) {
		super();
		this.userDaoImpl = userDaoImpl;
	}

	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public void deleteUserById(Integer id) {
		int num = userDaoImpl.deleteUserById(id);
		if(num > 0){
			System.out.println("刪除用戶成功！");
		}else{
			System.out.println("刪除用戶失敗！");
		}
	}

	@Override
	public void updateUser(User user) {
		int num = userDaoImpl.updateUser(user);
		if(num > 0){
			System.out.println("修改用戶成功！");
		}else{
			System.out.println("修改用戶失敗！");
		}
	}

	@Override
	public void getUserById(Integer id) {
		User user = userDaoImpl.getUserById(id);
		System.out.println(user);
	}

	@Override
	public void addUser(User user) {
		int num = userDaoImpl.addUser(user);
		if(num > 0){
			System.out.println("新增用戶成功！");
		}else{
			System.out.println("新增用戶失敗！");
		}
	}

}
