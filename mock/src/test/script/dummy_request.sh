#!/bin/bash
while true
do
echo $(date)	
curl --user demo:demo --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:ProvideTimeSeriesData" --data @mock_request.xml http://104.154.50.113:8080/services/dummy
	echo "Press [CTRL+C] to stop.."
	sleep 5
done
