package io.github.samirsales.curso.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.github.samirsales.curso.domain.User;

public class UserDaoImpl implements UserDao {

	private static List<User> users;
	
	public UserDaoImpl() {
		createUsersList();
	}
	
	private void createUsersList() {
		if(users == null) {
			users = new ArrayList<>();
			users.add(new User(1l, "John", "Soares"));
			users.add(new User(2l, "Andrio", "Antônio"));
			users.add(new User(3l, "Diego", "Maia"));
			users.add(new User(4l, "Fabiana", "Ângelo"));
		}		
	}

	@Override
	public void save(User user) {
		user.setId(System.currentTimeMillis());
		users.add(user);
	}

	@Override
	public void update(User user) {
		users.stream()
			.filter((u) -> u.getId().equals(user.getId()))
			.forEach((u) -> {
				u.setFirstName(user.getFirstName());
				u.setLastName(user.getLastName());
			});
	}

	@Override
	public void remove(User user) {
		users.removeIf((u) -> u.getId().equals(user.getId()));
	}

	@Override
	public User getUser(long id) {
		return users.stream()
				.filter((u) -> u.getId().equals(id))
				.collect(Collectors.toList())
				.get(0);
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
