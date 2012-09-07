#!/bin/bash

echo "subirAmbiente.sh"

instancias="$1"

if [ "$instancias" == "" ]; then
	instancias="2"
fi

cluster="$2"

if [ "$cluster" == "" ]; then
	cluster="jboss"
fi

posicion="$PWD"

source "$posicion"/bajarAmbiente.sh
#source "$posicion"/instalarPaquetes.sh
source "$posicion"/backupearArchivosConfiguracion.sh
source "$posicion"/subirMysql.sh
source "$posicion"/resetearBaseDeDatos.sh
#source "$posicion"/compilarYDeployarQinweb.sh
sudo "$posicion"/limpiarAmbiente.sh
#instancia1
instancia="1"
if [ "$cluster" == "jboss" ]; then
	echo "Cluster: JBoss"
	source "$posicion"/agregarEntradaEnRouter.sh
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
else
	echo "Cluster: Terracotta"
	source "$posicion"/subirTerracotta.sh
	sleep 10
	source "$posicion"/subirTomcat.sh
	if [ "$instancias" == "2" ] || [ "$instancias" == "3" ]; then
		#instancia2
		instancia="2"
		subirTomcat
	fi
	if [ "$instancias" == "3" ]; then
		#instancia3
		instancia="3"
		subirTomcat
	fi
fi
source "$posicion"/subirApacheCompleto.sh
source "$posicion"/manejarPermisos.sh
exit 0

