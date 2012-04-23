-------------Sincronizacion de texto

Modificacion de la clase SincronizadorTextoImpl para que utilice un mapa obtenido del TerracottaToolkit

Dependencias:
 		<dependency>
			<groupId>org.terracotta</groupId>
			<artifactId>terracotta-toolkit-1.4-runtime</artifactId>
			<version>4.0.0</version>
		</dependency>
		
Pros: muy facil
Cons: invasion del codigo
Alt: usar terracotta dso, lo cual es no-recomendado por ser mas complicado, 
y porque la opcion anterior funciona "out of the box" y ya se encarga de los locks correspondientes

---------------Second level cache
Modificaciones en codigo (independientes de terracotta)
A nivel de clases: @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
A nivel de query: query.setCacheable(true);
	
En hibernate.cfg.xml:
		<property name="cache.use_second_level_cache">true</property>
    	<property name="cache.provider_class">net.sf.ehcache.hibernate.EhCacheProvider</property>
    	<property name="net.sf.ehcache.configurationResourceName">ehcache.xml</property>

En eh cache (especifico de terracotta):

<?xml version="1.0" encoding="UTF-8"?>

<ehcache name="QinWebCache">
   <defaultCache
      maxElementsInMemory="10"
      eternal="false"
      timeToIdleSeconds="120"
      timeToLiveSeconds="120"
      overflowToDisk="false">
      <terracotta/>
    </defaultCache>
  <terracottaConfig url="localhost:9510"/>
</ehcache>


Dependencias:
		<dependency>
      		<groupId>net.sf.ehcache</groupId>
      		<artifactId>ehcache-core</artifactId>
      		<version>${ehcache-core.version}</version>
    	</dependency>      
    	<dependency>
			<groupId>net.sf.ehcache</groupId>
			<artifactId>ehcache-terracotta</artifactId>
			<version>${ehcache-terracotta.version}</version>
		</dependency>

Pros: muy facil
Cons: modificar un xml
Alt: falta investigar.
		
-------------- Sesiones
Copiar a <CATALINA_HOME>/lib/terracotta-session-1.2.0.jar
		 <CATALINA_HOME>/lib/terracotta-toolkit-1.4-runtime-4.0.0.jar
		 
En tomcat context.xml:
<Context>
	  <Valve className="org.terracotta.session.TerracottaTomcat70xSessionValve" tcConfigUrl="localhost:9510"/>
</Context>

En catalina.sh
JAVA_OPTS="$JAVA_OPTS -XX:MaxPermSize=512m"

Dependencias:
    <dependency>
      <groupId>org.terracotta.session</groupId>
      <artifactId>terracotta-session</artifactId>
      <version>1.2.0</version>
    </dependency