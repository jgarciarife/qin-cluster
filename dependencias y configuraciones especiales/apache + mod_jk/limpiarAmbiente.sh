#!/bin/bash

echo "limpiarAmbiente.sh"

posicion="$PWD"

function limpiarServidoresYLogs() {
	rm -R -f /opt/jboss-6.1.0.Final/server/all/data/hornetq/*
	rm -R -f /opt/jboss-6.1.0.Final.2/server/all/data/hornetq/*
	rm -R -f /opt/jboss-6.1.0.Final.3/server/all/data/hornetq/*
	rm -R -f /opt/jboss-6.1.0.Final/bin/*.log
	rm -R -f /opt/jboss-6.1.0.Final/bin/*.log.*
	rm -R -f /opt/jboss-6.1.0.Final.2/bin/*.log
	rm -R -f /opt/jboss-6.1.0.Final.2/bin/*.log.*
	rm -R -f /opt/jboss-6.1.0.Final.3/bin/*.log
	rm -R -f /opt/jboss-6.1.0.Final.3/bin/*.log.*
	rm -R -f /opt/jboss-6.1.0.Final/bin/*.old
	rm -R -f /opt/jboss-6.1.0.Final.2/bin/*.old
	rm -R -f /opt/jboss-6.1.0.Final.3/bin/*.old
	rm -R -f /opt/jboss-6.1.0.Final/bin/*~
	rm -R -f /opt/jboss-6.1.0.Final.2/bin/*~
	rm -R -f /opt/jboss-6.1.0.Final.3/bin/*~
	sudo rm -R -f /var/log/apache2/*
	rm -R -f /opt/jboss-6.1.0.Final/server/all/log/*
	rm -R -f /opt/jboss-6.1.0.Final/server/all/tmp/*
	rm -R -f /opt/jboss-6.1.0.Final/server/all/work/jboss.web/localhost/*
	rm -R -f /opt/jboss-6.1.0.Final.2/server/all/log/*
	rm -R -f /opt/jboss-6.1.0.Final.2/server/all/tmp/*
	rm -R -f /opt/jboss-6.1.0.Final.2/server/all/work/jboss.web/localhost/*
	rm -R -f /opt/jboss-6.1.0.Final.3/server/all/log/*
	rm -R -f /opt/jboss-6.1.0.Final.3/server/all/tmp/*
	rm -R -f /opt/jboss-6.1.0.Final.3/server/all/work/jboss.web/localhost/*
	rm -R -f /opt/apache-tomcat-7.0.23/bin/*.log
	rm -R -f /opt/apache-tomcat-7.0.23/bin/*.log.*
	rm -R -f /opt/apache-tomcat-7.0.23/bin/*~
	rm -R -f /opt/apache-tomcat-7.0.23/conf/*.old
	rm -R -f /opt/apache-tomcat-7.0.23/conf/*~
	rm -R -f /opt/apache-tomcat-7.0.23/bin/Catalina
	rm -R -f /opt/apache-tomcat-7.0.23/bin/catalina
	rm -R -f /opt/apache-tomcat-7.0.23/bin/Backup
	rm -R -f /opt/apache-tomcat-7.0.23/bin/backup
	rm -R -f /opt/apache-tomcat-7.0.23/conf/Catalina
	rm -R -f /opt/apache-tomcat-7.0.23/conf/catalina
	rm -R -f /opt/apache-tomcat-7.0.23/conf/Backup
	rm -R -f /opt/apache-tomcat-7.0.23/conf/backup
	rm -R -f /opt/apache-tomcat-7.0.23/logs/*
	rm -R -f /opt/apache-tomcat-7.0.23/temp/*
	rm -R -f /opt/apache-tomcat-7.0.23/work/Catalina/localhost/*
#	rm -R -f /opt/apache-tomcat-7.0.23/webapps/*
	rm -R -f /opt/apache-tomcat-7.0.23.2/bin/*.log
	rm -R -f /opt/apache-tomcat-7.0.23.2/bin/*.log.*
	rm -R -f /opt/apache-tomcat-7.0.23.2/bin/*~
	rm -R -f /opt/apache-tomcat-7.0.23.2/conf/*.old
	rm -R -f /opt/apache-tomcat-7.0.23.2/conf/*~
	rm -R -f /opt/apache-tomcat-7.0.23.2/bin/Catalina
	rm -R -f /opt/apache-tomcat-7.0.23.2/bin/catalina
	rm -R -f /opt/apache-tomcat-7.0.23.2/bin/Backup
	rm -R -f /opt/apache-tomcat-7.0.23.2/bin/backup
	rm -R -f /opt/apache-tomcat-7.0.23.2/conf/Catalina
	rm -R -f /opt/apache-tomcat-7.0.23.2/conf/catalina
	rm -R -f /opt/apache-tomcat-7.0.23.2/conf/Backup
	rm -R -f /opt/apache-tomcat-7.0.23.2/conf/backup
	rm -R -f /opt/apache-tomcat-7.0.23.2/logs/*
	rm -R -f /opt/apache-tomcat-7.0.23.2/temp/*
	rm -R -f /opt/apache-tomcat-7.0.23.2/work/Catalina/localhost/*
#	rm -R -f /opt/apache-tomcat-7.0.23.2/webapps/*
	rm -R -f /opt/apache-tomcat-7.0.23.3/bin/*.log
	rm -R -f /opt/apache-tomcat-7.0.23.3/bin/*.log.*
	rm -R -f /opt/apache-tomcat-7.0.23.3/bin/*~
	rm -R -f /opt/apache-tomcat-7.0.23.3/conf/*.old
	rm -R -f /opt/apache-tomcat-7.0.23.3/conf/*~
	rm -R -f /opt/apache-tomcat-7.0.23.3/bin/Catalina
	rm -R -f /opt/apache-tomcat-7.0.23.3/bin/catalina
	rm -R -f /opt/apache-tomcat-7.0.23.3/bin/Backup
	rm -R -f /opt/apache-tomcat-7.0.23.3/bin/backup
	rm -R -f /opt/apache-tomcat-7.0.23.3/conf/Catalina
	rm -R -f /opt/apache-tomcat-7.0.23.3/conf/catalina
	rm -R -f /opt/apache-tomcat-7.0.23.3/conf/Backup
	rm -R -f /opt/apache-tomcat-7.0.23.3/conf/backup
	rm -R -f /opt/apache-tomcat-7.0.23.3/logs/*
	rm -R -f /opt/apache-tomcat-7.0.23.3/temp/*
	rm -R -f /opt/apache-tomcat-7.0.23.3/work/Catalina/localhost/*
#	rm -R -f /opt/apache-tomcat-7.0.23.3/webapps/*
	rm -R -f "$HOME"/workspace/qin-cluster/"dependencias y configuraciones especiales"/"apache + mod_jk"/*.log
	rm -R -f "$HOME"/workspace/qin-cluster/"dependencias y configuraciones especiales"/"apache + mod_jk"/*.log.*
	rm -R -f "$HOME"/workspace/qin-cluster/"dependencias y configuraciones especiales"/"apache + mod_jk"/*.old
	rm -R -f "$HOME"/workspace/qin-cluster/"dependencias y configuraciones especiales"/"apache + mod_jk"/*~
	rm -R -f /opt/terracotta-3.6.0/bin/*.log
	rm -R -f /opt/terracotta-3.6.0/bin/*.log.*
	rm -R -f /opt/terracotta-3.6.0/bin/*.old
	rm -R -f /opt/terracotta-3.6.0/bin/*~
	sudo rm -R -f /etc/apache2/*.log
	sudo rm -R -f /etc/apache2/*.log.*
	sudo rm -R -f /etc/apache2/*.old
	sudo rm -R -f /etc/apache2/*~
	sudo rm -R -f /etc/libapache2-mod-jk/*.log
	sudo rm -R -f /etc/libapache2-mod-jk/*.log.*
	sudo rm -R -f /etc/libapache2-mod-jk/*.old
	sudo rm -R -f /etc/libapache2-mod-jk/*~
	sudo rm -R -f /etc/apache2/mods-available/*.log
	sudo rm -R -f /etc/apache2/mods-available/*.log.*
	sudo rm -R -f /etc/apache2/mods-available/*.old
	sudo rm -R -f /etc/apache2/mods-available/*~
	sudo rm -R -f /etc/apache2/mods-enabled/*.log
	sudo rm -R -f /etc/apache2/mods-enabled/*.log.*
	sudo rm -R -f /etc/apache2/mods-enabled/*.old
	sudo rm -R -f /etc/apache2/mods-enabled/*~
	sudo rm -R -f /etc/apache2/sites-available/*.log
	sudo rm -R -f /etc/apache2/sites-available/*.log.*
	sudo rm -R -f /etc/apache2/sites-available/*.old
	sudo rm -R -f /etc/apache2/sites-available/*~
	sudo rm -R -f $HOME/terracotta/client-logs/*
	sudo rm -R -f $HOME/terracotta/server-logs/*
}

limpiarServidoresYLogs
