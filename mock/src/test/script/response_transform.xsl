<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:template match="/">
        <message>
            <xsl:value-of select="/soap:Envelope/soap:Body/*[namespace-uri()='http://schemas.gengroup.com/ProvideTimeSeriesData/1.0' and local-name()='ProvideTimeSeriesDataResponse']/*[namespace-uri()='http://schemas.gengroup.com/ProvideTimeSeriesData/1.0' and local-name()='Response']/*[namespace-uri()='http://schemas.gengroup.com/ProvideTimeSeriesData/1.0' and local-name()='TimeLines']/*[namespace-uri()='http://schemas.gengroup.com/ProvideTimeSeriesData/1.0' and local-name()='TimeLine']/*[namespace-uri()='http://schemas.gengroup.com/ProvideTimeSeriesData/1.0' and local-name()='Meter']/*[namespace-uri()='http://schemas.gengroup.com/ProvideTimeSeriesData/1.0' and local-name()='MeterProperties']/*[namespace-uri()='http://schemas.gengroup.com/ProvideTimeSeriesData/1.0' and local-name()='Product']"/>
        </message>
    </xsl:template>
</xsl:stylesheet>