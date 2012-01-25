Pasos:

Previo: tener dos instalaciones de tomcat que se puedan levantar al mismo tiempo (modificando el <instalacion tomcat>/conf/server.xml)

1) Bajar e instalar la version OPEN SOURCE de terracotta. http://terracotta.org/downloads/open-source/catalog (yo estoy usando el "Terracotta Installer Binary")
2) ir a <carpeta de instalacion de terracotta>/ehcache/samples/colorcache/bin/
3) iniciar el servidor de terracotta ./start-sample-server.sh 
(debo verificar este paso, ya que me baso en el servidor de la app de ejemplo original, pero no se si esta tiene configuracion especifica necesaria para correr el ejemplo)
4) ejecutar mvn clean install en el proyecto de ejemplo
5) copiar <workspace>/target/test.war a la carpeta <instalacion tomcat>/webapps de cada tomcat
6) iniciar ambos tomcat
7) ir a la direccion de uno de ellos y buscar un color
8) ir a la direccion del otro tomcat y buscar el mismo color, verificar que el tiempo de retorno es menor gracias a la clusterizacion del mapa que contiene dicha info