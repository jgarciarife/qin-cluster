#!/bin/bash

echo "subirTerracotta.sh"

posicion="$PWD"

function subirTerracotta() {
	JAVA_HOME=/usr/lib/jvm/default-java
	export $JAVA_HOME
	/opt/terracotta-3.6.0/bin/start-tc-server.sh
}
subirTerracotta
