#!/bin/bash

echo "martin.sh"

posicion="$PWD"

sudo "$posicion"/configurarProcesador.sh

cluster="$1"

if [ "$cluster" == "" ]; then
	cluster="jboss"
fi

#instancia1
instancia="2"
if [ "$cluster" == "jboss" ]; then
	echo "Cluster: JBoss"
	source "$posicion"/subirJboss.sh
else
	echo "Cluster: Terracotta"
	source "$posicion"/subirTomcat.sh
fi

source "$posicion"/manejarPermisos.sh
exit 0
