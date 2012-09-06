#!/bin/bash

echo "bajarTomcat.sh"

posicion="$PWD"

function bajarInstanciaTomcat() {
	echo "/opt/apache-tomcat-7.0.23/bin/shutdown.sh & 2> /dev/null"
	/opt/apache-tomcat-7.0.23/bin/shutdown.sh & 2> /dev/null
	echo "/opt/apache-tomcat-7.0.23.2/bin/shutdown.sh & 2> /dev/null"
	/opt/apache-tomcat-7.0.23.2/bin/shutdown.sh & 2> /dev/null
	echo "/opt/apache-tomcat-7.0.23.3/bin/shutdown.sh & 2> /dev/null"
	/opt/apache-tomcat-7.0.23.3/bin/shutdown.sh & 2> /dev/null
}

bajarInstanciaTomcat
