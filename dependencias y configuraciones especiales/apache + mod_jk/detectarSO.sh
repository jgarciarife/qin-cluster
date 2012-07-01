#!/bin/bash

echo "detectarSO.sh"

esGNewSense=`cat /etc/*-release | grep 'gNewSense'`
if [ "$esGNewSense" != "" ""]; then
	esGNewSense="1"
	echo "$esGNewSense"
else
	esGNewSense="0"
	echo "$esGNewSense"
fi
