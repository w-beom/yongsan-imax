package com.youngsanimax.domain;

public enum Theater {
    YONGSAN("0013");

    private String code;

    Theater(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
