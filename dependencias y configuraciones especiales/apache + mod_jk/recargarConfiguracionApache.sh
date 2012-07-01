#!/bin/bash

echo "recargarConfiguracionApache.sh"

posicion="$PWD"

if [ "$esGNewSense" == "" ]; then
	esGNewSense="$1"
fi
if [ "$esGNewSense" == "" ]; then
	source "$posicion"/detectarSO.sh
fi

if [ "$esGNewSense" == "1" ]; then
	echo "sudo /etc/init.d/apache2 stop && sudo /etc/init.d/apache2 reload"
	sudo /etc/init.d/apache2 stop && sudo /etc/init.d/apache2 reload
else
	echo "sudo service apache2 stop && sudo service apache2 reload"
	sudo service apache2 stop && sudo service apache2 reload
fi
echo "sudo /usr/sbin/apache2ctl configtest"
sudo /usr/sbin/apache2ctl configtest
