package com.youngsanimax.service;

import com.youngsanimax.domain.Browser;
import com.youngsanimax.domain.Chrome;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Crawler {

    @Autowired
    @Value("${crawler.driver}")
    private Browser browser;

    @Scheduled(cron = "*/10 * * * * *")
    public void crawling() throws IOException {
        String url = "http://www.cgv.co.kr/theaters/?areacode=01&theaterCode=0013&date=20221220";

        System.out.println(browser);
//        Browser browser = new Chrome();
//        WebDriver webDriver = browser.getWebDriver();
//        webDriver.get(url);
    }
}
