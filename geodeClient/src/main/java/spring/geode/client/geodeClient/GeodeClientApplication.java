package spring.geode.client.geodeClient;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.PeerCacheApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import spring.geode.client.geodeClient.repository.UserRepository;
import spring.geode.geodeCommon.model.User;
import spring.geode.geodeCommon.region.UserRegion;

@SpringBootApplication
@PeerCacheApplication(name = "SpringGeodeClientApplication",locators = "localhost[40404]")
@EnableGemfireRepositories(basePackageClasses = UserRepository.class)
public class GeodeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeodeClientApplication.class, args);
	}

	@Configuration
	static class CacheInitializer {
		
		@Bean
	    Region<Integer, User> userRegion(final GemFireCache cache) {
			return new UserRegion().createUserRegion(cache);
	    }
		
		@Bean
	    public ReplicatedRegionFactoryBean<Integer, User> replicatedRegion(GemFireCache cache) {
			return new UserRegion().createUserRegionFactory(cache);
	    }
	}
}

