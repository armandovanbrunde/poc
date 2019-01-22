package com.vattenfall.mock;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfPayload;
import org.apache.camel.converter.jaxp.XmlConverter;
import org.apache.cxf.binding.soap.SoapHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {



        /*from("timer://tick?period=5000")
                .setHeader("dynamicPassword").method("dynamicConfig","getMockPassword")
                .log("body is : ${header.dynamicPassword}")
                ;*/
        this.getContext().setStreamCaching(true);

        from("cxf:bean:mockEndpoint?dataFormat=PAYLOAD")
                .log("logging ${body}")
                .setHeader("user").method("dynamicConfig","getMockUser")
                .setHeader("message",simple("{{mockMessage}}"))
                //.setHeader("target",xpath("//ns:Receiver/text()",String.class).namespace("ns","http://schemas.gengroup.com/ProvideTimeSeriesData/1.0"))
                .process("responseProcessor")
                .log("logging response ${body}")

        ;

        from("cxf:bean:dummyEndpoint?dataFormat=PAYLOAD")
                .log("logging ${body}")
                .setHeader("user").method("dynamicConfig","getMockUser")
                .setHeader("message",simple("{{dummyMessage}}"))
                //.setHeader("target",xpath("//ns:Receiver/text()",String.class).namespace("ns","http://schemas.gengroup.com/ProvideTimeSeriesData/1.0"))
                .process("responseProcessor")

        ;




    }
}
