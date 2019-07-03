package com.gfg.JBCMajorProject.JBCMajorProject.model;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@RedisHash("TimelineStatus")
public class TimelineStatus implements Serializable {

    private String name;
    private String text;

    public TimelineStatus() {
    }

    public TimelineStatus(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TimelineStatus{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
