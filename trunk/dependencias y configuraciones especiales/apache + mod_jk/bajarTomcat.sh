#!/bin/bash

echo "bajarTomcat.sh"

posicion="$PWD"

function bajarInstanciaTomcat() {
	if [ "$instancia" == "1" ]; then
		echo "/opt/apache-tomcat-7.0.23/bin/shutdown.sh & 2> /dev/null"
		/opt/apache-tomcat-7.0.23/bin/shutdown.sh & 2> /dev/null
	fi
	if [ "$instancia" == "2" ]; then
		echo "/opt/apache-tomcat-7.0.23.2/bin/shutdown.sh & 2> /dev/null"
		/opt/apache-tomcat-7.0.23.2/bin/shutdown.sh & 2> /dev/null
	fi
	if [ "$instancia" == "3" ]; then
		echo "/opt/apache-tomcat-7.0.23.3/bin/shutdown.sh & 2> /dev/null"
		/opt/apache-tomcat-7.0.23.3/bin/shutdown.sh & 2> /dev/null
	fi
}

bajarInstanciaTomcat
