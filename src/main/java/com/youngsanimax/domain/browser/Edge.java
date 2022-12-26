package com.youngsanimax.domain.browser;

import org.openqa.selenium.WebDriver;

public class Edge implements Browser {
    private static final String DRIVER_PATH = "src/main/resources/drivers/edge/edgedriver.exe";
    private WebDriver edgeDriver;

    private Edge() {

    }

    @Override
    public void createWebDriver() {

    }

    @Override
    public WebDriver openUrl(String url) {
        return null;
    }
}
