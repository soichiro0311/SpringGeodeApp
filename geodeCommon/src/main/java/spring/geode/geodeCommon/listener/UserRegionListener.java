package spring.geode.geodeCommon.listener;

import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.RegionEvent;

import spring.geode.geodeCommon.model.User;

public class UserRegionListener implements CacheListener<Integer,User> {
	public void afterCreate(EntryEvent<Integer,User> event) {
		System.out.println("afterCreate!!!!!!!!!" + event.getNewValue());
	}

	public void afterDestroy(EntryEvent<Integer, User> event) {
		System.out.println("afterDestroy!!!!!!!!!" + event);
	}

	public void afterInvalidate(EntryEvent<Integer, User> event) {
		System.out.println("afterInvalidate!!!!!!!!!" + event);
	}

	public void afterRegionDestroy(RegionEvent<Integer, User> event) {
		System.out.println("afterRegionDestroy!!!!!!!!!" + event);
	}

	public void afterRegionCreate(RegionEvent<Integer, User> event) {
		System.out.println("afterRegionCreate!!!!!!!!!" + event);
	}

	public void afterRegionInvalidate(RegionEvent<Integer, User> event) {
		System.out.println("afterRegionInvalidate!!!!!!!!!" + event);
	}

	public void afterUpdate(EntryEvent<Integer, User> event) {
		System.out.println("afterUpdate!!!!!!!!!" + event);
	}

	public void afterRegionClear(RegionEvent<Integer, User> event) {
		System.out.println("afterRegionClear!!!!!!!!!" + event);
	}

	public void afterRegionLive(RegionEvent<Integer, User> event) {
		System.out.println("afterRegionLive!!!!!!!!!" + event);
	}

	public void close() {
		System.out.println("close!!!!!!!!!");
	}


}
