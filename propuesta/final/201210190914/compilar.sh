#!/bin/bash

# Unificar carátula e informe y generar la versión final

nombre_archivo="Trabajo Profesional - Qin Cluster"
nombre_archivo_auxiliar="$nombre_archivo-aux.pdf"
nombre_archivo_final="$nombre_archivo.pdf"

rm -f ./"$nombre_archivo_final"

# pdftk ./caratula.pdf ./InformeFinal.pdf cat output ./"$nombre_archivo_final"

pdfsam-console -compressed -f ./caratula.pdf -f ./InformeFinal.pdf -o ./"$nombre_archivo_auxiliar" -overwrite -pdfversion 7 concat

pdfopt ./"$nombre_archivo_auxiliar" ./"$nombre_archivo_final"

rm -f ./"$nombre_archivo_auxiliar"

rm -f ./"PDFsam*"
