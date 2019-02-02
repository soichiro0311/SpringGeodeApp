package spring.geode.server.geodeServer;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;
import org.springframework.data.gemfire.config.annotation.PeerCacheApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import spring.geode.geodeCommon.model.User;
import spring.geode.geodeCommon.region.UserRegion;
import spring.geode.server.geodeServer.repository.UserRepository;

@SpringBootApplication
@PeerCacheApplication(name = "SpringGeodeServerApplication", locators = "localhost[40404]")
@EnableGemfireRepositories(basePackageClasses = UserRepository.class)
public class GeodeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeodeServerApplication.class, args);
	}

	@Configuration
	@EnableLocator(port = 40404)
	@EnableManager(start = true)
	static class LocatorManagerConfiguration {
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
