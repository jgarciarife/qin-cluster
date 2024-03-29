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
	sudo "$posicion"/configurarProcesador.sh
	if [ "$instancia" == "1" ]; then
		echo "/opt/apache-tomcat-7.0.23/bin/startup.sh &"
		/opt/apache-tomcat-7.0.23/bin/startup.sh &
	fi
	if [ "$instancia" == "2" ]; then
		echo "/opt/apache-tomcat-7.0.23.2/bin/startup.sh &"
		/opt/apache-tomcat-7.0.23.2/bin/startup.sh &
	fi
	if [ "$instancia" == "3" ]; then
		echo "/opt/apache-tomcat-7.0.23.3/bin/startup.sh &"
		/opt/apache-tomcat-7.0.23.3/bin/startup.sh &
	fi
}
subirTomcat
