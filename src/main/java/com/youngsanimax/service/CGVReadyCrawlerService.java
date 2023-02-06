package com.youngsanimax.service;

import com.youngsanimax.domain.Theater;
import com.youngsanimax.domain.browser.Browser;
import com.youngsanimax.domain.messenger.TelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ScheduledFuture;

@Service
@Slf4j
public class CGVReadyCrawlerService implements CrawlerService {
    private final TelegramBot telegramBot;
    private final TaskScheduler taskScheduler;

    public CGVReadyCrawlerService(TelegramBot telegramBot, TaskScheduler taskScheduler) {
        this.telegramBot = telegramBot;
        this.taskScheduler = taskScheduler;
    }

    @Override
    public void crawling(Browser browser) {
//        telegramBot.sendMessage(new Message("-1001505589405", "CGV 앤트맨 알리미 서비스를 시작합니다."));

        ScheduledFuture<?> future = this.taskScheduler.schedule(() -> {
            String url ="http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=01&theatercode=0013&date=20230206";
            Connection connect = Jsoup.connect(url).header("Referer","http://www.cgv.co.kr/theaters/");
            try {
                Document document = connect.get();
                log.info(document.html());
            } catch (IOException e) {
//                telegramBot.sendMessage(new Message("-1001505589405", "에러 발생"));
                log.error("에러발생", e);
            }
        }, new CronTrigger("*/10 * * * * *"));
    }

    private String getUrl() {
        String movieCdGroup = "20031858";
        Theater theaterCode = Theater.YONGSAN;
        String today = "20230219";

        return "http://ticket.cgv.co.kr/Reservation/Reservation.aspx?MOVIE_CD=20031534&MOVIE_CD_GROUP=" + movieCdGroup + "&PLAY_YMD=" + today + "&THEATER_CD=" + theaterCode.getCode() + "&PLAY_NUM=&PLAY_START_TM=&AREA_CD=&SCREEN_CD=&THIRD_ITEM=&SCREEN_RATING_CD=";
    }
}
