#!/bin/bash

# Estructura de invocación

# cancelarApacheModjk.sh

echo " "
echo "cancelarApacheModjk.sh"

sudo chmod 777 -R /etc/apache2
sudo chmod 777 -R /etc/libapache2-mod-jk

ip=`ifconfig eth2 | grep "inet dirección" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
if [ "$ip" == "" ]; then
	ip=`ifconfig eth1 | grep "inet dirección" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
if [ "$ip" == "" ]; then
	ip=`ifconfig eth0 | grep "inet dirección" | awk -F: '{print $2}' | awk '{print $1}' 2> /dev/null`
fi
echo "$ip"

esGNewSense=`cat /etc/*-release | grep 'gNewSense'`
if [ "$esGNewSense" != "" ""]; then
	echo "gNewSense"
	esGNewSense="1"
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
if [ "$esGNewSense" == "1" ]; then
	echo "Recuperar /etc/apache2/mods-available/jk.load..."
	if [ -f "/etc/apache2/mods-available/jk.load.anterior" ]; then
		sudo mv -f /etc/apache2/mods-available/jk.load.anterior /etc/apache2/mods-available/jk.load 2> /dev/null
	fi
else
	echo "Recuperar /etc/apache2/mods-available/jk.conf..."
	if [ -f "/etc/apache2/mods-available/jk.conf.anterior" ]; then
		sudo mv -f /etc/apache2/mods-available/jk.conf.anterior /etc/apache2/mods-available/jk.conf 2> /dev/null
	fi
fi
if [ "$esGNewSense" == "1" ]; then
	echo "Recuperar /etc/apache2/sites-available/default..."
	if [ -f "/etc/apache2/sites-available/default.anterior" ]; then
		sudo mv -f /etc/apache2/sites-available/default.anterior /etc/apache2/sites-available/default 2> /dev/null
	fi
fi
echo "Eliminar directorios..."
echo "Eliminar /etc/apache2/conf..."
sudo rm -R -f /etc/apache2/conf 2> /dev/null
echo "Eliminar /etc/apache2/logs..."
sudo rm -R -f /etc/apache2/logs 2> /dev/null
echo "Eliminar /etc/apache2/run..."
sudo rm -R -f /etc/apache2/run 2> /dev/null

echo "Reiniciar mysql..."
sudo /etc/init.d/mysql restart
echo "Reiniciar parar apache..."
sudo /etc/init.d/apache2 stop
echo "Recargar configuración de apache..."
sudo /etc/init.d/apache2 reload
sudo /usr/sbin/apache2ctl configtest
echo "Iniciar apache..."
sudo /etc/init.d/apache2 start

echo "Bajar JBoss 1 / Worker 1..."
/opt/jboss-6.1.0.Final/bin/shutdown.sh -o $ip -r 1090 & 2> /dev/null
echo "Bajar JBoss 2 / Worker 2..."
/opt/jboss-6.1.0.Final.2/bin/shutdown.sh -o $ip -r 1190 & 2> /dev/null
echo "Bajar JBoss 3 / Worker 3..."
/opt/jboss-6.1.0.Final.3/bin/shutdown.sh -o $ip -r 1290 & 2> /dev/null

sleep 120
echo "Ver servicios levantados"
nmap $ip

exit 0

