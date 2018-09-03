package io.github.samirsales.curso.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import io.github.samirsales.curso.domain.Gender;
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
			users.add(new User(1L, "John", "Soares", LocalDate.of(1992, 5, 10), Gender.MALE));
			users.add(new User(2L, "Andrio", "Antônio", LocalDate.of(1990, 5, 10), Gender.MALE));
			users.add(new User(3L, "Diego", "Maia", LocalDate.of(1982, 5, 10), Gender.MALE));
			users.add(new User(4L, "Fabiana", "Ângelo", LocalDate.of(1981, 5, 10), Gender.FEMALE));
			users.add(new User(5L, "Samir", "Sales", LocalDate.of(1989, 3, 10), Gender.MALE));
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
				u.setDtBirth(user.getDtBirth());
				u.setGender(user.getGender());
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
