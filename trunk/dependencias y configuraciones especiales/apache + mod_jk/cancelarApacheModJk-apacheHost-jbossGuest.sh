#!/bin/bash

# Estructura de invocación

# cancelarApacheModJk-apacheHost-jbossGuest.sh

echo " "
echo "cancelarApacheModJk-apacheHost-jbossGuest.sh"

sudo chmod 777 -R /etc/apache2
sudo chmod 777 -R /etc/libapache2-mod-jk

ip=`ifconfig eth2 | grep "inet dirección" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
if [ "$ip" == "" ]; then
	ip=`ifconfig eth1 | grep "inet dirección" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth0 | grep "inet dirección" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth2 | grep "inet addr" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth1 | grep "inet addr" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth0 | grep "inet addr" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth2 | grep "Direc. inet" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth1 | grep "Direc. inet" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth0 | grep "Direc. inet" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
echo "$ip"

esGNewSense=`cat /etc/*-release | grep 'gNewSense'`
if [ "$esGNewSense" != "" ""]; then
	echo "gNewSense"
	esGNewSense="1"
fi

if [ "$esGNewSense" == "1" ]; then
	echo "Parar apache..."
	sudo /etc/init.d/apache2 stop
else
	echo "Parar apache..."
	sudo service apache2 stop
fi

echo "Recuperar archivos originales..."
echo "Recuperar /etc/apache2/httpd.conf..."
if [ -f "/etc/apache2/httpd.conf.anterior" ]; then
	sudo mv -f /etc/apache2/httpd.conf.anterior /etc/apache2/httpd.conf 2> /dev/null
fi
echo "Recuperar /etc/libapache2-mod-jk/workers.properties..."
if [ -f "/etc/libapache2-mod-jk/workers.properties.anterior" ]; then
	sudo mv -f /etc/libapache2-mod-jk/workers.properties.anterior /etc/libapache2-mod-jk/workers.properties 2> /dev/null
fi
echo "Recuperar /etc/apache2/mods-available/jk.load..."
if [ -f "/etc/apache2/mods-available/jk.load.anterior" ]; then
	sudo mv -f /etc/apache2/mods-available/jk.load.anterior /etc/apache2/mods-available/jk.load 2> /dev/null
fi
echo "Recuperar /etc/apache2/mods-available/jk.conf..."
if [ -f "/etc/apache2/mods-available/jk.conf.anterior" ]; then
	sudo mv -f /etc/apache2/mods-available/jk.conf.anterior /etc/apache2/mods-available/jk.conf 2> /dev/null
fi
echo "Recuperar /etc/apache2/sites-available/default..."
if [ -f "/etc/apache2/sites-available/default.anterior" ]; then
	sudo mv -f /etc/apache2/sites-available/default.anterior /etc/apache2/sites-available/default 2> /dev/null
fi
echo "Eliminar directorios..."
echo "Eliminar /etc/apache2/conf..."
sudo rm -R -f /etc/apache2/conf 2> /dev/null
echo "Eliminar /etc/apache2/logs..."
sudo rm -R -f /etc/apache2/logs 2> /dev/null
echo "Eliminar /etc/apache2/run..."
sudo rm -R -f /etc/apache2/run 2> /dev/null

if [ "$esGNewSense" == "1" ]; then
	echo "Recargar configuración de apache..."
	sudo /etc/init.d/apache2 reload
else
	echo "Recargar configuración de apache..."
	sudo service apache2 reload
fi
sudo /usr/sbin/apache2ctl configtest
if [ "$esGNewSense" == "1" ]; then
	echo "Iniciar apache..."
	sudo /etc/init.d/apache2 start
else
	echo "Iniciar apache..."
	sudo service apache2 start
fi

echo "Ver servicios levantados"
nmap $ip

echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "Proceso terminado"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"

exit 0

