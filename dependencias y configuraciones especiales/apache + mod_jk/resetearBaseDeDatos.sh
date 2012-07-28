#!/bin/bash

echo "resetearBaseDeDatos.sh"

posicion="$PWD"

mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/qin-deletes.sql

mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/qin-creates.sql

mysql -h basededatos -u qinweb -p qin < "$posicion"/../../pruebas/qin-inserts.sql
