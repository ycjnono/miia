/**
 * all Copyright 2018 MIIA
 */
package com.miia.cache.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.miia.cache.IRedisService;


/**
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class RedisServiceImpl implements IRedisService {

	
	@Autowired
	private RedisTemplate redisTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#expire(java.lang.String, long)
	 */
	@Override
	public boolean expire(String key, long time) {
		if (time > 0) {
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#getExpire(java.lang.String)
	 */
	@Override
	public long getExpire(String key) {
		long time = redisTemplate.getExpire(key, TimeUnit.SECONDS);
		return time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hasKey(java.lang.String)
	 */
	@Override
	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#del(java.lang.String[])
	 */
	@Override
	public void del(String... keys) {
		if (keys != null && keys.length > 0) {
			if (keys.length == 1) {
				redisTemplate.delete(keys[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(keys));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#get(java.lang.String)
	 */
	@Override
	public Object get(String key) {
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#set(java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#set(java.lang.String, java.lang.Object,
	 * long)
	 */
	@Override
	public boolean set(String key, Object value, long time) {
		if (time > 0) {
			redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
		} else {
			set(key, value);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#incr(java.lang.String, long)
	 */
	@Override
	public long incr(String key, long delta) {
		return redisTemplate.opsForValue().increment(key, delta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#decr(java.lang.String, long)
	 */
	@Override
	public long decr(String key, long delta) {
		return redisTemplate.opsForValue().increment(key, -delta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hget(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Object hget(String key, String item) {
		return redisTemplate.opsForHash().get(key, item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hmget(java.lang.String)
	 */
	@Override
	public Map<Object, Object> hmget(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hmset(java.lang.String, java.util.Map)
	 */
	@Override
	public boolean hmset(String key, Map<String, Object> map) {
		redisTemplate.opsForHash().putAll(key, map);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hmset(java.lang.String, java.util.Map,
	 * long)
	 */
	@Override
	public boolean hmset(String key, Map<String, Object> map, long time) {
		redisTemplate.opsForHash().putAll(key, map);
		if (time > 0) {
			expire(key, time);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hset(java.lang.String,
	 * java.lang.String, java.lang.Object)
	 */
	@Override
	public boolean hset(String key, String item, Object value) {
		redisTemplate.opsForHash().put(key, item, value);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hset(java.lang.String,
	 * java.lang.String, java.lang.Object, long)
	 */
	@Override
	public boolean hset(String key, String item, Object value, long time) {
		redisTemplate.opsForHash().put(key, item, value);
		if (time > 0) {
			expire(key, time);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hdel(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void hdel(String key, Object... item) {
		redisTemplate.opsForHash().delete(key, item);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hHasKey(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean hHasKey(String key, String item) {
		return redisTemplate.opsForHash().hasKey(key, item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hincr(java.lang.String,
	 * java.lang.String, double)
	 */
	@Override
	public double hincr(String key, String item, double by) {
		return redisTemplate.opsForHash().increment(key, item, by);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#hdecr(java.lang.String,
	 * java.lang.String, double)
	 */
	@Override
	public double hdecr(String key, String item, double by) {
		return redisTemplate.opsForHash().increment(key, item, -by);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#sGet(java.lang.String)
	 */
	@Override
	public Set<Object> sGet(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#sHasKey(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public boolean sHasKey(String key, Object value) {
		return redisTemplate.opsForSet().isMember(key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#sSet(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public long sSet(String key, Object... values) {
		return redisTemplate.opsForSet().add(key, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#sSetAndTime(java.lang.String, long,
	 * java.lang.Object[])
	 */
	@Override
	public long sSetAndTime(String key, long time, Object... values) {
		Long count = redisTemplate.opsForSet().add(key, values);
		if (time > 0)
			expire(key, time);
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#sGetSetSize(java.lang.String)
	 */
	@Override
	public long sGetSetSize(String key) {
		return redisTemplate.opsForSet().size(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#setRemove(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public long setRemove(String key, Object... values) {
		Long count = redisTemplate.opsForSet().remove(key, values);
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lGet(java.lang.String, long, long)
	 */
	@Override
	public List<Object> lGet(String key, long start, long end) {
		return redisTemplate.opsForList().range(key, start, end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lGetListSize(java.lang.String)
	 */
	@Override
	public long lGetListSize(String key) {
		return redisTemplate.opsForList().size(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lGetIndex(java.lang.String, long)
	 */
	@Override
	public Object lGetIndex(String key, long index) {
		return redisTemplate.opsForList().index(key, index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lSet(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public boolean lSet(String key, Object value) {
		redisTemplate.opsForList().rightPush(key, value);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lSet(java.lang.String,
	 * java.lang.Object, long)
	 */
	@Override
	public boolean lSet(String key, Object value, long time) {
		redisTemplate.opsForList().rightPush(key, value);
		if (time > 0)
			expire(key, time);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lSet(java.lang.String, java.util.List)
	 */
	@Override
	public boolean lSet(String key, List<Object> value) {
		redisTemplate.opsForList().rightPushAll(key, value);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lSet(java.lang.String, java.util.List,
	 * long)
	 */
	@Override
	public boolean lSet(String key, List<Object> value, long time) {
		redisTemplate.opsForList().rightPushAll(key, value);
		if (time > 0)
			expire(key, time);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lUpdateIndex(java.lang.String, long,
	 * java.lang.Object)
	 */
	@Override
	public boolean lUpdateIndex(String key, long index, Object value) {
		redisTemplate.opsForList().set(key, index, value);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.miia.cache.IRedisService#lRemove(java.lang.String, long,
	 * java.lang.Object)
	 */
	@Override
	public long lRemove(String key, long count, Object value) {
		Long remove = redisTemplate.opsForList().remove(key, count, value);
		return remove;
	}

}
