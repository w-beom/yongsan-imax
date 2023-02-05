package com.youngsanimax.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.youngsanimax.domain.browser.Browser;
import com.youngsanimax.domain.cinema.megabox.MegaBox;
import com.youngsanimax.domain.cinema.megabox.Movie;
import com.youngsanimax.domain.cinema.megabox.MovieForm;
import com.youngsanimax.domain.messenger.Message;
import com.youngsanimax.domain.messenger.TelegramBot;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
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
        telegramBot.sendMessage(new Message("-1001505589405", "CGV 앤트맨 알리미 서비스를 시작합니다."));

        ScheduledFuture<?> future = this.taskScheduler.schedule(() -> {
            String url = "http://www.cgv.co.kr/movies/pre-movies.aspx";
            Connection connect = Jsoup.connect(url);
            try {
                Document document = connect.get();
                Elements elementsByTag = document.getElementById("contents").getElementsByTag("ol");
                for (Element element : elementsByTag) {
                    String text = element.text();
                    if (text.contains("앤트맨과 와스프-퀀텀매니아")) {
                        Elements liElements = element.getElementsByTag("li");
                        for (Element liElement : liElements) {
                            String title = liElement.text();
                            if (title.contains("앤트맨과 와스프-퀀텀매니아")) {
                                Element select = liElement.selectFirst("span.like");
                                int i = select.childrenSize();
                                if (i > 0) {
                                    telegramBot.sendMessage(new Message("-1001505589405", "앤트맨과 와스프-퀀텀매니아 예매준비알림!! \nhttp://www.cgv.co.kr/movies/pre-movies.aspx"));
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                telegramBot.sendMessage(new Message("-1001505589405", "에러 발생"));
                log.error("에러발생", e);
            }
        }, new CronTrigger("*/10 * * * * *"));
    }
}
