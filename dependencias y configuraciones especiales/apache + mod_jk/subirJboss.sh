#!/bin/bash

echo "subirJboss.sh"

posicion="$PWD"

if [ "$instancia" == "" ]; then
	instancia="$1"
fi
if [ "$instancia" == "" ]; then
	instancia="1"
fi
if [ "$ipInstancia1" == "" ]; then
	ipInstancia1="$2"
fi
if [ "$ipInstancia2" == "" ]; then
	ipInstancia2="$3"
fi
if [ "$ipInstancia3" == "" ]; then
	ipInstancia3="$4"
fi
if [ "$multicast" == "" ]; then
	multicast="$5"
fi
if [ "$ipMulticast" == "" ]; then
	ipMulticast="$6"
fi
if [ "$ipInstancia1" == "" ]; then
	ipInstancia1="worker1"
fi
if [ "$ipInstancia2" == "" ]; then
	ipInstancia2="worker2"
fi
if [ "$ipInstancia3" == "" ]; then
	ipInstancia3="worker3"
fi
if [ "$multicast" == "" ]; then
	multicast="0"
fi
if [ "$ipMulticast" == "" ]; then
	ipMulticast="239.1.2.3"
fi
if [ "$multicast" == "1" ]; then
	multicast=" -u $ipMulticast "
else
	multicast=""
fi

function subirJboss() {
#	echo "/opt/jboss-6.1.0.Final.2/bin/run.sh -c all -g qin $multicast -b "$ipInstancia2" -Djboss.messaging.ServerPeerID=2 -Djboss.service.binding.set=ports-01 => 8109 &"
#	/opt/jboss-6.1.0.Final.2/bin/run.sh -c all -g qin $multicast -b "$ipInstancia1" -Djboss.messaging.ServerPeerID=2 -Djboss.service.binding.set=ports-01 &
#	sleep 60
	if [ "$instancia" == "1" ]; then
		echo "/opt/jboss-6.1.0.Final/bin/run.sh -c all -g qin $multicast -b "$ipInstancia1" -Djboss.messaging.ServerPeerID=1 -Djboss.service.binding.set=ports-default => 8009 &"
		/opt/jboss-6.1.0.Final/bin/run.sh -c all -g qin $multicast -b "$ipInstancia1" -Djboss.messaging.ServerPeerID=1 -Djboss.service.binding.set=ports-default &
		sleep 30
	fi
	if [ "$instancia" == "2" ]; then
		echo "/opt/jboss-6.1.0.Final.2/bin/run.sh -c all -g qin $multicast -b "$ipInstancia2" -Djboss.messaging.ServerPeerID=2 -Djboss.service.binding.set=ports-01 => 8109 &"
		/opt/jboss-6.1.0.Final.2/bin/run.sh -c all -g qin $multicast -b "$ipInstancia2" -Djboss.messaging.ServerPeerID=2 -Djboss.service.binding.set=ports-01 &
		sleep 30
	fi
	if [ "$instancia" == "3" ]; then
		echo "/opt/jboss-6.1.0.Final.3/bin/run.sh -c all -g qin $multicast -b "$ipInstancia3" -Djboss.messaging.ServerPeerID=3 -Djboss.service.binding.set=ports-02 => 8209 &"
		/opt/jboss-6.1.0.Final.3/bin/run.sh -c all -g qin $multicast -b "$ipInstancia3" -Djboss.messaging.ServerPeerID=3 -Djboss.service.binding.set=ports-02 &
		sleep 30
	fi
}
subirJboss
