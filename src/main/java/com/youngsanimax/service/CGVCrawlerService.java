package com.youngsanimax.service;

import com.youngsanimax.domain.browser.Browser;
import com.youngsanimax.domain.browser.Chrome;
import com.youngsanimax.domain.cinema.CGV;
import com.youngsanimax.domain.messenger.Message;
import com.youngsanimax.domain.messenger.TelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CGVCrawlerService implements CrawlerService {
    @Autowired
    private TelegramBot telegramBot;

    public void crawling(Browser browser) {
        boolean success = telegramBot.sendMessage(new Message("5267186305", "서비스를 시작합니다."));
        if (!success) {
            log.info("메시지전송에 실패하였습니다. : 서비스를 시작합니다.");
        }

        String url = getUrl();
        List<CGV> movies = new ArrayList<>();

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
            log.error("error", e);
        }
    }

    private String getUrl() {
        String movieCdGroup = "20030160";
        String theaterCode = "0013";
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        return "http://ticket.cgv.co.kr/Reservation/Reservation.aspx?MOVIE_CD=20031534&MOVIE_CD_GROUP=" + movieCdGroup + "&PLAY_YMD=" + today + "&THEATER_CD=" + theaterCode + "&PLAY_NUM=&PLAY_START_TM=&AREA_CD=&SCREEN_CD=&THIRD_ITEM=&SCREEN_RATING_CD=";
    }
}
