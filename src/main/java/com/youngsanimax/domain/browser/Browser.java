package com.youngsanimax.domain.browser;

import org.openqa.selenium.WebDriver;

public interface Browser {
    void createWebDriver();

    WebDriver openUrl(String url);
}
