package com.youngsanimax.service;

import com.youngsanimax.domain.browser.Browser;

public interface CrawlerService {
    void crawling(Browser browser) throws InterruptedException;
}
