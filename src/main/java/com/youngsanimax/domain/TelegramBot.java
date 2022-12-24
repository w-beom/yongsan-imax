package com.youngsanimax.domain;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TelegramBot implements Bot {
    @Value("${messenger.token-id}")
    private String token;

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public boolean sendMessage(Message message) {
        String json = new Gson().toJson(message);

        String url = "https://api.telegram.org/bot" + token + "/sendMessage?";

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(json, MediaType.parse("application/json")))
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("body : " + response.message());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
