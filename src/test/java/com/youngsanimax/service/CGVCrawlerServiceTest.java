package com.youngsanimax.service;

import com.youngsanimax.domain.browser.Browser;
import com.youngsanimax.domain.browser.Chrome;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class CGVCrawlerServiceTest {
    @Test
    void crawling() throws InterruptedException {
        String areaCode = "01";
        String theaterCode = "0013";
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String url = "http://www.cgv.co.kr/theaters/?areacode=" + areaCode + "&theaterCode=" + theaterCode + "&date=" + today;

        Browser browser = new Chrome();
        WebDriver webDriver = browser.getWebDriver();
        webDriver.get(url);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("document.getElementsByClassName('descri-info')[0].remove();");

        webDriver.switchTo().frame(3);

        int sliderSize = webDriver.findElement(By.id("slider")).findElements(By.className("item-wrap")).size();
        for (int i = 1; i <= sliderSize; i++) {
            WebElement element = webDriver.findElement(By.xpath("//*[@id=\"slider\"]/div[" + i + "]"));
            int dateSize = element.findElements(By.tagName("li")).size();
            for (int j = 1; j <= dateSize; j++) {
                WebElement day = webDriver.findElement(By.xpath("//*[@id=\"slider\"]/div[" + i + "]/ul/li[" + j + "]")); // 날짜 클릭
                day.click();
            }
            webDriver.findElement(By.xpath("//*[@id=\"slider\"]/button[2]")).click(); // 다음날짜보기
        }
    }
}
