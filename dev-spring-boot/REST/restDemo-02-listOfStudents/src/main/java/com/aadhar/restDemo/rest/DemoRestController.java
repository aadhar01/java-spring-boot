package com.aadhar.restDemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    //add code for Rest Hello endpoint
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
