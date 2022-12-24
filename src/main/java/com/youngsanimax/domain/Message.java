package com.youngsanimax.domain;

import org.springframework.beans.factory.annotation.Value;

public class Message {
    private String chat_id;
    private String text;

    public Message(String chat_id, String text) {
        this.chat_id = chat_id;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
