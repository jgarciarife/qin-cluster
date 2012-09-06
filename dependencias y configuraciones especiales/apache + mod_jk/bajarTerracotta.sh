#!/bin/bash

echo "bajarTerracotta.sh"

posicion="$PWD"

function bajarInstanciaTerracotta() {
	JAVA_HOME=/usr/lib/jvm/default-java
	export $JAVA_HOME
	JAVA_OPTS="-Xms512m -Xmx2048m -Xmn128m -XX:MaxPermSize=256M -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000 -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+CMSParallelRemarkEnabled -XX:+UseParNewGC -XX:CMSInitiatingOccupancyFraction=60 -XX:+UseCMSInitiatingOccupancyOnly -XX:+UseCMSCompactAtFullCollection $JAVA_OPTS"
	export $JAVA_OPTS
	/opt/terracotta-3.6.0/bin/stop-tc-server.sh
}

bajarInstanciaTerracotta
