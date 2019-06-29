package com.gfg.JBCMajorProject.JBCMajorProject.service;

import com.gfg.JBCMajorProject.JBCMajorProject.dao.TwitterDao;
import com.gfg.JBCMajorProject.JBCMajorProject.model.TwitterRecipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

@Service
public class TwitterService {

    @Autowired
    TwitterDao twitterDao;

    public List<String> getTimelineFromDao(Twitter twitter) throws TwitterException {

        List<String> list;
        list=twitterDao.getTimeline(twitter);
        return list;
    }

    public String sendDMFromDao(TwitterRecipient recipient, Twitter twitter) throws TwitterException {

        return twitterDao.sendDirectMessage(recipient,twitter);
    }

}
