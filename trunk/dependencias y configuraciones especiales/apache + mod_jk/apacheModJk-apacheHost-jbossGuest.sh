#!/bin/bash

# Estructura de invocación

# apacheModJk-apacheHost-jbossGuest.sh
# apacheModJk-apacheHost-jbossGuest.sh reset

"$HOME"/workspace/qin-cluster/dependencias\ y\ configuraciones\ especiales/apache\ +\ mod_jk/cancelarApacheModJk-apacheHost-jbossGuest.sh

carmelo=`cat /etc/hosts | grep '[0-9]*\.[0-9]*\.[0-9]*\.[0-9]*\scarmelo' | sed -r 's/([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*)\scarmelo/\1/gi'`

echo " "
echo "apacheModJk-apacheHost-jbossGuest.sh"

reset="$1"

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
project="qinweb"
echo "$project"
user="root"
pass="diego"

esGNewSense=`cat /etc/*-release | grep 'gNewSense'`
if [ "$esGNewSense" != "" ]; then
	echo "gNewSense"
	esGNewSense="1"
fi
echo " "

function instalarDependencias() {
	echo "instalarDependencias"
	sudo chmod 777 -R /etc/apache2
	sudo chmod 777 -R /etc/libapache2-mod-jk
}

function configurarServidorVirtual() {
	echo "configurarServidorVirtual"
	if [ ! -f "/etc/apache2/httpd.conf /etc/apache2/httpd.conf.anterior" ]; then
		sudo cp -f /etc/apache2/httpd.conf /etc/apache2/httpd.conf.anterior
		sudo chmod 777 -R /etc/apache2
		sudo chmod 777 -R /etc/libapache2-mod-jk
		if [ "$esGNewSense" == "1" ]; then
			echo "ServerName $ip
LoadModule jk_module /usr/lib/apache2/modules/mod_jk.so
JkWorkersFile /etc/libapache2-mod-jk/workers.properties
JkLogFile logs/mod_jk.log
JkLogLevel debug
JkLogStampFormat \"[%a %b %d %H:%M:%S %Y]\"
JkOptions +ForwardKeySize +ForwardURICompatUnparsed -ForwardDirectories
JkRequestLogFormat \"%w %V %T\"
JkMount /$project/* loadbalancer
JkUnMount /$project/images/* loadbalancer
JkMountFile conf/uriworkermap.properties
JkShmFile run/jk.shm
<Location /jkstatus>
	JkMount status
	Order deny,allow
	Deny from all
	Allow from $ip
</Location>" > /etc/apache2/httpd.conf.nuevo
		else
			echo "ServerName $ip" > /etc/apache2/httpd.conf.nuevo
		fi
		sudo mv -f /etc/apache2/httpd.conf.nuevo /etc/apache2/httpd.conf
	fi
}

function configurarWorkers() {
	echo "configurarWorkers"
	if [ ! -f "/etc/libapache2-mod-jk/workers.properties.anterior" ]; then
		sudo cp -f /etc/libapache2-mod-jk/workers.properties /etc/libapache2-mod-jk/workers.properties.anterior
		if [ "$esGNewSense" == "1" ]; then
			sudo chmod 777 -R /etc/apache2
			sudo chmod 777 -R /etc/libapache2-mod-jk
			echo "worker.list=loadbalancer,status
worker.worker1.port=8009
worker.worker1.host=$carmelo
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=8109
worker.worker2.host=$carmelo
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker2.ping_mode=A #As of mod_jk 1.2.27
worker.worker3.port=8209
worker.worker3.host=$carmelo
worker.worker3.type=ajp13
worker.worker3.lbfactor=1
worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
worker.loadbalancer.balance_workers=worker1,worker2,worker3
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
		else
			sudo chmod 777 -R /etc/apache2
			sudo chmod 777 -R /etc/libapache2-mod-jk
			echo "worker.list=loadbalancer,status
worker.worker1.port=8009
worker.worker1.host=$carmelo
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=8109
worker.worker2.host=$carmelo
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker2.ping_mode=A #As of mod_jk 1.2.27
worker.worker3.port=8209
worker.worker3.host=$carmelo
worker.worker3.type=ajp13
worker.worker3.lbfactor=1
worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
worker.loadbalancer.balance_workers=worker1,worker2,worker3
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
		fi
		sudo mv -f /etc/libapache2-mod-jk/workers.properties.nuevo /etc/libapache2-mod-jk/workers.properties
	fi
}

function configurarUriworkermapProperties() {
	echo "configurarUriworkermapProperties"
	if [ ! -d "/etc/apache2/conf" ]; then
		sudo mkdir /etc/apache2/conf
	fi
	if [ ! -f "/etc/apache2/conf/uriworkermap.properties.anterior" ]; then
		if [ -f "/etc/apache2/conf/uriworkermap.properties" ]; then
			sudo cp -f /etc/apache2/conf/uriworkermap.properties /etc/apache2/conf/uriworkermap.properties.anterior
		fi
		sudo chmod 777 -R /etc/apache2
		sudo chmod 777 -R /etc/libapache2-mod-jk
		echo "/jmx-console=loadbalancer
/jmx-console/*=loadbalancer
/web-console=loadbalancer
/web-console/*=loadbalancer
/admin-console=loadbalancer
/admin-console/*=loadbalancer
/$project=loadbalancer
/$project/*=loadbalancer
$project=loadbalancer" > /etc/apache2/conf/uriworkermap.properties.nuevo
		sudo mv -f /etc/apache2/conf/uriworkermap.properties.nuevo /etc/apache2/conf/uriworkermap.properties
	fi
}

function configurarJk() {
	echo "configurarJk"
	if [ ! -d "/etc/apache2/logs" ]; then
		sudo mkdir /etc/apache2/logs
	fi
	if [ ! -d "/etc/apache2/run" ]; then
		sudo mkdir /etc/apache2/run
	fi
	if [ "$esGNewSense" != "1" ]; then
		if [ ! -f "/etc/apache2/mods-available/jk.conf.anterior" ]; then
			sudo cp -f /etc/apache2/mods-available/jk.conf /etc/apache2/mods-available/jk.conf.anterior
			sudo chmod 777 -R /etc/apache2
			sudo chmod 777 -R /etc/libapache2-mod-jk
			echo "JkWorkersFile /etc/libapache2-mod-jk/workers.properties
JkLogFile logs/mod_jk.log
JkLogLevel debug
JkLogStampFormat \"[%a %b %d %H:%M:%S %Y]\"
JkOptions +ForwardKeySize +ForwardURICompatUnparsed -ForwardDirectories
JkRequestLogFormat \"%w %V %T\"
JkMount /$project/* loadbalancer
JkUnMount /$project/images/* loadbalancer
JkMountFile conf/uriworkermap.properties
JkShmFile run/jk.shm
<Location /jkstatus>
	JkMount status
	Order deny,allow
	Deny from all
	Allow from $ip
</Location>" > /etc/apache2/mods-available/jk.conf.nuevo
			sudo mv -f /etc/apache2/mods-available/jk.conf.nuevo /etc/apache2/mods-available/jk.conf
		fi
	fi
}

function virtualHostName() {
	echo "virtualHostName"
	if [ "$esGNewSense" == "1" ]; then
		if [ ! -f "/etc/apache2/sites-available/default.anterior" ]; then
			sudo cp -f /etc/apache2/sites-available/default /etc/apache2/sites-available/default.anterior
			sudo chmod 777 -R /etc/apache2
			sudo chmod 777 -R /etc/libapache2-mod-jk
			echo "<VirtualHost *:80>
	ServerAdmin webmaster@localhost

	ServerName $ip
	# Send servlet for context / jsp-examples to worker named domain1
	JkMount / loadbalancer
	# Send JSPs for context /jsp-examples/* to worker named domain1
	JkMount /* loadbalancer

	DocumentRoot /var/www/
	<Directory />
		Options FollowSymLinks
		AllowOverride None
	</Directory>
	<Directory /var/www/>
		Options Indexes FollowSymLinks MultiViews
		AllowOverride None
		Order allow,deny
		allow from all
	</Directory>

	ScriptAlias /cgi-bin/ /usr/lib/cgi-bin/
	<Directory \"/usr/lib/cgi-bin\">
		AllowOverride None
		Options +ExecCGI -MultiViews +SymLinksIfOwnerMatch
		Order allow,deny
		Allow from all
	</Directory>

	ErrorLog /var/log/apache2/error.log

	# Possible values include: debug, info, notice, warn, error, crit,
	# alert, emerg.
	LogLevel warn

	CustomLog /var/log/apache2/access.log combined
	ServerSignature On

	Alias /doc/ \"/usr/share/doc/\"
	<Directory \"/usr/share/doc/\">
		Options Indexes MultiViews FollowSymLinks
		AllowOverride None
		Order deny,allow
		Deny from all
		Allow from 127.0.0.0/255.0.0.0 ::1/128
	</Directory>

</VirtualHost>" > /etc/apache2/sites-available/default.nuevo
			sudo mv -f /etc/apache2/sites-available/default.nuevo /etc/apache2/sites-available/default
		fi
	else
		if [ ! -f "/etc/apache2/sites-available/default.anterior" ]; then
			sudo cp -f /etc/apache2/sites-available/default /etc/apache2/sites-available/default.anterior
			sudo chmod 777 -R /etc/apache2
			sudo chmod 777 -R /etc/libapache2-mod-jk
			echo "<VirtualHost *:80>
	ServerAdmin webmaster@localhost

	ServerName $ip
	# Send servlet for context / jsp-examples to worker named domain1
	JkMount / loadbalancer
	# Send JSPs for context /jsp-examples/* to worker named domain1
	JkMount /* loadbalancer

	DocumentRoot /var/www
	<Directory />
		Options FollowSymLinks
		AllowOverride None
	</Directory>
	<Directory /var/www/>
		Options Indexes FollowSymLinks MultiViews
		AllowOverride None
		Order allow,deny
		allow from all
	</Directory>

	ScriptAlias /cgi-bin/ /usr/lib/cgi-bin/
	<Directory \"/usr/lib/cgi-bin\">
		AllowOverride None
		Options +ExecCGI -MultiViews +SymLinksIfOwnerMatch
		Order allow,deny
		Allow from all
	</Directory>

	ErrorLog /var/log/apache2/error.log

	# Possible values include: debug, info, notice, warn, error, crit,
	# alert, emerg.
	LogLevel warn

	CustomLog /var/log/apache2/access.log combined

	Alias /doc/ \"/usr/share/doc/\"
	<Directory \"/usr/share/doc/\">
		Options Indexes MultiViews FollowSymLinks
		AllowOverride None
		Order deny,allow
		Deny from all
		Allow from 127.0.0.0/255.0.0.0 ::1/128
</Directory>

</VirtualHost>" > /etc/apache2/sites-available/default.nuevo
			sudo mv -f /etc/apache2/sites-available/default.nuevo /etc/apache2/sites-available/default
		fi
	fi
}

instalarDependencias

configurarServidorVirtual

configurarWorkers

configurarUriworkermapProperties

configurarJk

virtualHostName

echo "Bajar apache y refrescar configuracion..."
if [ "$esGNewSense" == "1" ]; then
	sudo /etc/init.d/apache2 stop && sudo /etc/init.d/apache2 reload
else
	sudo service apache2 stop && sudo service apache2 reload
fi
sudo /usr/sbin/apache2ctl configtest
echo "Levantar apache..."
if [ "$esGNewSense" == "1" ]; then
	sudo service apache2 start
else
	sudo /etc/init.d/apache2 start
fi

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

