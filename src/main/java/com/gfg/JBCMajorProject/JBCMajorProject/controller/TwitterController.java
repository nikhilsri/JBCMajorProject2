package com.gfg.JBCMajorProject.JBCMajorProject.controller;


import com.gfg.JBCMajorProject.JBCMajorProject.model.TwitterRecipient;
import com.gfg.JBCMajorProject.JBCMajorProject.repository.RedisConnection;
import com.gfg.JBCMajorProject.JBCMajorProject.service.TwitterService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class TwitterController {

    @Autowired
    TwitterService twitterService;

    @Autowired
    RedisConnection redisConnection;

    private Twitter twitter= TwitterFactory.getSingleton();
    @PostMapping("/createTweet/{tweet}")
    @ApiOperation(value = "Creates tweet from our timeline")
    public String createTweet(@PathVariable("tweet") String tweet) throws TwitterException {

        Status status = twitter.updateStatus(tweet);
        return status.getText();
    }

    @ApiOperation(value="Returns our Timeline")
    @GetMapping("/timeline")
    public List<String> getTimeline() throws TwitterException {

        return twitterService.getTimelineFromDao(twitter);
    }

    @ApiOperation(value="Sends DM to a particular Recipient")
    @PostMapping("/sendDM")
    public String sendDM(@RequestBody TwitterRecipient recipient) throws TwitterException {

        return twitterService.sendDMFromDao(recipient,twitter);
    }

    @ApiOperation(value = "Save the timeline into Redis")
    @PostMapping("/saveRedis")
    public String saveToRedis() throws TwitterException {
        return twitterService.saveInRedis(twitter);
    }
}
