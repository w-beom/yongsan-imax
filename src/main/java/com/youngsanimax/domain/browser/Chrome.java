package com.youngsanimax.domain.browser;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Chrome implements Browser {
    private static final String DRIVER_PATH = "/";
    private WebDriver chromeDriver;

    private Chrome() {
    }

    @Override
    public void createWebDriver() {
        String property = System.getProperty("user.home");
        log.info(property);
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        chromeDriver = new ChromeDriver(options);
    }

    @Override
    public WebDriver openUrl(String url) {
        chromeDriver.get(url);
        return chromeDriver;
    }
}
