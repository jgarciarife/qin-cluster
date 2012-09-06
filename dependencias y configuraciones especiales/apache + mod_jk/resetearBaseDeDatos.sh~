#!/bin/bash

echo "resetearBaseDeDatos.sh"

posicion="$PWD"

mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qin-deletes.sql

mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qin-creates.sql

mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/recursos/qin-inserts.sql
