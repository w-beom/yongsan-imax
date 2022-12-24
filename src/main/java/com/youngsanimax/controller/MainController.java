package com.youngsanimax.controller;

import com.youngsanimax.domain.Message;
import com.youngsanimax.domain.TelegramBot;
import com.youngsanimax.service.CGVCrawlerService;
import com.youngsanimax.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private CGVCrawlerService cgvCrawlerService;

    @Autowired
    private TelegramBot telegramBot;

    @GetMapping("/main")
    public String index() {
        return "index.html";
    }

    @PostMapping("/crawler")
    public void crawl() {
        telegramBot.sendMessage(new Message("5267186305", "서비스를 시작합니다."));

        cgvCrawlerService.crawling();
    }
}
