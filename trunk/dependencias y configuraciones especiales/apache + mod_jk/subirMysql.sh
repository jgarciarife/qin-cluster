#!/bin/bash

echo "subirMysql.sh"

posicion="$PWD"

if [ "$esGNewSense" == "" ]; then
	esGNewSense="$1"
fi
if [ "$esGNewSense" == "" ]; then
	source "$posicion"/detectarSO.sh
fi

source "$posicion"/detectarIpConexion.sh
ipBaseDeDatos=`cat /etc/hosts | grep basededatos | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*).*/\1/gi'`

if [ "$ip" == "$ipBaseDeDatos" ]; then
	if [ "$esGNewSense" == "1" ]; then
		echo "sudo /etc/init.d/mysql restart"
		sudo /etc/init.d/mysql restart
	else
		echo "sudo service mysql restart"
		sudo service mysql restart
	fi
fi
