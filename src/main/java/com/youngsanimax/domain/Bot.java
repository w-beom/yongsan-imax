package com.youngsanimax.domain;

public interface Bot {
    String getToken();

    boolean sendMessage(Message message);
}
