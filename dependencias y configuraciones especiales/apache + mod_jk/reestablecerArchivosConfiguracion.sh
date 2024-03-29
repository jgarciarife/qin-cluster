#!/bin/bash

echo "reestablecerArchivosConfiguracion.sh"

posicion="$PWD"

source "$posicion"/manejarPermisos.sh

if [ -f "/etc/apache2/apache2.conf.anterior" ]; then
	echo "sudo mv -f /etc/apache2/apache2.conf.anterior /etc/apache2/apache2.conf 2> /dev/null"
	sudo mv -f /etc/apache2/apache2.conf.anterior /etc/apache2/apache2.conf 2> /dev/null
fi
if [ -f "/etc/apache2/httpd.conf.anterior" ]; then
	echo "sudo mv -f /etc/apache2/httpd.conf.anterior /etc/apache2/httpd.conf 2> /dev/null"
	sudo mv -f /etc/apache2/httpd.conf.anterior /etc/apache2/httpd.conf 2> /dev/null
fi
if [ -f "/etc/libapache2-mod-jk/workers.properties.anterior" ]; then
	echo "sudo mv -f /etc/libapache2-mod-jk/workers.properties.anterior /etc/libapache2-mod-jk/workers.properties 2> /dev/null"
	sudo mv -f /etc/libapache2-mod-jk/workers.properties.anterior /etc/libapache2-mod-jk/workers.properties 2> /dev/null
fi
if [ -f "/etc/apache2/mods-available/jk.load.anterior" ]; then
	echo "sudo mv -f /etc/apache2/mods-available/jk.load.anterior /etc/apache2/mods-available/jk.load 2> /dev/null"
	sudo mv -f /etc/apache2/mods-available/jk.load.anterior /etc/apache2/mods-available/jk.load 2> /dev/null
fi
if [ -f "/etc/apache2/mods-available/jk.conf.anterior" ]; then
	echo "sudo mv -f /etc/apache2/mods-available/jk.conf.anterior /etc/apache2/mods-available/jk.conf 2> /dev/null"
	sudo mv -f /etc/apache2/mods-available/jk.conf.anterior /etc/apache2/mods-available/jk.conf 2> /dev/null
fi
if [ -f "/etc/apache2/sites-available/default.anterior" ]; then
	echo "sudo mv -f /etc/apache2/sites-available/default.anterior /etc/apache2/sites-available/default 2> /dev/null"
	sudo mv -f /etc/apache2/sites-available/default.anterior /etc/apache2/sites-available/default 2> /dev/null
fi
if [ -f "/etc/apache2/mods-available/status.conf.anterior" ]; then
	echo "sudo mv -f /etc/apache2/mods-available/status.conf.anterior /etc/apache2/mods-available/status.conf 2> /dev/null"
	sudo mv -f /etc/apache2/mods-available/status.conf.anterior /etc/apache2/mods-available/status.conf 2> /dev/null
fi
if [ -f "/etc/apache2/mods-available/proxy_balancer.conf.anterior" ]; then
	echo "sudo mv -f /etc/apache2/mods-available/proxy_balancer.anterior /etc/apache2/mods-available/proxy_balancer.conf 2> /dev/null"
	sudo mv -f /etc/apache2/mods-available/proxy_balancer.conf.anterior /etc/apache2/mods-available/proxy_balancer.conf 2> /dev/null
fi
if [ ! -f "/etc/apache2/mods-enabled/jk.load" ]; then
	sudo ln -s /etc/apache2/mods-available/jk.load /etc/apache2/mods-enabled/jk.load
fi
if [ ! -f "/etc/apache2/mods-enabled/jk.conf" ]; then
	sudo ln -s /etc/apache2/mods-available/jk.conf /etc/apache2/mods-enabled/jk.conf
fi
if [ -f "/etc/apache2/mods-enabled/proxy.load" ]; then
	sudo rm /etc/apache2/mods-enabled/proxy.load
fi
if [ -f "/etc/apache2/mods-enabled/proxy.conf" ]; then
	sudo rm /etc/apache2/mods-enabled/proxy.conf
fi
if [ -f "/etc/apache2/mods-enabled/proxy_ajp.load" ]; then
	sudo rm /etc/apache2/mods-enabled/proxy_ajp.load
fi
if [ -f "/etc/apache2/mods-enabled/proxy_balancer.load" ]; then
	sudo rm /etc/apache2/mods-enabled/proxy_balancer.load
fi
if [ -f "/etc/apache2/mods-enabled/proxy_balancer.conf" ]; then
	sudo rm /etc/apache2/mods-enabled/proxy_balancer.conf
fi
echo "sudo rm -R -f /etc/apache2/conf 2> /dev/null"
sudo rm -R -f /etc/apache2/conf 2> /dev/null
echo "sudo rm -R -f /etc/apache2/logs 2> /dev/null"
sudo rm -R -f /etc/apache2/logs 2> /dev/null
echo "sudo rm -R -f /etc/apache2/run 2> /dev/null"
sudo rm -R -f /etc/apache2/run 2> /dev/null
source "$posicion"/manejarPermisos.sh
