package com.youngsanimax.service;

import com.youngsanimax.config.TelegramBot;
import com.youngsanimax.domain.Browser;
import com.youngsanimax.domain.Chrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Crawler {

    @Autowired
    private TelegramBot telegramBot;

    @Scheduled(cron = "*/10 * * * * *")
    public void crawling() throws IOException, InterruptedException {
        String url = "http://www.cgv.co.kr/theaters/?areacode=01&theaterCode=0013&date=20221220";

        Browser browser = new Chrome();
        WebDriver webDriver = browser.getWebDriver();
        webDriver.get(url);

        webDriver.switchTo().frame(3);

        List<WebElement> firstDates = webDriver.findElement(By.xpath("//*[@id=\"slider\"]/div[1]/ul")).findElements(By.tagName("li"));
        List<WebElement> secondDates = webDriver.findElement(By.xpath("//*[@id=\"slider\"]/div[2]/ul")).findElements(By.tagName("li"));

        for (WebElement date : firstDates) {
            Thread.sleep(5000);
            date.findElement(By.tagName("a")).click();
            webDriver.switchTo().frame(0);
        }
    }
}
