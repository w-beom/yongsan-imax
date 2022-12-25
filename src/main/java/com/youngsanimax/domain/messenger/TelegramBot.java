package com.youngsanimax.domain.messenger;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TelegramBot implements Bot {
    @Value("${messenger.token-id}")
    private String token;

    @Override
    public boolean sendMessage(Message message) {
        try {
            message.printMessage();

            String json = new Gson().toJson(message);

            String url = "https://api.telegram.org/bot" + token + "/sendMessage?";

            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(json, MediaType.parse("application/json")))
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            return true;
        } catch (Exception e) {
            log.error("메세지 전송에 실패하였습니다.", e);
            return false;
        }
    }

}
