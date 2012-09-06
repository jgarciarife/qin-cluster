#!/bin/bash

echo "subirTomcat.sh"

posicion="$PWD"

if [ "$instancia" == "" ]; then
	instancia="$1"
fi
if [ "$instancia" == "" ]; then
	instancia="1"
fi

function subirTomcat() {
	if [ "$instancia" == "1" ]; then
		echo "/opt/apache-tomcat-7.0.23/bin/startup.sh &"
		/opt/apache-tomcat-7.0.23/bin/startup.sh &
		sleep 30
	fi
	if [ "$instancia" == "2" ]; then
		echo "/opt/apache-tomcat-7.0.23.2/bin/startup.sh &"
		/opt/apache-tomcat-7.0.23.2/bin/startup.sh &
		sleep 30
	fi
	if [ "$instancia" == "3" ]; then
		echo "/opt/apache-tomcat-7.0.23.3/bin/startup.sh &"
		/opt/apache-tomcat-7.0.23.3/bin/startup.sh &
		sleep 30
	fi
}
subirTomcat
