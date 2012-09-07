#!/bin/bash

echo "subirApache.sh"

posicion="$PWD"

#if [ "$esGNewSense" == "" ]; then
#	esGNewSense="$1"
#fi
#if [ "$esGNewSense" == "" ]; then
#	source "$posicion"/detectarSO.sh
#fi
sudo "$posicion"/configurarProcesador.sh
echo "sudo /usr/sbin/apache2ctl start"
sudo /usr/sbin/apache2ctl start
#if [ "$esGNewSense" == "1" ]; then
#	echo "sudo /etc/init.d/apache2 start"
#	sudo /etc/init.d/apache2 start
#else
#	echo "sudo service apache2 start"
#	sudo /usr/sbin/apache2ctl start
#	sudo service apache2 start
#fi
