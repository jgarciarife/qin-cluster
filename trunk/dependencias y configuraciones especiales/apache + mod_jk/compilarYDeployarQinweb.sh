#!/bin/bash

echo "compilarYDeployarQinweb.sh"

posicion="$PWD"

if [ "$editarPersistencia" == "" ]; then
	editarPersistencia="$1"
fi
if [ "$ip" == "" ]; then
	ip="$2"
fi
if [ "$user" == "" ]; then
	user="$3"
fi
if [ "$pass" == "" ]; then
	pass="$4"
fi

if [ "$editarPersistencia" == "" ]; then
	editarPersistencia="1"
fi
if [ "$ip" == "" ]; then
	source "$posicion"/detectarIpConexion.sh
fi
if [ "$user" == "" ]; then
	user="root"
fi
if [ "$pass" == "" ]; then
	pass="diego"
fi

directorioActual="$PWD"
echo "cd $HOME/workspace qin jboss sin ejb spring transactions/qin jboss sin ejb spring transactions"
cd "$HOME"/"workspace qin jboss sin ejb spring transactions/qin jboss sin ejb spring transactions"
if [ "$editarPersistencia" == "1" ]; then
	editarJdbcProperties=`cat "$HOME"/"workspace qin jboss sin ejb spring transactions/qin jboss sin ejb spring transactions/qinweb/src/main/resources/jdbc.properties" | grep "jdbc.url=jdbc:mysql://$ip:3306/qin"`
	if [ "$editarJdbcProperties" != "" ]; then
		echo "jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://$ip:3306/qin
jdbc.username=$user
jdbc.password=$pass" > "$HOME"/"workspace qin jboss sin ejb spring transactions/qin jboss sin ejb spring transactions/qinweb/src/main/resources/jdbc.properties"
	fi
fi
echo "./deploy-full.sh"
./deploy-full.sh
echo "cd $directorioActual"
cd "$directorioActual"
