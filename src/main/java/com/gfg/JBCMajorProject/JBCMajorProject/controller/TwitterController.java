package com.gfg.JBCMajorProject.JBCMajorProject.controller;


import com.gfg.JBCMajorProject.JBCMajorProject.model.TwitterRecipient;
import com.gfg.JBCMajorProject.JBCMajorProject.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;

import java.util.List;

@RestController
public class TwitterController {

    @Autowired
    TwitterService twitterService;



    private Twitter twitter= TwitterFactory.getSingleton();
    @PostMapping("/createTweet/{tweet}")
    public String createTweet(@PathVariable("tweet") String tweet) throws TwitterException {

        Status status = twitter.updateStatus("creating Tweet using REST "+tweet);
        return status.getText();
    }

    @GetMapping("/timeline")
    public List<String> getTimeline() throws TwitterException {

        return twitterService.getTimelineFromDao(twitter);
    }

    @PostMapping("/sendDM")
    public String sendDM(@RequestBody TwitterRecipient recipient) throws TwitterException {

        return twitterService.sendDMFromDao(recipient,twitter);
    }

}
