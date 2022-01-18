package com.example.configservice.services;

import com.example.configservice.entity.Configuration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class Cache {
    private static final Integer EXPIRE_AFTER = 5;

    private LoadingCache<Integer, Configuration> configurationCache;

    Logger logger = LoggerFactory.getLogger(Cache.class);

    public Cache(){
        configurationCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_AFTER, TimeUnit.MINUTES).build(new CacheLoader<Integer, Configuration>() {

            @Override
            public Configuration load(Integer key) throws Exception{
                return null;
            }
        });
    }

    public void addConfigcache(int tenantId, Configuration object){
        configurationCache.put(tenantId, object);
    }

    public Configuration getConfig(int tenantId){
        Configuration congfigJsonObject = null;
        try {
            congfigJsonObject= configurationCache.get(tenantId);
        } catch (Exception e){
            return null;
//            e.printStackTrace();
        }
        return congfigJsonObject;
    }

    public LoadingCache<Integer, Configuration> getLoadingCache(){
        return configurationCache;
    }

    public void clearConfig(int tenantId){
        configurationCache.invalidate(tenantId);
    }
}
