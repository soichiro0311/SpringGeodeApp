package spring.geode.geodeCommon.region;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;

import spring.geode.geodeCommon.listener.UserRegionListener;
import spring.geode.geodeCommon.model.User;

public class UserRegion {
	public Region<Integer, User> createUserRegion(final GemFireCache cache) {
        return cache.<Integer, User>getRegion("Users");
    }
	
    public ReplicatedRegionFactoryBean<Integer, User> createUserRegionFactory(GemFireCache cache) {
		ReplicatedRegionFactoryBean<Integer, User> replicatedRegionFactory = new ReplicatedRegionFactoryBean<>();
		UserRegionListener[] listeners = {new UserRegionListener()};
		listeners[0] = new UserRegionListener();
		replicatedRegionFactory.setCacheListeners(listeners);
		replicatedRegionFactory.setClose(false);
		replicatedRegionFactory.setCache(cache);
		replicatedRegionFactory.setRegionName("Users");
		replicatedRegionFactory.setPersistent(false);
        return replicatedRegionFactory;
    }

}
