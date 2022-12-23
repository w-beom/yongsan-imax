package com.youngsanimax.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TelegramBot implements Bot {
    @Value("${messenger.token-id}")
    private String token;
    @Value("${messenger.chat-id}")
    private String chat_id;

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getChat_id() {
        return chat_id;
    }
}
