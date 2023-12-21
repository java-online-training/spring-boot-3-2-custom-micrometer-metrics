package com.jot.custommicrometermetrics.controller;


import org.slf4j.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.observation.annotation.Observed;


@RestController
public class GreetingsController {

    private static final Logger log = LoggerFactory.getLogger(GreetingsController.class);

    // <greeting> metric name
    // <getting-name> span  name
    // <userType=userType2> will be set as a tag for both metric & span
    @Observed(name = "user.name",
            contextualName = "getting-user-name",
            lowCardinalityKeyValues = {"userType", "userType2"})
    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam String name){
        log.info("Request received.");
        return new Greeting(String.format("Hello %s!", name) );
    }

    record Greeting(String text){}
}
