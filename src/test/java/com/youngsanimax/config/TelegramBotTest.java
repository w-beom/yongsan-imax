package com.youngsanimax.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class})
class TelegramBotTest {

    @Autowired
    private TelegramBot telegramBot;

    @Test
    public void sendMessageTest() {
        System.out.println(telegramBot.getToken());
        Messenger messenger = new Messenger();
        messenger.sendMessage(telegramBot);

    }
}
