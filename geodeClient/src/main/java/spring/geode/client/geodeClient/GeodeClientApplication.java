package spring.geode.client.geodeClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import spring.geode.client.geodeClient.repository.UserRepository;
import spring.geode.geodeCommon.model.User;

@SpringBootApplication
@ClientCacheApplication(name = "SpringGeodeClientApplication")
//@EnableClusterConfiguration(useHttp = true)
@EnableGemfireRepositories(basePackageClasses = UserRepository.class)
@EnableEntityDefinedRegions(basePackageClasses = User.class)
@EnablePdx
public class GeodeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeodeClientApplication.class, args);
	}

}

