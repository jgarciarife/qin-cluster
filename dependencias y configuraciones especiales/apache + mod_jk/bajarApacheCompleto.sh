#!/bin/bash
	
echo "bajarApacheCompleto.sh"

posicion="$PWD"

"$posicion"/bajarApache.sh
"$posicion"/reestablecerArchivosConfiguracion.sh
"$posicion"/recargarConfiguracionApache.sh
