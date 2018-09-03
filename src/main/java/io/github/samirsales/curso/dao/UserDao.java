package io.github.samirsales.curso.dao;

import java.util.List;

import io.github.samirsales.curso.domain.User;

public interface UserDao {
	
	void save(User user);
	
	void update(User user);
	
	void remove(long id);
	
	User getUser(long id);
	
	List<User> getAll();
}
