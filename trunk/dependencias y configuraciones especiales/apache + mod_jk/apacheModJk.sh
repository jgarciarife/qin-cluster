#!/bin/bash

# Estructura de invocación

# apacheModjk.sh
# apacheModjk.sh reset

"$HOME"/workspace/qin-cluster/dependencias\ y\ configuraciones\ especiales/apache\ +\ mod_jk/cancelarApacheModJk.sh

echo " "
echo "apacheModjk.sh"

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
	sudo apt-get update > /dev/null
	sudo apt-get upgrade > /dev/null
	sudo apt-get dist-upgrade > /dev/null
	sudo dpkg --configure -a > /dev/null
	echo "automake"
	sudo apt-get install automake > /dev/null
	echo "gcc"
	sudo apt-get install gcc > /dev/null
	echo "make"
	sudo apt-get install make > /dev/null
	echo "apache2"
	sudo apt-get install apache2 > /dev/null
	echo "apache2-mpm-worker"
	sudo apt-get install apache2-mpm-worker > /dev/null
	echo "apache2-utils"
	sudo apt-get install apache2-utils > /dev/null
	echo "libapr1-dev"
	sudo apt-get install libapr1-dev > /dev/null
	echo "libaprutil1-dev"
	sudo apt-get install libaprutil1-dev > /dev/null
	echo "libapache2-mod-jk"
	sudo apt-get install libapache2-mod-jk > /dev/null
	sudo apt-get update > /dev/null
	sudo apt-get upgrade > /dev/null
	sudo apt-get dist-upgrade > /dev/null
	sudo dpkg --configure -a > /dev/null
	sudo chmod 777 -R /etc/apache2
	sudo chmod 777 -R /etc/libapache2-mod-jk
	sudo chmod 777 -R /opt/jboss-6.1.0.Final
	sudo chmod 777 -R /opt/jboss-6.1.0.Final.2
	sudo chmod 777 -R /opt/jboss-6.1.0.Final.3
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
# <VirtualHost *:80>
# 	ServerName $ip
# 	# Send servlet for context / jsp-examples to worker named domain1
# 	JkMount / loadbalancer
# 	# Send JSPs for context /jsp-examples/* to worker named domain1
# 	JkMount /* loadbalancer
# </VirtualHost>" > /etc/apache2/httpd.conf.nuevo
# Include conf/mod_jk.conf
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
worker.worker1.host=$ip
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=8109
worker.worker2.host=$ip
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker2.ping_mode=A #As of mod_jk 1.2.27
worker.worker3.port=8109
worker.worker3.host=$ip
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
worker.worker1.host=$ip
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=8109
worker.worker2.host=$ip
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker2.ping_mode=A #As of mod_jk 1.2.27
worker.worker3.port=8109
worker.worker3.host=$ip
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
	if [ "$esGNewSense" == "1" ]; then
		echo "es gNewSense"
#		if [ ! -f "/etc/apache2/mods-available/jk.load.anterior" ]; then
#			sudo cp -f /etc/apache2/mods-available/jk.load /etc/apache2/mods-available/jk.load.anterior
#			sudo chmod 777 -R /etc/apache2
#			sudo chmod 777 -R /etc/libapache2-mod-jk
#			echo "LoadModule jk_module /usr/lib/apache2/modules/mod_jk.so
#JkWorkersFile /etc/libapache2-mod-jk/workers.properties
#JkLogFile logs/mod_jk.log
#JkLogLevel debug
#JkLogStampFormat \"[%a %b %d %H:%M:%S %Y]\"
#JkOptions +ForwardKeySize +ForwardURICompatUnparsed -ForwardDirectories
#JkRequestLogFormat \"%w %V %T\"
#JkMount /$project/* loadbalancer
#JkUnMount /$project/images/* loadbalancer
#JkMountFile conf/uriworkermap.properties
#JkShmFile run/jk.shm
#<Location /jkstatus>
#	JkMount status
#	Order deny,allow
#	Deny from all
#	Allow from $ip
#</Location>" > /etc/apache2/mods-available/jk.load.nuevo
#			sudo mv -f /etc/apache2/mods-available/jk.load.nuevo /etc/apache2/mods-available/jk.load
#		fi
	else
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

