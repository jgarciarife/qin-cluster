#!/bin/bash

echo "subirJboss.sh"

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

function subirJboss() {
	if [ "$instancia" == "1" ]; then
		echo "/opt/jboss-6.1.0.Final/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=1 -Djboss.service.binding.set=ports-default &"
		/opt/jboss-6.1.0.Final/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=1 -Djboss.service.binding.set=ports-default &
		sleep 60
	fi
	if [ "$instancia" == "2" ]; then
		echo "/opt/jboss-6.1.0.Final.2/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=2 -Djboss.service.binding.set=ports-01 &"
		/opt/jboss-6.1.0.Final.2/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=2 -Djboss.service.binding.set=ports-01 &
		sleep 60
	fi
	if [ "$instancia" == "3" ]; then
		echo "/opt/jboss-6.1.0.Final.3/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=3 -Djboss.service.binding.set=ports-02 &"
		/opt/jboss-6.1.0.Final.3/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=3 -Djboss.service.binding.set=ports-02 &
		sleep 60
	fi
}
subirJboss
