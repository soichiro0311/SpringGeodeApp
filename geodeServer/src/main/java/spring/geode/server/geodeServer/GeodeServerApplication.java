package spring.geode.server.geodeServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import spring.geode.geodeCommon.model.User;
import spring.geode.server.geodeServer.repository.UserRepository;

@SpringBootApplication
@CacheServerApplication(locators = "localhost[40404]")
@EnableGemfireRepositories(basePackageClasses = UserRepository.class)
@EnableEntityDefinedRegions(basePackageClasses = User.class)
@EnablePdx
public class GeodeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeodeServerApplication.class, args);
	}

	@Configuration
	@EnableLocator(port = 40404)
	@EnableManager(start = true)
	static class LocatorManagerConfiguration {
	}

}
