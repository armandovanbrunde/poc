package com.vattenfall.gasnltimeseries;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NlgasTimeseriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NlgasTimeseriesApplication.class, args);
    }

}

