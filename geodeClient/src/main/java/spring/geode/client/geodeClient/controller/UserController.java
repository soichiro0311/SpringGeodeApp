package spring.geode.client.geodeClient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.geode.client.geodeClient.service.UserService;
import spring.geode.geodeCommon.model.User;
import spring.geode.geodeCommon.model.UserRequest;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@RequestMapping(path = "/find/user/{name}", method = RequestMethod.GET)
	public User findById(@PathVariable String name) {
		return userService.findByName(name);
	}

	@RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
	
	@RequestMapping(path = "/register/user", method = RequestMethod.POST)
	public String register(@RequestBody UserRequest request) {
		return userService.register(request).getName();
	}
}
