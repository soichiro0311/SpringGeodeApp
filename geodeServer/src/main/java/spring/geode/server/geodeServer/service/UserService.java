package spring.geode.server.geodeServer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.geode.geodeCommon.model.User;
import spring.geode.geodeCommon.model.UserRequest;
import spring.geode.server.geodeServer.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository rep; 
	public User findByName(String name) {
		User user=rep.findByName(name).get(0);
		System.out.println(user);
		return user;
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
