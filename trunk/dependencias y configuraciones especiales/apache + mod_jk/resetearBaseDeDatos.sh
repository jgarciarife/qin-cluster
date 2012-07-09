#!/bin/bash

echo "resetearBaseDeDatos.sh"

posicion="$PWD"

mysql -u qinweb -p qin < "$posicion"/../qin-deletes.sql

mysql -u qinweb -p qin < "$posicion"/../qin-inserts.sql
