package com.vattenfall.gasnltimeseries;


import com.gengroup.schemas.providetimeseriesdata._1_0.ProvideTimeSeriesData;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    /*consumer and producer. For a pass-through service end point url can be overwitten in camel route*/
    @Bean
    public CxfEndpoint nlTimeSeries() {
        // interceptor to accept gzip response
        GZIPInInterceptor gZIPInInterceptor = new GZIPInInterceptor();
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("/nlTimeSeries");
        cxfEndpoint.setServiceClass(ProvideTimeSeriesData.class);
        cxfEndpoint.setBus(bus);
        cxfEndpoint.getInInterceptors().add(gZIPInInterceptor);
        cxfEndpoint.setAllowStreaming(true);
        return cxfEndpoint;
    }
}
