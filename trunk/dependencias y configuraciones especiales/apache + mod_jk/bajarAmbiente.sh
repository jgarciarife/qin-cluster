#!/bin/bash

echo "bajarAmbiente.sh"

posicion="$PWD"

source "$posicion"/bajarApacheCompleto.sh
# instancia 1
source "$posicion"/bajarJboss.sh
# instancia 2
instancia="2"
bajarInstancia
# instancia 3
instancia="3"
bajarInstancia
#source "$posicion"/bajarMysql.sh
source "$posicion"/manejarPermisos.sh