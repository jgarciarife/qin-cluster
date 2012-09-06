#!/bin/bash

echo "resetearBaseDeDatos.sh"

posicion="$PWD"

echo "Ingrese contraseña qinweb"
mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qin-deletes.sql
echo "Ingrese contraseña qinweb"
mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qin-creates.sql
echo "Ingrese contraseña qinweb"
mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qin-inserts.sql
echo "Ingrese contraseña qinweb"
mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qintomcat-deletes.sql
echo "Ingrese contraseña qinweb"
mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qintomcat-creates.sql
echo "Ingrese contraseña qinweb"
mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qintomcat-inserts.sql
