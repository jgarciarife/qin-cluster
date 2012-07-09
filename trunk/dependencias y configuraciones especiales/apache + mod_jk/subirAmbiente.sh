#!/bin/bash

echo "subirAmbiente.sh"

instancias="$1"

if [ "$instancias" == "" ]; then
	instancias="2"
fi

reset="$2"

if [ "$reset" == "" ]; then
	reset="0"
fi

posicion="$PWD"

source "$posicion"/bajarAmbiente.sh
#source "$posicion"/instalarPaquetes.sh
source "$posicion"/backupearArchivosConfiguracion.sh
#ipInstancia1="worker1"
#puertoInstancia1="8009"
#ipInstancia2="worker2"
#puertoInstancia2="8109"
#ipInstancia3="worker3"
#puertoInstancia3="8209"
source "$posicion"/subirMysql.sh
source "$posicion"/agregarEntradaEnRouter.sh
#ipBaseDatos="basededatos"
#source "$posicion"/compilarYDeployarQinweb.sh
if [ "$reset" == "1" ]; then
	rm -R -f "$HOME"/opt/jboss-6.1.0.Final/server/all/data/hornetq/*
	rm -R -f "$HOME"/opt/jboss-6.1.0.Final.2/server/all/data/hornetq/*
	rm -R -f "$HOME"/opt/jboss-6.1.0.Final.3/server/all/data/hornetq/*
fi
#instancia1
instancia="1"
source "$posicion"/subirJboss.sh
if [ "$instancias" == "2" ] || [ "$instancias" == "3" ]; then
	#instancia2
	#instancia="2"
	#subirJboss
	echo "hola"
fi
if [ "$instancias" == "3" ]; then
	#instancia3
	instancia="3"
	subirJboss
fi
source "$posicion"/subirApacheCompleto.sh
source "$posicion"/manejarPermisos.sh
exit 0

