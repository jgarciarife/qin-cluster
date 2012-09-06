#!/bin/bash

DEBUG="0"
INGRESO_TEXTO="1"

function debecho() {
	if [ "$DEBUG" == "1" ]; then
		if [ "$1" != "" ] ; then
			echo "$1" >&2
			if [ "$INGRESO_TEXTO" == "1" ] ; then
				read -e usuarioNombreRaroVariable
			fi
		fi
	fi
}

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - posicion='$PWD'"

posicion="$PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - posicion: $posicion"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R -f target"

rm -R -f target

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn clean install"

mvn clean install

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn eclipse:eclipse"

mvn eclipse:eclipse

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R -f /opt/apache-tomcat-7.0.23/webapps/qinweb.war"

rm -R -f /opt/apache-tomcat-7.0.23/webapps/qinear.war

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R -f /opt/apache-tomcat-7.0.23/webapps/qinweb"

rm -R -f /opt/apache-tomcat-7.0.23/webapps/qinear

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R -f /opt/apache-tomcat-7.0.23.2/webapps/qinweb.war"

rm -R -f /opt/apache-tomcat-7.0.23.2/webapps/qinear.war

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R -f /opt/apache-tomcat-7.0.23.2/webapps/qinweb"

rm -R -f /opt/apache-tomcat-7.0.23.2/webapps/qinear

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R -f /opt/apache-tomcat-7.0.23.3/webapps/qinweb.war"

rm -R -f /opt/apache-tomcat-7.0.23.3/webapps/qinear.war

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R -f /opt/apache-tomcat-7.0.23.3/webapps/qinweb"

rm -R -f /opt/apache-tomcat-7.0.23.3/webapps/qinear

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cp -f target/qinweb.war /opt/apache-tomcat-7.0.23/webapps/qinweb.war"

cp -f target/qinweb.war /opt/apache-tomcat-7.0.23/webapps/qinweb.war

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cp -f target/qinweb.war /opt/apache-tomcat-7.0.23.2/webapps/qinweb.war"

cp -f target/qinweb.war /opt/apache-tomcat-7.0.23.2/webapps/qinweb.war

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cp -f target/qinweb.war /opt/apache-tomcat-7.0.23.3/webapps/qinweb.war"

cp -f target/qinweb.war /opt/apache-tomcat-7.0.23.3/webapps/qinweb.war

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd '$PWD'"

cd "$PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - PWD: $PWD"
