package com.gfg.JBCMajorProject.JBCMajorProject.dao;

import com.gfg.JBCMajorProject.JBCMajorProject.model.TimelineStatus;
import com.gfg.JBCMajorProject.JBCMajorProject.model.TwitterRecipient;
import com.gfg.JBCMajorProject.JBCMajorProject.repository.RedisConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.*;

@Component
public class TwitterDao {



        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(
            RedisConnection.class);

    public List<String> getTimeline(Twitter twitter) throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        List<String> result=new ArrayList<>();


        for (Status status : statuses) {
            String name=status.getUser().getName() + ":";
            String text=status.getText();
            result.add(name+text);
        }

        return result;
    }

    public String sendDirectMessage(TwitterRecipient recipient, Twitter twitter) throws TwitterException {
        DirectMessage message = twitter.sendDirectMessage(recipient.getRecipientId(), recipient.getMessage());
        return "Sent: "+ message.getText() + " to @" + message.getId();
    }

}
