package com.gfg.JBCMajorProject.JBCMajorProject.dao;

import com.gfg.JBCMajorProject.JBCMajorProject.model.TwitterRecipient;
import org.springframework.stereotype.Component;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

@Component
public class TwitterDao {

    public List<String> getTimeline(Twitter twitter) throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        List<String> result=new ArrayList<>();
        String str= "Showing home timeline.";
        for (Status status : statuses) {
            result.add(status.getUser().getName() + ":" +
                    status.getText());
        }
        return result;
    }

    public String sendDirectMessage(TwitterRecipient recipient, Twitter twitter) throws TwitterException {
        DirectMessage message = twitter.sendDirectMessage(recipient.getRecipientId(), recipient.getMessage());
        return "Sent: "+ message.getText() + " to @" + message.getId();
    }
}
