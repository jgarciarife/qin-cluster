#!/bin/bash

echo "limpiar"

array=( $(find . -type d -name ".svn" 2>> /dev/null | sed 's/\s/[ESPACIO]/gi') )
for directorio in "${array[@]}"; do
	directorio=`echo "$directorio" | sed 's/\[ESPACIO\]/ /gi' | sed 's/\://gi'`
	rm -rf "$directorio"
done
array=( $(find . -type f -name "*~" 2>> /dev/null | sed 's/\s/[ESPACIO]/gi') )
for directorio in "${array[@]}"; do
	directorio=`echo "$directorio" | sed 's/\[ESPACIO\]/ /gi' | sed 's/\://gi'`
	rm -rf "$directorio"
done

echo "comprobar"

array=( $(find . -type d -name ".svn" 2>> /dev/null | sed 's/\s/[ESPACIO]/gi') )
for directorio in "${array[@]}"; do
	directorio=`echo "$directorio" | sed 's/\[ESPACIO\]/ /gi' | sed 's/\://gi'`
	echo "$directorio"
done
array=( $(find . -type f -name "*~" 2>> /dev/null | sed 's/\s/[ESPACIO]/gi') )
for directorio in "${array[@]}"; do
	directorio=`echo "$directorio" | sed 's/\[ESPACIO\]/ /gi' | sed 's/\://gi'`
	echo "$directorio"
done
