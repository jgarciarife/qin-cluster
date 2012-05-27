#!/bin/bash

DEBUG="0"
INGRESO_TEXTO="1"

function debecho() {
	if [ "$DEBUG" == "1" ]; then
		if [ "$1" != "" ] ; then
			echo "$1" >&2
			if [ "$INGRESO_TEXTO" == "1" ] ; then
				read -e usuario
			fi
		fi
	fi
}

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - posicion='$PWD'"

posicion="$PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - posicion: $posicion"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd qinweb"

cd qinweb

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - PWD: $PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R target"

rm -R target

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn clean install"

mvn clean install

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn eclipse:eclipse"

mvn eclipse:eclipse

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd .."

cd ..

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - PWD: $PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd qinejb"

cd qinejb

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - PWD: $PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R target"

rm -R target

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn clean install"

mvn clean install

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn eclipse:eclipse"

mvn eclipse:eclipse

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd .."

cd ..

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - PWD: $PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd qinear"

cd qinear

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - PWD: $PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R target/qinear-1.0"

rm -R target/qinear-1.0

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm -R target/qinear-1.0.ear"

rm -R target/qinear-1.0.ear

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn clean install"

mvn clean install

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn eclipse:eclipse"

mvn eclipse:eclipse

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd .."

cd ..

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - mvn clean install"

mvn clean install

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm /opt/jboss-6.1.0.Final/server/all/deploy/qinear-1.0.ear"

rm "/opt/jboss-6.1.0.Final/server/all/deploy/qinear-1.0.ear"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - rm /opt/jboss-6.1.0.Final.2/server/all/deploy/qinear-1.0.ear"

rm "/opt/jboss-6.1.0.Final.2/server/all/deploy/qinear-1.0.ear"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cp -f qinear/target/qinear-1.0.ear /opt/jboss-6.1.0.Final/server/all/deploy/qinear-1.0.ear"

cp -f "qinear/target/qinear-1.0.ear" "/opt/jboss-6.1.0.Final/server/all/deploy/qinear-1.0.ear"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cp -f qinear/target/qinear-1.0.ear /opt/jboss-6.1.0.Final.2/server/all/deploy/qinear-1.0.ear"

cp -f "qinear/target/qinear-1.0.ear" "/opt/jboss-6.1.0.Final.2/server/all/deploy/qinear-1.0.ear"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - cd '$PWD'"

cd "$PWD"

debecho "[ ${BASH_SOURCE}:${LINENO}:${FUNCNAME[0]} ] - PWD: $PWD"
