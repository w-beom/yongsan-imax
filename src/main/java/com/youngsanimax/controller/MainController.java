package com.youngsanimax.controller;

import com.youngsanimax.domain.browser.Browser;
import com.youngsanimax.service.CGVCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private CGVCrawlerService cgvCrawlerService;

    @GetMapping("/main")
    public String index() {
        return "index.html";
    }

    @GetMapping("/crawler")
    public void crawl(@RequestParam Browser browser) {
        cgvCrawlerService.crawling(browser);
    }
}
