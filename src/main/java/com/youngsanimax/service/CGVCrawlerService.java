package com.youngsanimax.service;

import com.youngsanimax.domain.Browser;
import com.youngsanimax.domain.CGV;
import com.youngsanimax.domain.Chrome;
import com.youngsanimax.domain.TelegramBot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CGVCrawlerService implements CrawlerService {

    @Autowired
    private TelegramBot telegramBot;

    public void crawling() {
        String url = getUrl();
        List<CGV> movies = new ArrayList<>();

        Browser browser = new Chrome();
        WebDriver webDriver = browser.getWebDriver();
        webDriver.get(url);
        try {
            List<WebElement> dates = webDriver.findElements(By.xpath("//*[@id=\"date_list\"]/ul/div/li"));
            for (WebElement date : dates) {
                String className = date.getAttribute("class");
                if (className.contains("dimmed")) {
                    continue;
                }
                String date2 = date.getAttribute("date");
                movies.add(new CGV(date2, "아바타", "20030160"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUrl() {
        String movieCdGroup = "20030160";
        String theaterCode = "0013";
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

//        return "http://www.cgv.co.kr/theaters/?areacode=" + areaCode + "&theaterCode=" + theaterCode + "&date=" + today;
        return "http://ticket.cgv.co.kr/Reservation/Reservation.aspx?MOVIE_CD=20031534&MOVIE_CD_GROUP=" + movieCdGroup + "&PLAY_YMD=" + today + "&THEATER_CD=" + theaterCode + "&PLAY_NUM=&PLAY_START_TM=&AREA_CD=&SCREEN_CD=&THIRD_ITEM=&SCREEN_RATING_CD=";
    }
}
