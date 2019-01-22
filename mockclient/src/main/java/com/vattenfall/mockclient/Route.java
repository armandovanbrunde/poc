package com.vattenfall.mockclient;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder {
    public void configure() throws Exception {

        this.getContext().setStreamCaching(true);



        from("timer://mock?period=5000")
                .setBody().simple("resource:classpath:mock_request.xml")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .toD("http://{{mockRootUrl}}/services/mock?authMethod=Basic&authUsername=demo&authPassword=demo")
                .setHeader("message",xpath("//ns:MessageID/text()",String.class).namespace("ns","http://schemas.gengroup.com/ProvideTimeSeriesData/1.0"))
                .log("message : ${header.message}")
                ;

        from("timer://dummy?period=5000")
                .setBody().simple("resource:classpath:mock_request.xml")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .toD("http://{{mockRootUrl}}/services/dummy?authMethod=Basic&authUsername=demo&authPassword=demo")
                .setHeader("message",xpath("//ns:MessageID/text()",String.class).namespace("ns","http://schemas.gengroup.com/ProvideTimeSeriesData/1.0"))
                .log("message : ${header.message}")
        ;




    }
}
