#!/bin/bash

echo "resetearBaseDeDatos.sh"

posicion="$PWD"

mysql -h basededatos -u qinweb -p qin < "$posicion"/../qin-deletes.sql

mysql -h basededatos -u qinweb -p qin < "$posicion"/../qin-creates.sql

mysql -h basededatos -u qinweb -p qin < "$posicion"/../qin-inserts.sql
