package com.youngsanimax.domain;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public interface Browser {
    WebDriver getWebDriver();
}
