#!/bin/bash
mvn clean install
rm /home/martin/jboss-6.1.0.Final/server/default/deploy/qinear-1.0.ear
cp /home/martin/"qin jboss sin ejb spring transactions"/qinear/target/qinear-1.0.ear /home/martin/jboss-6.1.0.Final/server/default/deploy/qinear-1.0.ear
/home/martin/jboss-6.1.0.Final/bin/run.sh
