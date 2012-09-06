#!/bin/bash

echo "bajarTerracotta.sh"

posicion="$PWD"

function bajarInstanciaTerracotta() {
	JAVA_HOME=/usr/lib/jvm/default-java
	export $JAVA_HOME
	/opt/terracotta-3.6.0/bin/stop-tc-server.sh
}

bajarInstanciaTerracotta
