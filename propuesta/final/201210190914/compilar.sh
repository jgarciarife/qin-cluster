#!/bin/bash

# Unificar carátula e informe y generar la versión final

rm -f ./"Trabajo Final - Qin.pdf"

# pdftk ./caratula.pdf ./InformeFinal.pdf cat output ./"Trabajo Final - Qin.pdf"

pdfsam-console -compressed -f ./caratula.pdf -f ./InformeFinal.pdf -o ./"Trabajo Final - Qin-aux.pdf" -overwrite -pdfversion 7 concat

pdfopt ./"Trabajo Final - Qin-aux.pdf" ./"Trabajo Final - Qin.pdf"

rm -f ./"Trabajo Final - Qin-aux.pdf"

rm -f ./"PDFsam*"
