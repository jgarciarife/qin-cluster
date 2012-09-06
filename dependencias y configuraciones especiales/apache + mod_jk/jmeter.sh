#!/bin/bash

echo "jmeter.sh"

posicion="$PWD"

sudo "$posicion"/configurarProcesador.sh

/opt/apache-jmeter-2.7/bin/jmeter

exit 0
