#!/bin/bash

# Unificar carátula e informe y generar la versión final

rm -f ./"Trabajo Final - Qin.pdf"

pdftk ./caratula.pdf ./InformeFinal.pdf cat output ./"Trabajo Final - Qin.pdf"
