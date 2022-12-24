package com.youngsanimax.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CGV implements Cinema {
    private LocalDate date;
    private String movieName;
    private String movieCode;

    public CGV(String date, String movieName, String movieCode) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.movieName = movieName;
        this.movieCode = movieCode;
    }
}
