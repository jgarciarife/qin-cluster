#!/bin/bash

echo "subirApacheCompleto.sh"

posicion="$PWD"

"$posicion"/editarArchivosConfiguracion.sh
"$posicion"/recargarConfiguracionApache.sh
"$posicion"/subirApache.sh
