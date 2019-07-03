package com.gfg.JBCMajorProject.JBCMajorProject.db;

import com.gfg.JBCMajorProject.JBCMajorProject.repository.RedisConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RedisPersistable implements Persistable {

    @Autowired
    RedisConnection redisConnection;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void persist(Twitter twitter) throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        HashMap<String,String> hm=new HashMap<String,String>();
        for (Status status : statuses) {
            String name=status.getUser().getName() + ":";
            String text=status.getText();
            if(hm.containsKey(name)){
                String temp=hm.get(name);
                temp=temp+status.getText();
                hm.put(name,temp);
            }
            else {
                hm.put(name,status.getText());
            }
        }

        for (Map.Entry<String,String> entry:hm.entrySet()) {

            ValueOperations values = redisTemplate.opsForValue();
            values.set(entry.getKey(),entry.getValue());

            //hashOperations.put(key,key,textList);
        }

    }
}
