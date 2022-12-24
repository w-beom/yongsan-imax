package com.youngsanimax.config;

import com.youngsanimax.domain.Message;
import com.youngsanimax.domain.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class})
class TelegramBotTest {

    @Autowired
    private TelegramBot telegramBot;

    @Test
    public void sendMessageTest() {

    }
}
