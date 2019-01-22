package com.vattenfall.mock;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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
public class ResponseProcessor implements Processor {

    @Autowired
    DynamicConfig dynamicConfig;

    @Override
    public void process(Exchange exchange) throws Exception {



        //String target = exchange.getIn().getHeader("target").toString();
        String user = exchange.getIn().getHeader("user").toString();
        String message = exchange.getIn().getHeader("message").toString();


        List<Element> outElements = new ArrayList<Element>();
        XmlConverter converter = new XmlConverter();
        /*String docString = "<ns:ProvideTimeSeriesDataResponse xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://schemas.gengroup.com/ProvideTimeSeriesData/1.0\">\n" +
                "         <ns:Header>\n" +
                "            <ns:MessageID>from mock</ns:MessageID>\n" +
                "            <ns:DateTime>2013-11-23T15:44:07</ns:DateTime>\n" +
                "            <!--Optional:-->\n" +
                "            <ns:CorrelationID>ventos tempestatesque</ns:CorrelationID>\n" +
                "            <!--Optional:-->\n" +
                "            <ns:Retry>false</ns:Retry>\n" +
                "            <!--Optional:-->\n" +
                "            <ns:SourceID>per auras</ns:SourceID>\n" +
                "            <!--Optional:-->\n" +
                "            <ns:TransactionID>circum claustra</ns:TransactionID>\n" +
                "            <!--Optional:-->\n" +
                "            <ns:Sender>nimborum in</ns:Sender>\n" +
                "            <!--Optional:-->\n" +
                "            <ns:Receiver>" + target + "</ns:Receiver>\n" +
                "         </ns:Header>\n" +
                "         <!--Optional:-->\n" +
                "         <ns:Error>\n" +
                "            <ns:Origin>profundum quippe ferant</ns:Origin>\n" +
                "            <ns:Code>et carcere</ns:Code>\n" +
                "            <ns:Description>iovis rapidum iaculata</ns:Description>\n" +
                "         </ns:Error>\n" +
                "         <!--Optional:-->\n" +
                "         <ns:Response>\n" +
                "            <ns:TimeLines>\n" +
                "               <!--1 or more repetitions:-->\n" +
                "               <ns:TimeLine>\n" +
                "                  <ns:Meter>\n" +
                "                     <ns:MeterID>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Code>" + dynamicConfig.getMockPassword() + "</ns:Code>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:EanCode>bella gero et</ns:EanCode>\n" +
                "                     </ns:MeterID>\n" +
                "                     <ns:MeterProperties>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Name>" + user + "</ns:Name>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Product>" + message + "</ns:Product>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Unit>ac vinclis</ns:Unit>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Versions>100</ns:Versions>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Decimals>100</ns:Decimals>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Scheme>speluncis abdidit</ns:Scheme>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Administration>aris imponet honorem</ns:Administration>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Segment>praeterea aut</ns:Segment>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:SubSegment>claustra fremunt</ns:SubSegment>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:MinInterval>200</ns:MinInterval>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Code1>imperio premit</ns:Code1>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Code2>quisquam numen</ns:Code2>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Code3>ac vinclis</ns:Code3>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Code4>ac vinclis</ns:Code4>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Code5>pectore flammas</ns:Code5>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:Code6>pectore flammas</ns:Code6>\n" +
                "                        <!--Optional:-->\n" +
                "                        <ns:MeterType>100</ns:MeterType>\n" +
                "                     </ns:MeterProperties>\n" +
                "                  </ns:Meter>\n" +
                "                  <ns:TimeLineAttributes>\n" +
                "                     <ns:PeriodStart>2015-10-10T12:07:56+02:00</ns:PeriodStart>\n" +
                "                     <ns:PeriodEnd>2018-07-19T10:02:25+02:00</ns:PeriodEnd>\n" +
                "                     <ns:DSTMethod>100</ns:DSTMethod>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:Interval>volutans nimborum in</ns:Interval>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:DateTimeMethod>100</ns:DateTimeMethod>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:Version>100</ns:Version>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:Type>100</ns:Type>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:StatusBit>100</ns:StatusBit>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:Unit>faciat maria</ns:Unit>\n" +
                "                  </ns:TimeLineAttributes>\n" +
                "                  <ns:TimeLineData>\n" +
                "                     <ns:TimeLineValue>et quisquam</ns:TimeLineValue>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:TimeLineTimeStamp>et soror</ns:TimeLineTimeStamp>\n" +
                "                     <!--Optional:-->\n" +
                "                     <ns:TimeLineState>annos bella gero</ns:TimeLineState>\n" +
                "                  </ns:TimeLineData>\n" +
                "               </ns:TimeLine>\n" +
                "            </ns:TimeLines>\n" +
                "         </ns:Response>\n" +
                "      </ns:ProvideTimeSeriesDataResponse>";*/

        String docString = "<ns:ProvideTimeSeriesDataResponse xmlns:ns=\"http://schemas.gengroup.com/ProvideTimeSeriesData/1.0\">\n" +
                "         <ns:Header>\n" +
                "            <ns:MessageID>" + message + "</ns:MessageID>\n" +
                "            <ns:DateTime>2013-11-23T15:44:07</ns:DateTime>\n" +
                "         </ns:Header>\n" +
                "      </ns:ProvideTimeSeriesDataResponse>";

        Element node =  DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new ByteArrayInputStream(docString.getBytes()))
                .getDocumentElement();

        Document outDocument = converter.toDOMDocument(node);
        outElements.add(outDocument.getDocumentElement());
        CxfPayload<SoapHeader> responsePayload =
                new CxfPayload<SoapHeader>(null, outElements);
        exchange.getOut().setBody(responsePayload);
    }
}
