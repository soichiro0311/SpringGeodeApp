package spring.geode.client.geodeClient.repository;

import java.util.List;

import org.springframework.data.gemfire.repository.GemfireRepository;

import spring.geode.geodeCommon.model.User;

public interface UserRepository extends GemfireRepository<User, Integer> {
	List<User> findByName(String name);
}
