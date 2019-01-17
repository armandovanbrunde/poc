package com.vattenfall.gasnltimeseries;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder {


    public void configure() throws Exception {
        from("cxf:bean:nlTimeSeries?dataFormat=PAYLOAD")
                // dynamically Overwrite endpoint URL. Valid for JAX-WS and JAX-RS
                //.setHeader("CamelDestinationOverrideUrl",constant("http://localhost:8080/services/mock"))
                .setHeader("CamelDestinationOverrideUrl").method("dynamicConfig","getEndpoint")
                .setHeader("GasNLUsername").method("dynamicConfig","getUsername")
                .setHeader("GasNLPassword").method("dynamicConfig","getPassword")
                .log("username : ${header.GasNLUsername} , password : ${header.GasNLPassword}")
                .recipientList(simple("cxf:bean:nlTimeSeries?dataFormat=PAYLOAD&username=${header.GasNLUsername}&password=${header.GasNLPassword}"))
        ;
    }
}
