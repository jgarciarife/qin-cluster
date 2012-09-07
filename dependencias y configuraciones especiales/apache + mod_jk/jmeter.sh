#!/bin/bash

echo "jmeter.sh"

posicion="$PWD"

sudo "$posicion"/configurarProcesador.sh

source "$posicion"/detectarSO.sh

source "$posicion"/detectarIpConexion.sh
ipBaseDeDatos=`cat /etc/hosts | grep basededatos | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*).*/\1/gi'`
ipApache=`cat /etc/hosts | grep apache | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*).*/\1/gi'`
ipTerracotta=`cat /etc/hosts | grep terracotta | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*).*/\1/gi'`
ipWorker1=`cat /etc/hosts | grep worker1 | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*).*/\1/gi'`
ipWorker2=`cat /etc/hosts | grep worker2 | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*).*/\1/gi'`
ipWorker3=`cat /etc/hosts | grep worker3 | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*).*/\1/gi'`

if [ "$ip" != "$ipBaseDeDatos" ]; then
	if [ "$esGNewSense" == "1" ]; then
		echo "sudo /etc/init.d/mysql stop"
		sudo /etc/init.d/mysql stop
	else
		echo "sudo service mysql stop"
		sudo service mysql stop
	fi
fi
if [ "$ip" != "$ipApache" ]; then
	source "$posicion"/bajarApacheCompleto.sh
fi
if [ "$ip" != "$ipTerracotta" ]; then
	source "$posicion"/bajarTerracotta.sh
fi
if [ "$ip" != "$ipWorker1" ] && [ "$ip" != "$ipWorker2" ] && [ "$ip" != "$ipWorker3" ]; then
	source "$posicion"/bajarJboss.sh
	source "$posicion"/bajarTomcat.sh
fi

/opt/apache-jmeter-2.7/bin/jmeter

exit 0
