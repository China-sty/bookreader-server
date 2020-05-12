package com.example.bookreader.config;

import com.example.bookreader.bean.CachePool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunTimeConfig {
    @Value("${runtime.bean.cache.size1}")
    int size1;
    @Value("${runtime.bean.cache.size2}")
    int size2;

    @Bean
    public CachePool getCachePool(){
        CachePool cachePool=CachePool.getCachePool();
        cachePool.setSize1(size1);
        cachePool.setSize2(size2);
        return cachePool;
    }
}
