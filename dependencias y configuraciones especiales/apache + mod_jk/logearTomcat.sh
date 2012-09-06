#!/bin/bash

echo "logearTomcat.sh"

if [ "$instancia" == "" ]; then
	instancia="$1"
fi

if [ "$instancia" == "" ]; then
	instancia="1"
fi

if [ "$instancia" == "1" ]; then
	tail -f /opt/apache-tomcat-7.0.23/logs/catalina.out
fi
if [ "$instancia" == "2" ]; then
	tail -f /opt/apache-tomcat-7.0.23.2/logs/catalina.out
fi
if [ "$instancia" == "3" ]; then
	tail -f /opt/apache-tomcat-7.0.23.3/logs/catalina.out
fi

