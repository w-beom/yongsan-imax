package com.youngsanimax.controller;

import com.youngsanimax.domain.browser.Browser;
import com.youngsanimax.service.CGVCrawlerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final CGVCrawlerService cgvCrawlerService;

    public MainController(CGVCrawlerService cgvCrawlerService) {
        this.cgvCrawlerService = cgvCrawlerService;
    }

    @GetMapping("/main")
    public String index() {
        return "index.html";
    }

    @GetMapping("/crawler")
    public void crawl(@RequestParam Browser browser) {
        cgvCrawlerService.crawling(browser);
    }
}
