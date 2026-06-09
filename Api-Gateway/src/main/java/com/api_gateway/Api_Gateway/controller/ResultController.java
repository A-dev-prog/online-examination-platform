package com.api_gateway.Api_Gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {

    @GetMapping("/health")
    public String health() {
        return "Result service is running";
    }
}
