#!/bin/bash

echo "bajarMysql.sh"

posicion="$PWD"

if [ "$esGNewSense" == "" ]; then
	esGNewSense="$1"
fi
if [ "$esGNewSense" == "" ]; then
	source "$posicion"/detectarSO.sh
fi

if [ "$esGNewSense" == "1" ]; then
	echo "sudo /etc/init.d/mysql stop"
	sudo /etc/init.d/mysql stop
else
	echo "sudo service mysql stop"
	sudo service mysql stop
fi
