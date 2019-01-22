package com.vattenfall.mock;

import com.gengroup.schemas.providetimeseriesdata._1.ProvideTimeSeriesData;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public CxfEndpoint mockEndpoint() {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("/mock");
        cxfEndpoint.setAllowStreaming(true);
        cxfEndpoint.setServiceClass(ProvideTimeSeriesData.class);
        cxfEndpoint.setBus(bus);
        return cxfEndpoint;

    }

    @Bean
    public CxfEndpoint dummyEndpoint() {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("/dummy");
        cxfEndpoint.setServiceClass(ProvideTimeSeriesData.class);
        cxfEndpoint.setBus(bus);
        return cxfEndpoint;

    }
}
