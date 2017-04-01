package data;

import entities.User;

public interface LoginDAO {
	
	public User showUser(int id);
	public User createNewUser(User user);
	public User getUserByAliasAndPassword(String alias, String password);

}
