#!/bin/bash

echo "bajarJboss.sh"

posicion="$PWD"

if [ "$instancia" == "" ]; then
	instancia="$1"
fi
if [ "$ip" == "" ]; then
	ip="$2"
fi

if [ "$instancia" == "" ]; then
	instancia="1"
fi
if [ "$ip" == "" ]; then
	source "$posicion"/detectarIpConexion.sh
fi

function bajarInstancia() {
	if [ "$instancia" == "1" ]; then
		echo "/opt/jboss-6.1.0.Final/bin/shutdown.sh -o $ip -r 1090 & 2> /dev/null"
		/opt/jboss-6.1.0.Final/bin/shutdown.sh -o $ip -r 1090 & 2> /dev/null
	fi
	if [ "$instancia" == "2" ]; then
		echo "/opt/jboss-6.1.0.Final.2/bin/shutdown.sh -o $ip -r 1190 & 2> /dev/null"
		/opt/jboss-6.1.0.Final.2/bin/shutdown.sh -o $ip -r 1190 & 2> /dev/null
	fi
	if [ "$instancia" == "3" ]; then
		echo "/opt/jboss-6.1.0.Final.3/bin/shutdown.sh -o $ip -r 1290 & 2> /dev/null"
		/opt/jboss-6.1.0.Final.3/bin/shutdown.sh -o $ip -r 1290 & 2> /dev/null
	fi
}

bajarInstancia
