package com.sapizon.productcatalog.repository;

import com.sapizon.productcatalog.model.ProductModel;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static final String KEY = "Product";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, ProductModel> hashOperations;

    public ProductRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(ProductModel product) {
        hashOperations.put(KEY, product.getId(), product);
    }

    @Override
    public ProductModel find(Long id) {
        return hashOperations.get(KEY, id);
    }

    @Override
    public void update(ProductModel product) {
        hashOperations.put(KEY, product.getId(), product);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public Map<Long, ProductModel> findAll() {
        return hashOperations.entries(KEY);
    }
}
