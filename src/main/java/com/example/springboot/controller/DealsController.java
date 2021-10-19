package com.example.springboot.controller;

import com.example.springboot.Service.IDealsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class DealsController {

    @Autowired
    IDealsService dealsService;

    @RequestMapping(value = "/deals/create", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String createDeal(@RequestParam("maxCount") String maxCount, @RequestParam("price") String price) {
        log.info("Received request for {} {}", maxCount, price);
        dealsService.createADeal(new Double(price), Integer.valueOf(maxCount));
        return "Deal Created!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String testSpring() {
        return "hello world!";
    }
}