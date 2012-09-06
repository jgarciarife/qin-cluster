#!/bin/bash

echo "compilarYDeployarQinweb.sh"

posicion="$PWD"

if [ "$editarPersistencia" == "" ]; then
	editarPersistencia="$1"
fi
if [ "$user" == "" ]; then
	user="$2"
fi
if [ "$pass" == "" ]; then
	pass="$3"
fi
if [ "$editarPersistencia" == "" ]; then
	editarPersistencia="1"
fi
if [ "$user" == "" ]; then
	user="qinweb"
fi
if [ "$pass" == "" ]; then
	pass="qinweb"
fi

directorioActual="$PWD"
echo "cd $HOME/workspace/qin-cluster/qin jboss sin ejb spring transactions"
cd "$HOME"/"workspace/qin-cluster/qin jboss sin ejb spring transactions"
if [ "$editarPersistencia" == "1" ]; then
	editarJdbcProperties=`cat "$HOME/workspace/qin-cluster/qin jboss sin ejb spring transactions/qinweb/src/main/resources/jdbc.properties" | grep "jdbc.url=jdbc:mysql://basededatos:3306/qin"`
	if [ "$editarJdbcProperties" == "" ]; then
		echo "jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://basededatos:3306/qin
jdbc.username=$user
jdbc.password=$pass" > "$HOME/workspace/qin-cluster/qin jboss sin ejb spring transactions/qinweb/src/main/resources/jdbc.properties"
	fi
fi
echo "./deploy-full.sh"
./deploy-full.sh
echo "cd $directorioActual"
cd "$directorioActual"

directorioActual="$PWD"
echo "cd $HOME/workspace/qin-cluster/qintomcat"
cd "$HOME"/"workspace/qin-cluster/qintomcat"
if [ "$editarPersistencia" == "1" ]; then
	editarJdbcProperties=`cat "$HOME/workspace/qin-cluster/qintomcat/src/main/resources/jdbc.properties" | grep "jdbc.url=jdbc:mysql://basededatos:3306/qin"`
	if [ "$editarJdbcProperties" == "" ]; then
		echo "jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://basededatos:3306/qin
jdbc.username=$user
jdbc.password=$pass" > "$HOME/workspace/qin-cluster/qintomcat/src/main/resources/jdbc.properties"
	fi
fi
echo "./deploy-full.sh"
./deploy-full.sh
echo "cd $directorioActual"
cd "$directorioActual"
