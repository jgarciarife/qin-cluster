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
#ipInstancia1=""
#puertoInstancia1=""
#ipInstancia2=""
#puertoInstancia2=""
#ipInstancia3=""
#puertoInstancia3=""
entorno="jboss"
source "$posicion"/editarArchivosConfiguracion.sh
source "$posicion"/recargarConfiguracionApache.sh
source "$posicion"/subirMysql.sh
source "$posicion"/agregarEntradaEnRouter.sh
#ipBaseDatos=""
source "$posicion"/compilarYDeployarQinweb.sh
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
	instancia="2"
	subirJboss
fi
if [ "$instancias" == "3" ]; then
	#instancia3
	instancia="3"
	subirJboss
fi
source "$posicion"/subirApache.sh
source "$posicion"/manejarPermisos.sh
exit 0

