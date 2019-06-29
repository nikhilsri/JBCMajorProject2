package com.gfg.JBCMajorProject.JBCMajorProject.model;

import org.springframework.stereotype.Component;

@Component
public class TwitterRecipient {

    private String recipientId;
    private String message;

    public TwitterRecipient() {
    }

    public TwitterRecipient(String recipientId, String message) {
        this.recipientId = recipientId;
        this.message = message;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
