#!/bin/bash

# Unificar carátula e informe y generar la versión final del informe y de la presentación

function compilarInforme() {
	nombre_archivo="Trabajo Profesional - Qin Cluster"
	nombre_archivo_auxiliar="$nombre_archivo-aux.pdf"
	nombre_archivo_auxiliar2="$nombre_archivo-aux2.pdf"
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
	pdftk ./"$nombre_archivo_auxiliar" update_info ./metadata.txt output ./"$nombre_archivo_auxiliar2"
	pdfopt ./"$nombre_archivo_auxiliar2" ./"$nombre_archivo_final"
	rm -f ./"$nombre_archivo_auxiliar"
	rm -f ./"$nombre_archivo_auxiliar2"
	rm -f ./"PDFsam*"
}

function compilarPresentacion() {
	nombre_archivo_auxiliar_presentacion="presentacion - aux.pdf"
	nombre_archivo_final_presentacion="Trabajo Profesional - Qin Cluster - Presentación.pdf"
	rm -f ./"$nombre_archivo_final_presentacion"
	rm -f ./"presentacion.pdf"
	rm -f ./"presentacion.doc"
	rm -f ./*~
	echo "Por favor, cierre correctamente todas las instancias de LibreOffice y/o OpenOffice que esté usando, y luego presione ENTER"
	read -e variableEntrada
	sudo killall libreoffice
	sudo killall openoffice
	# libreoffice --headless --invisible --convert-to doc ./presentacion.odt
	libreoffice --headless --invisible --convert-to pdf ./presentacion.odt
	sudo killall libreoffice
	sudo killall openoffice
	pdftk ./"presentacion.pdf" update_info ./"metadata - presentacion.txt" output ./"$nombre_archivo_auxiliar_presentacion"
	pdfopt ./"$nombre_archivo_auxiliar_presentacion" ./"$nombre_archivo_final_presentacion"
	rm -f ./"$nombre_archivo_auxiliar_presentacion"
	rm -f ./"PDFsam*"
}

function commitear() {
	svn cleanup && svn add --force * --auto-props --parents --depth infinity && svn ci -m "" * && svn update
}

# compilarInforme

compilarPresentacion

# commitear

exit 0

