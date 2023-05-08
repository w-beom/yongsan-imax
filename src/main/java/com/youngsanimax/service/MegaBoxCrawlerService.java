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
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Slf4j
@Service
public class MegaBoxCrawlerService implements CrawlerService {
    @Autowired
    private TelegramBot telegramBot;

    @Autowired
    private TaskScheduler taskScheduler;

    @Override
    public void crawling(Browser browser) {
        telegramBot.sendMessage(new Message("-1001505589405", "메가박스 가오갤3 알리미 서비스를 시작합니다."));
        ScheduledFuture<?> future = this.taskScheduler.schedule(() -> {
            try {
                String url = "https://www.megabox.co.kr/on/oh/ohc/Brch/schedulePage.do";
                MegaBox megaBox = MegaBox.builder()
                        .areaCd("45")
                        .crtDe("20230508")
                        .firstAt("N")
                        .masterType("movie")
                        .movieNo("23018400")
                        .movieNo1("23018400")
                        .playDe("20230513")
                        .build();

                String json = new Gson().toJson(megaBox);

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .post(RequestBody.create(json, MediaType.parse("application/json")))
                        .build();

                Response execute = client.newCall(request).execute();
                String responseJson = execute.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                Movie movie = objectMapper.readValue(responseJson, Movie.class);
                List<Object> moveFormList = (List<Object>) movie.getMegaMap().get("movieFormList");
                log.info("가디언즈 오브 갤럭시 크롤링중");
                for (Object o : moveFormList) {
                    MovieForm movieForm = objectMapper.convertValue(o, MovieForm.class);
                    if (movieForm.getRpstMovieNo().equals("23018400") && movieForm.getTheabNo().equals("07") && movieForm.getAreaCd().equals("0028")) {
                        String text = movieForm.getPlayDe() + " " + movieForm.getRpstMovieNm() + " " + movieForm.getTheabEngNm() + "\n"
                                + movieForm.getPlayStartTime() + " 예매 알림!!!!!";
                        telegramBot.sendMessage(new Message("-1001505589405", text));
                    }
                }
            } catch (IOException e) {
                log.error("error", e);
                telegramBot.sendMessage(new Message("-1001505589405", "예상치 못한 문제로 서비스를 중지합니다."));
            }
        }, new CronTrigger("*/5 * * * * *"));
    }
}
