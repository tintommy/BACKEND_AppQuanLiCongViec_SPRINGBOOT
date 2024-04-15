package org.example.quanlycongviec.repository;


import org.example.quanlycongviec.entity.ConsentOtpRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class ConsentOtpRedisRepository {

//    public static final String HASH_KEY = "Product";
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;
    @CachePut
    public ConsentOtpRedis save(ConsentOtpRedis accountRedis){
        template.opsForHash().put(accountRedis.getOtp(), accountRedis.getEmail(),accountRedis);
        System.out.println(accountRedis);
        template.expire(accountRedis.getOtp(), 2, TimeUnit.MINUTES);
        return accountRedis;
    }

//    public List<accountRedis> findAll(){
//        return template.opsForHash().values(HASH_KEY);
//    }

    public ConsentOtpRedis findConsentOtpRedisById(String otp, String email){
        return (ConsentOtpRedis) template.opsForHash().get(otp,email);
    }

    @CacheEvict
    public String deleteAccountRedis(String hashKey, String otp){
        template.opsForHash().delete(hashKey,otp);
        return "accountRedis removed !!";
    }
    @CacheEvict
    public String deleteAllAccountRedis(String hashKey){
        List<ConsentOtpRedis> consentOtpRedisList = template.opsForHash().values(hashKey);
        if (!consentOtpRedisList.isEmpty()) {
            List<String> hashKeys = consentOtpRedisList.stream().map(item-> item.getOtp().toString()).collect(Collectors.toList());
            template.opsForHash().delete(hashKey, hashKeys);
        }
        return "accountsRedis removed !!";
    }



}
