#!/bin/bash

echo "bajarAmbiente.sh"

posicion="$PWD"

source "$posicion"/bajarApacheCompleto.sh
source "$posicion"/bajarJboss.sh
source "$posicion"/bajarTerracotta.sh
source "$posicion"/bajarTomcat.sh
source "$posicion"/bajarMysql.sh
source "$posicion"/manejarPermisos.sh
sudo "$posicion"/resetearProcesador.sh
sudo "$posicion"/limpiarAmbiente.sh
