package com.ipark.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<>();

	private static Integer userCount = 3;
	static {
		userList.add(new User(1, "vinod", new Date()));
		userList.add(new User(2, "Prakriti", new Date()));
		userList.add(new User(3, "Megha", new Date()));
	}

	public List<User> findAll() {
		return userList;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}

	public User findOne(Integer id) {

		Optional<User> user = userList.stream().filter(p -> p.getId() == id).findFirst();
		if (!user.isPresent())
			return null;
		return user.get();
	}

	public User deleteById(Integer id) {

		Iterator<User> userIter = userList.iterator();
		while(userIter.hasNext()) {
			User user = userIter.next();
			if(user.getId()==id) {
				userIter.remove();
				return user;
			}
		}
		return null;
	}
}
