package com.boot.auth.example.custom;

import com.boot.auth.example.common.Account;
import com.boot.auth.starter.support.GuavaCacheSupport;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.RemovalListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用 CacheLoader
 *
 * @author liucheng
 * @version 1.0
 * @description: 自定义缓存加载器
 * @date 2023/6/5 17:09
 */
@Slf4j
@Component
public class CacheLoaderImpl {
    final
    GuavaCacheSupport guavaCacheSupport;

    public CacheLoaderImpl(GuavaCacheSupport guavaCacheSupport) {
        this.guavaCacheSupport = guavaCacheSupport;
    }

    @PostConstruct
    public void init() {
        // 设置全局加载器
        guavaCacheSupport.setCacheLoader(new GlobalCacheLoader());
        // 设置全局移除监听器
        guavaCacheSupport.setRemovalListener(getRemovalListener());
    }

    /**
     * db查询
     *
     * @param key 查询条件
     * @return 查询结果
     */
    public Map<String, Account> getDb(String key) {
        // 根据key 从数据库中查询出来
        Map<String, Account> map = new HashMap<>();
        map.put(key, Account.findAccount());
        return map;
    }

    /**
     * 全局缓存加载器
     */
    public class GlobalCacheLoader extends CacheLoader<Object, Object> {

        @Override
        public Object load(Object key) throws Exception {
            // 这里开始加载缓存数据
            return getDb(key.toString());
        }
    }

    /**
     * 全局移除事件监听
     */
    private RemovalListener<Object, Object> getRemovalListener() {
        return notification -> {
            log.warn("移除缓存 key:{} value:{}", notification.getKey(), notification.getValue());
            // 下面是移除了缓存需要做的事情
        };
    }
}
