!/bin/bash
/home/martin/apache-tomcat-7.0.23/bin/shutdown.sh
mvn clean install
ant deploy-war
/home/martin/apache-tomcat-7.0.23/bin/startup.sh
tail -f /home/martin/apache-tomcat-7.0.23/logs/portalempresas.log
