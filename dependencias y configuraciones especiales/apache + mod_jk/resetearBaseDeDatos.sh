#!/bin/bash

echo "resetearBaseDeDatos.sh"

posicion="$PWD"

echo "qin-deletes.sql"
mysql -h basededatos -uqinweb -pqinweb < "$posicion"/../../pruebas/recursos/qin-deletes.sql
echo "qin-creates.sql"
mysql -h basededatos -uqinweb -pqinweb < "$posicion"/../../pruebas/recursos/qin-creates.sql
echo "qin-inserts.sql"
mysql -h basededatos -uqinweb -pqinweb < "$posicion"/../../pruebas/recursos/qin-inserts.sql
echo "qintomcat-deletes.sql"
mysql -h basededatos -uqinweb -pqinweb < "$posicion"/../../pruebas/recursos/qintomcat-deletes.sql
echo "qintomcat-creates.sql"
mysql -h basededatos -uqinweb -pqinweb < "$posicion"/../../pruebas/recursos/qintomcat-creates.sql
echo "qintomcat-inserts.sql"
mysql -h basededatos -uqinweb -pqinweb < "$posicion"/../../pruebas/recursos/qintomcat-inserts.sql
