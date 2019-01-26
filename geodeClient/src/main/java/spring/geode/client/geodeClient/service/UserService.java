package spring.geode.client.geodeClient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.geode.client.geodeClient.repository.UserRepository;
import spring.geode.geodeCommon.model.User;
import spring.geode.geodeCommon.model.UserRequest;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository rep;

	public User findByName(String name) {
		List<User> users = rep.findByName(name);
		if (!users.isEmpty()) {
			System.out.println(users);

			return users.get(0);
		}
		return null;
	}

	public User register(UserRequest request) {
		User commited = rep.save(new User(request));
		System.out.println(commited);
		return commited;
	}
	
	public List<User> findAll(){
		List<User> users=new ArrayList<>();
		rep.findAll().forEach(user -> users.add(user));;
		return users;
	}

}
