#!/bin/bash

echo "logearJboss.sh"

if [ "$instancia" == "" ]; then
	instancia="$1"
fi

if [ "$instancia" == "" ]; then
	instancia="1"
fi

if [ "$instancia" == "1" ]; then
	tail -f /home/diego/opt/jboss-6.1.0.Final/server/all/log/server.log
fi
if [ "$instancia" == "2" ]; then
	tail -f /home/diego/opt/jboss-6.1.0.Final.2/server/all/log/server.log
fi
if [ "$instancia" == "3" ]; then
	tail -f /home/diego/opt/jboss-6.1.0.Final.3/server/all/log/server.log
fi

