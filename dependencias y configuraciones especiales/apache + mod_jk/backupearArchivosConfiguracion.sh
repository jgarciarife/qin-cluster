#!/bin/bash

echo "backupearArchivosConfiguracion.sh"

posicion="$PWD"

source "$posicion"/manejarPermisos.sh

if [ ! -f "/etc/apache2/apache2.conf.anterior" ]; then
	sudo cp -f /etc/apache2/apache2.conf /etc/apache2/apache2.conf.anterior
fi
if [ ! -f "/etc/apache2/httpd.conf.anterior" ]; then
	sudo cp -f /etc/apache2/httpd.conf /etc/apache2/httpd.conf.anterior
fi
if [ ! -f "/etc/libapache2-mod-jk/workers.properties.anterior" ]; then
	sudo cp -f /etc/libapache2-mod-jk/workers.properties /etc/libapache2-mod-jk/workers.properties.anterior
fi
if [ ! -f "/etc/apache2/conf/uriworkermap.properties.anterior" ]; then
	if [ -f "/etc/apache2/conf/uriworkermap.properties" ]; then
		sudo cp -f /etc/apache2/conf/uriworkermap.properties /etc/apache2/conf/uriworkermap.properties.anterior
	fi
fi
if [ ! -f "/etc/apache2/mods-available/jk.conf.anterior" ]; then
	sudo cp -f /etc/apache2/mods-available/jk.conf /etc/apache2/mods-available/jk.conf.anterior
fi
if [ ! -f "/etc/apache2/mods-available/jk.load.anterior" ]; then
	sudo cp -f /etc/apache2/mods-available/jk.load /etc/apache2/mods-available/jk.load.anterior
fi
if [ ! -f "/etc/apache2/sites-available/default.anterior" ]; then
	sudo cp -f /etc/apache2/sites-available/default /etc/apache2/sites-available/default.anterior
fi
if [ ! -f "/etc/apache2/mods-available/status.conf.anterior" ]; then
	sudo cp -f /etc/apache2/mods-available/status.conf /etc/apache2/mods-available/status.conf.anterior
fi
if [ ! -f "/etc/apache2/mods-available/proxy_balancer.conf.anterior" ]; then
	sudo cp -f /etc/apache2/mods-available/proxy_balancer.conf /etc/apache2/mods-available/proxy_balancer.conf.anterior
fi
source "$posicion"/manejarPermisos.sh
