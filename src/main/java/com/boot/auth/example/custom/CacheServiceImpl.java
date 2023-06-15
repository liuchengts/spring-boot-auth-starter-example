//package com.boot.auth.example.custom;
//
//import com.boot.auth.starter.common.AuthProperties;
//import com.boot.auth.starter.service.impl.DefaultCacheServiceImpl;
//import com.boot.auth.starter.support.GuavaCacheSupport;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//
//@Slf4j
//@Primary
//@Service
//public class CacheServiceImpl extends DefaultCacheServiceImpl {
//    final
//    StringRedisTemplate stringRedisTemplate;
//
//    public CacheServiceImpl(GuavaCacheSupport guavaCacheSupport,
//                            AuthProperties authProperties,
//                            StringRedisTemplate stringRedisTemplate) {
//        super(guavaCacheSupport, authProperties);
//        this.stringRedisTemplate = stringRedisTemplate;
//    }
//
//    @Override
//    public void put(String key, String data) {
//        stringRedisTemplate.opsForHash().put(key, data);
//    }
//
//    @Override
//    public String get(String key) {
//        if (authProperties.getExclude() != null
//                && authProperties.getExclude()
//                && !this.exclude(key)) {
//            return null;
//        }
//        Object obj = guavaCacheSupport.getCache().getIfPresent(key);
//        if (obj == null) return null;
//        return obj.toString();
//    }
//
//    @Override
//    public String get(String key, Callable<Object> loader) throws ExecutionException {
//        if (authProperties.getExclude() != null
//                && authProperties.getExclude()
//                && !this.exclude(key)) {
//            return null;
//        }
//        return guavaCacheSupport.getCache().get(key, loader).toString();
//
//    }
//
//    @Override
//    public Object excludeGet(String keyExclude) {
//        return guavaCacheSupport.getCache().getIfPresent(keyExclude);
//    }
//
//    @Override
//    public Object excludeGet(String keyExclude, Callable<Object> loader) {
//        try {
//            return guavaCacheSupport.getCache().get(keyExclude, loader);
//        } catch (ExecutionException e) {
//            log.error("excludeGet [" + keyExclude + "]", e);
//        }
//        return null;
//    }
//
//    @Override
//    public Long getExpire(String key) {
//        if (this.get(key) != null) return 1L;
//        return 0L;
//    }
//
//    @Override
//    public void remove(String key) {
//        guavaCacheSupport.getCache().invalidate(key);
//    }
//}
