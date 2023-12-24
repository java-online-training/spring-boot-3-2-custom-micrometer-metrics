package com.jot.custommicrometermetrics.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Component
public class MyBean {

    private final List<String> strings;

    public MyBean(MeterRegistry registry) {
        this.strings = List.of("one", "two", "three");
        registry.gauge("dictionary.size", Tags.empty(), this.strings.size());
    }

}