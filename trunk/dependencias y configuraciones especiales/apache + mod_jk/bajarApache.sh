#!/bin/bash

echo "bajarApache.sh"

posicion="$PWD"

if [ "$esGNewSense" == "" ]; then
	esGNewSense="$1"
fi
if [ "$esGNewSense" == "" ]; then
	source "$posicion"/detectarSO.sh
fi

if [ "$esGNewSense" == "1" ]; then
	echo "sudo /etc/init.d/apache2 stop"
	sudo /etc/init.d/apache2 stop
else
	echo "sudo service apache2 stop"
	sudo service apache2 stop
fi
echo "sudo /usr/sbin/apache2ctl graceful-stop"
sudo /usr/sbin/apache2ctl graceful-stop
