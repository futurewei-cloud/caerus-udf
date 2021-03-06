package org.openinfralabs.caerus.eventListenerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.openinfralabs.caerus.eventListenerService.sender.RedisSender;

@RestController
public class RedisController {

    @Autowired
    private RedisSender sender;

    @GetMapping("/redis")
    public String sendDataToRedisQueue(/*@RequestParam("redis") String input*/) {
        sender.sendDataToRedisQueue("input testing...");
        return "successfully sent";
    }
}