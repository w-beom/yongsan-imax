package com.youngsanimax.domain.messenger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    public void printMessage() {
        log.info("chatId : " + chat_id + " message : " + text);
    }
}
