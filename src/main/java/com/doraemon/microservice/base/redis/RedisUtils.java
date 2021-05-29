package com.doraemon.microservice.base.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wildzong
 * @Description: 自定义 Redis 工具类
 * @Date: 2021-05-27 19:10
 */
@Component
public final class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // ############### Common Util ###################
    /**
     * 设置缓存有效时间
     * @param key
     * @param time 有效时间，单位为秒
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取key在缓存中的失效时间
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据keys删除缓存，可传入一个或者多个key
     * @param keys
     */
    public void del(String... keys) {
        // keys不为null且keys中有值
        if (keys != null && keys.length != 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(keys));
            }
        }
    }

    // ############### String Util ###################
    /**
     * 普通缓存获取
     * @param key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param key 单位秒
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key
     * @param delta 递增因子，必须大于0
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key
     * @param delta 递减因子，必须小于0
     * @return
     */
    public long decr(String key, long delta) {
        if (delta > 0) {
            throw new RuntimeException("递减因子必须小于0");
        }
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    // ############### Map Util ###################

    /**
     * map 的 get 方法
     * @param key 键
     * @param field 项
     * @return
     */
    public Object hGet(String key,String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 获取key对应的所有键项
     * @param key
     * @return
     */
    public Map<Object, Object> hEntriesGet (String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * map 的 set值方法
     * @param key
     * @param entries
     * @return
     */
    public boolean hEntriesSet(String key, Map<Object, Object> entries) {
        try {
            redisTemplate.opsForHash().putAll(key, entries);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * map 的带时间 set值方法
     * @param key
     * @param entries
     * @param time 过期时间，单位为秒
     * @return
     */
    public boolean hEntriesSet(String key, Map<Object, Object> entries, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, entries);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向key中放入entry ： value，不存在则创建
     * @param key
     * @param entry
     * @param value
     * @return
     */
    public boolean hSet(String key, String entry, Object value) {
        try {
            redisTemplate.opsForHash().put(key, entry, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向key中放入entry ： value，不存在则创建，同时设置过期时间
     * @param key
     * @param entry
     * @param value
     * @return
     */
    public boolean hSet(String key, String entry, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, entry, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除key中的entries项
     * @param key
     * @param entries
     */
    public void hDel(String key, String... entries) {
        redisTemplate.opsForHash().delete(key, entries);
    }

    /**
     * 判断 key 中是否有 entry 项
     * @param key
     * @param entry
     * @return
     */
    public boolean hHasEntry(String key, String entry) {
        return redisTemplate.opsForHash().hasKey(key, entry);
    }

    /**
     * key中的entry项递增
     * @param key
     * @param entry
     * @param delta
     * @return
     */
    public long hIncr(String key, String entry, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForHash().increment(key, entry, delta);
    }

    /**
     * key中的entry项递减
     * @param key
     * @param entry
     * @param delta
     * @return
     */
    public long hDncr(String key, String entry, long delta) {
        if (delta > 0) {
            throw new RuntimeException("递增因子必须小于0");
        }
        return redisTemplate.opsForHash().increment(key, entry, delta);
    }

    // todo list和set相关工具类待补充
    // ############### List Util ###################
    // ############### Set Util ###################

}
