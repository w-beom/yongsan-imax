package com.youngsanimax.domain.cinema;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CGV {
    private List<LocalDate> days;
    private String movieName;
    private String movieCode;

    public CGV(List<LocalDate> days, String movieName, String movieCode) {
        this.days = days;
        this.movieName = movieName;
        this.movieCode = movieCode;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieCode() {
        return movieCode;
    }

    public String getDays() {
        return days.stream()
                .map(LocalDate::toString)
                .collect(Collectors.joining(" "));
    }

    public boolean sameDays(List<LocalDate> paramDays) {
        int daysSize = this.days.size();
        int paramDaysSize = paramDays.size();

        if (daysSize >= paramDaysSize) {
            for (int i = 0; i < paramDaysSize; i++) {
                if (!days.get(i).isEqual(paramDays.get(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < daysSize; i++) {
                if (paramDays.get(i).isEqual(days.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
