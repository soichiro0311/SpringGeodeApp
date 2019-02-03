package spring.geode.geodeCommon.region;

import java.io.File;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;

import spring.geode.geodeCommon.listener.UserRegionListener;
import spring.geode.geodeCommon.model.User;

/**
 * ユーザを管理する{@link Region}の設定を作成する
 *
 */
public class UserRegion {
	/**
	 * {@link Region}の作成を行う
	 * @param cache
	 * @return
	 */
	public Region<Integer, User> createUserRegion(final GemFireCache cache) {
		return cache.<Integer, User>getRegion("Users");
	}

	/**
	 * {@link Region}に対する設定を行う
	 * @param cache
	 * @return
	 */
	public ReplicatedRegionFactoryBean<Integer, User> createUserRegionFactory(GemFireCache cache) {
		ReplicatedRegionFactoryBean<Integer, User> replicatedRegionFactory = new ReplicatedRegionFactoryBean<>();
		UserRegionListener[] listeners = { new UserRegionListener() };

		listeners[0] = new UserRegionListener();
		replicatedRegionFactory.setCacheListeners(listeners);
		replicatedRegionFactory.setClose(false);
		replicatedRegionFactory.setCache(cache);
		replicatedRegionFactory.setRegionName("Users");
		replicatedRegionFactory.setPersistent(true);
		return replicatedRegionFactory;
	}

	/**
	 * {@link Region}に対するファイル永続化設定を行う
	 * @param cache
	 * @param regionFactory
	 * @return
	 */
	public ReplicatedRegionFactoryBean<Integer, User> configDiskStore(GemFireCache cache,
			ReplicatedRegionFactoryBean<Integer, User> regionFactory) {
		File[] files = { new File("/Users/seike0311/repos/SpringGeode/persistenceFile") };

		cache.createDiskStoreFactory()//
				.setAllowForceCompaction(true)//
				.setAutoCompact(true)//
				.setDiskDirs(files)//
				.create("SimpleDiskStore");

		regionFactory.setDiskStoreName("SimpleDiskStore");

		return regionFactory;
	}
}
