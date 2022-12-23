package com.youngsanimax.config;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Messenger {
    public boolean sendMessage(Bot bot) {
        Map<String, String> object = new HashMap<>();
        object.put("chat_id", bot.getChat_id());
        object.put("text", "테스트");
        Gson gson = new Gson();
        String json = gson.toJson(object);

        String url = "https://api.telegram.org/bot" + bot.getToken() + "/sendMessage?";

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(json, MediaType.parse("application/json")))
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("body : " + response.message());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
