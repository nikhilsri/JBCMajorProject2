package com.gfg.JBCMajorProject.JBCMajorProject.db;

import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component
public interface Persistable {

    public void persist(Twitter twitter)throws TwitterException;
}
