package io.github.samirsales.curso.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import io.github.samirsales.curso.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static List<User> users;
	
	public UserDaoImpl() {
		createUsersList();
	}
	
	private void createUsersList() {
		if(users == null) {
			users = new ArrayList<>();
			users.add(new User(1L, "John", "Soares"));
			users.add(new User(2L, "Andrio", "Antônio"));
			users.add(new User(3L, "Diego", "Maia"));
			users.add(new User(4L, "Fabiana", "Ângelo"));
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
	public void remove(long id) {
		users.removeIf((u) -> u.getId().equals(id));
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
