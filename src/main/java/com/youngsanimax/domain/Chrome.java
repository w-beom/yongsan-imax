package com.youngsanimax.domain;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component
public class Chrome implements Browser {
    private static final String driverPath = "src/main/resources/drivers/chrome/chromedriver.exe";
    private final WebDriver chromeDriver;

    public Chrome() {
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        chromeDriver = new ChromeDriver(options);
    }

    @Override
    public WebDriver getWebDriver() {
        return chromeDriver;
    }
}
