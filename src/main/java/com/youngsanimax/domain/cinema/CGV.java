package com.youngsanimax.domain.cinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CGV {
    private LocalDate date;
    private String movieName;
    private String movieCode;

    public CGV(String date, String movieName, String movieCode) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.movieName = movieName;
        this.movieCode = movieCode;
    }

    public boolean equals(CGV cgv) {
        if (this == cgv) {
            return true;
        }
        if (cgv == null || getClass() != cgv.getClass()) {
            return false;
        }
        return Objects.equals(date, cgv.date) && Objects.equals(movieCode, cgv.movieCode);
    }

    public int hashCode() {
        return Objects.hash(date, movieName, movieCode);
    }
}
