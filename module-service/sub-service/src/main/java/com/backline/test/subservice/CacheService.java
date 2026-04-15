package com.backline.test.subservice;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

public class CacheService {

    private final LoadingCache<String, String> cache;
    private final ObjectMapper mapper = new ObjectMapper();

    public CacheService() {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<>() {
                    @Override
                    public String load(String key) {
                        return "value-for-" + key;
                    }
                });
    }

    public String get(String key) throws Exception {
        return cache.get(key);
    }

    public String toJson(Object obj) throws Exception {
        return mapper.writeValueAsString(obj);
    }

    public static void main(String[] args) throws Exception {
        CacheService service = new CacheService();
        System.out.println("Cached: " + service.get("test-key"));
    }
}
