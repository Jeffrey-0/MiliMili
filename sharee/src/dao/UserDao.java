package dao;

import model.User;

public interface UserDao {
	User queryByIdAndPwd(int id, String password);	
	void save(User user);
	User queryById(int id);
}
