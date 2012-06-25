#!/bin/bash

ip="$1"

function instalarDependencias() {
	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get dist-upgrade
	sudo apt-get install configure automake gcc make apache2 \
		apache2-mpm-worker apache2-utils apache2.2-bin apache2.2-common \
		libapr1-dev libaprutil1-dev libaprutil1-dbd-sqlite3 libaprutil1-ldap \
		libapache2-mod-jk
	sudo apt-get update
	sudo apt-get upgrade
	sudo apt-get dist-upgrade
}

function crearServidorVirtual() {
	cp -f /etc/apache2/httpd.conf /etc/apache2/httpd.conf.anterior
	echo "ServerName $ip
<VirtualHost *:80>
	ServerName $ip
	# Send servlet for context / jsp-examples to worker named domain1
	JkMount / loadbalancer
	# Send JSPs for context /jsp-examples/* to worker named domain1
	JkMount /* loadbalancer
</VirtualHost>
# Include conf/mod_jk.conf" > /etc/apache2/httpd.conf.nuevo
	mv -f /etc/apache2/httpd.conf.nuevo /etc/apache2/httpd.conf
}

# instalarDependencias

crearServidorVirtual


