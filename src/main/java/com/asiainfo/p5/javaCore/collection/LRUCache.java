package com.asiainfo.p5.javaCore.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Java实现LRU缓存的方式一——继承LinkedHashMap
 *
 * @author zhangzhiwang
 * @date Feb 26, 2020 9:49:45 PM
 */
public class LRUCache extends LinkedHashMap<Integer, String> {
	private static final long serialVersionUID = 7696610591026159729L;
	private static int MAX_CACHE_SIZE;

	public LRUCache(int initialCapacity) {
		super(initialCapacity, 0.75f, false);
		MAX_CACHE_SIZE = initialCapacity;
	}
	
	@Override
	public boolean removeEldestEntry(Map.Entry<Integer,String> eldest) {
        return size() > MAX_CACHE_SIZE;
    }
	
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, "a");
		lruCache.put(2, "b");
		lruCache.put(3, "c");
//		lruCache.put(4, "d");
		
		System.out.println(lruCache);
	}
}
