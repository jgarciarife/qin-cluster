#!/bin/bash
/home/martin/apache-tomcat-7.0.23/bin/shutdown.sh
mvn clean install
rm /home/martin/apache-tomcat-7.0.23/webapps/qinweb.war
rm -r /home/martin/apache-tomcat-7.0.23/webapps/qinweb
rm -r /home/martin/apache-tomcat-7.0.23/work/Catalina/localhost/qinweb
cp /home/martin/qintomcat/target/qinweb.war /home/martin/apache-tomcat-7.0.23/webapps/
/home/martin/apache-tomcat-7.0.23/bin/startup.sh