echo "Reiniciar mysql..."
if [ "$esGNewSense" == "1" ]; then
	sudo /etc/init.d/mysql restart
else
	sudo service mysql restart
fi

if [ "$reset" != "" ]; then
	echo "Reseteando jboss's..."
	sudo chmod 777 -R /opt/jboss-6.1.0.Final
	sudo chmod 777 -R /opt/jboss-6.1.0.Final.2
	sudo chmod 777 -R /opt/jboss-6.1.0.Final.3
	rm -R -f "$HOME"/opt/jboss-6.1.0.Final/server/all/data/hornetq/*
	rm -R -f "$HOME"/opt/jboss-6.1.0.Final.2/server/all/data/hornetq/*
	rm -R -f "$HOME"/opt/jboss-6.1.0.Final.3/server/all/data/hornetq/*
fi

echo "Incorporar entrada de ruteo..."
sudo route add -net 224.0.0.0/4 dev eth2
sudo route add -net 224.0.0.0/4 dev eth1
sudo route add -net 224.0.0.0/4 dev eth0

echo "Compilar y deployar el proyecto..."
directorioActual="$pwd"
cd ""$HOME"/workspace qin jboss sin ejb spring transactions/qin jboss sin ejb spring transactions"
sudo chmod 777 -R ""$HOME"/workspace qin jboss sin ejb spring transactions"
editarJdbcProperties=`cat ""$HOME"/workspace qin jboss sin ejb spring transactions/qin jboss sin ejb spring transactions/qinweb/src/main/resources/jdbc.properties" | grep "jdbc.url=jdbc:mysql://$ip:3306/qin"`
if [ "$editarJdbcProperties" != "" ]; then
	echo "jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://$ip:3306/qin
jdbc.username=$user
jdbc.password=$pass" > ""$HOME"/workspace qin jboss sin ejb spring transactions/qin jboss sin ejb spring transactions/qinweb/src/main/resources/jdbc.properties"
fi
./deploy-full.sh
sudo chmod 777 -R ""$HOME"/workspace qin jboss sin ejb spring transactions"

echo "Levantar JBoss 1 / Worker 1..."
/opt/jboss-6.1.0.Final/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=1 -Djboss.service.binding.set=ports-default &
echo "Esperar 120 segundos..."
sleep 120
echo "Levantar JBoss 2 / Worker 2..."
/opt/jboss-6.1.0.Final.2/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=2 -Djboss.service.binding.set=ports-01 &
echo "Esperar 120 segundos..."
sleep 120
echo "Levantar JBoss 3 / Worker 3..."
/opt/jboss-6.1.0.Final.3/bin/run.sh -c all -g qin -u 239.1.2.3 -b "$ip" -Djboss.messaging.ServerPeerID=3 -Djboss.service.binding.set=ports-02 &
echo "Esperar 120 segundos..."
sleep 120

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

sudo chmod 777 -R /etc/apache2
sudo chmod 777 -R /etc/libapache2-mod-jk
sudo chmod 777 -R /opt/jboss-6.1.0.Final
sudo chmod 777 -R /opt/jboss-6.1.0.Final.2
sudo chmod 777 -R /opt/jboss-6.1.0.Final.3
sudo chmod 777 -R "$HOME"/"workspace qin jboss sin ejb spring transactions"

echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "Proceso terminado"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
echo "-------------------------------------------------------------------------"
cd "$directorioActual"

# tail -f /home/diego/opt/jboss-6.1.0.Final/server/all/log
# tail -f /home/diego/opt/jboss-6.1.0.Final.2/server/all/log
# tail -f /home/diego/opt/jboss-6.1.0.Final.3/server/all/log

exit 0

