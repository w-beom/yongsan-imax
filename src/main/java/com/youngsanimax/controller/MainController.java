package com.youngsanimax.controller;

import com.youngsanimax.domain.browser.Browser;
import com.youngsanimax.service.CGVCrawlerService;
import com.youngsanimax.service.CGVReadyCrawlerService;
import com.youngsanimax.service.MegaBoxCrawlerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final CGVReadyCrawlerService cgvReadyCrawlerService;
    private final CGVCrawlerService cgvCrawlerService;
    private final MegaBoxCrawlerService megaBoxCrawlerService;

    public MainController(CGVReadyCrawlerService cgvReadyCrawlerService, CGVCrawlerService cgvCrawlerService, MegaBoxCrawlerService megaBoxCrawlerService) {
        this.cgvReadyCrawlerService = cgvReadyCrawlerService;
        this.cgvCrawlerService = cgvCrawlerService;
        this.megaBoxCrawlerService = megaBoxCrawlerService;
    }

    @GetMapping("/main")
    public String index() {
        return "index.html";
    }

    @GetMapping("/crawler")
    public void crawl(@RequestParam Browser browser) {
        megaBoxCrawlerService.crawling(browser);
    }
}
