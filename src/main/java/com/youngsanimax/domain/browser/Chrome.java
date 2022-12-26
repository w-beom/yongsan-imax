package com.youngsanimax.domain.browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component
public class Chrome implements Browser {
    private static final String DRIVER_PATH = "src/main/resources/drivers/chrome/chromedriver.exe";
    private WebDriver chromeDriver;

    private Chrome() {
    }

    @Override
    public void createWebDriver() {
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
