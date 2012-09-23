#!/bin/bash

echo "subirTerracotta.sh"

posicion="$PWD"

function subirTerracotta() {
	sudo "$posicion"/configurarProcesador.sh
	export JAVA_HOME=/usr/lib/jvm/default-java
	export JAVA_OPTS="-Xms1024m -Xmx1024m -Xmn256m -XX:MaxPermSize=256M -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000 -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+CMSParallelRemarkEnabled -XX:+UseParNewGC -XX:CMSInitiatingOccupancyFraction=60 -XX:+UseCMSInitiatingOccupancyOnly -XX:+UseCMSCompactAtFullCollection $JAVA_OPTS"
	echo "/opt/terracotta-3.6.0/bin/start-tc-server.sh &"
	/opt/terracotta-3.6.0/bin/start-tc-server.sh &
}
subirTerracotta