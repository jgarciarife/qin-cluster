#!/bin/bash

echo "subirMysql.sh"

posicion="$PWD"

if [ "$esGNewSense" == "" ]; then
	esGNewSense="$1"
fi
if [ "$esGNewSense" == "" ]; then
	source "$posicion"/detectarSO.sh
fi

if [ "$esGNewSense" == "1" ]; then
	echo "sudo /etc/init.d/mysql start"
	sudo /etc/init.d/mysql start
else
	echo "sudo service mysql start"
	sudo service mysql start
fi
