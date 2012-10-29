#!/bin/bash

# Unificar carátula e informe y generar la versión final

nombre_archivo="Trabajo Profesional - Qin Cluster"
nombre_archivo_auxiliar="$nombre_archivo-aux.pdf"
nombre_archivo_final="$nombre_archivo.pdf"

rm -f ./"$nombre_archivo_final"
rm -f ./"InformeFinal.pdf"
rm -f ./"InformeFinal.doc"
rm -f ./"caratula.pdf"
rm -f ./"caratula.doc"
rm -f ./*~

echo "Por favor, cierre correctamente todas las instancias de LibreOffice y/o OpenOffice que esté usando, y luego presione ENTER"
read -e variableEntrada
sudo killall libreoffice
sudo killall openoffice

# libreoffice --headless --invisible --convert-to doc ./caratula.odt
# libreoffice --headless --invisible --convert-to doc ./InformeFinal.odt
libreoffice --headless --invisible --convert-to pdf ./caratula.odt
libreoffice --headless --invisible --convert-to pdf ./InformeFinal.odt

sudo killall libreoffice
sudo killall openoffice

pdfsam-console -compressed -f ./caratula.pdf -f ./InformeFinal.pdf -o ./"$nombre_archivo_auxiliar" -overwrite -pdfversion 7 concat

pdfopt ./"$nombre_archivo_auxiliar" ./"$nombre_archivo_final"

rm -f ./"$nombre_archivo_auxiliar"

rm -f ./"PDFsam*"

svn cleanup

svn add --force * --auto-props --parents --depth infinity && svn ci -m "" *

svn update

exit 0
