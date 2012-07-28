#!/bin/bash

echo "editarArchivosConfiguracion.sh"

posicion="$PWD"

source "$posicion"/manejarPermisos.sh

if [ "$1" == "-h" ]; then
	echo "editarArchivosConfiguracion.sh esGNewSense mod_jk instancias ipApache stickysession ipInstancia1 puertoInstancia1 ipInstancia2 puertoInstancia2 ipInstancia3 puertoInstancia3"
fi

if [ "$esGNewSense" == "" ]; then
	esGNewSense="$1"
fi
if [ "$modJk" == "" ]; then
	modJk="$2"
fi
if [ "$instancias" == "" ]; then
	instancias="$3"
fi
if [ "$ipApache" == "" ]; then
	ipApache="$4"
fi
if [ "$sticky_session" == "" ]; then
	sticky_session="$5"
fi
if [ "$ipInstancia1" == "" ]; then
	ipInstancia1="$6"
fi
if [ "$puertoInstancia1" == "" ]; then
	puertoInstancia1="$7"
fi
if [ "$ipInstancia2" == "" ]; then
	ipInstancia2="$8"
fi
if [ "$puertoInstancia2" == "" ]; then
	puertoInstancia2="$9"
fi
if [ "$ipInstancia3" == "" ]; then
	ipInstancia3="$10"
fi
if [ "$puertoInstancia3" == "" ]; then
	puertoInstancia3="$11"
fi
if [ "$esGNewSense" == "" ]; then
	source "$posicion"/detectarSO.sh
fi
if [ "$modJk" == "" ]; then
	modJk="1"
fi
if [ "$instancias" == "" ]; then
	instancias="2"
fi
if [ "$ipApache" == "" ]; then
	ipApache="apache"
fi
if [ "$sticky_session" == "" ]; then
	sticky_session="1"
fi
if [ "$ipInstancia1" == "" ]; then
	ipInstancia1="worker1"
fi
if [ "$puertoInstancia1" == "" ]; then
	puertoInstancia1="8009"
fi
if [ "$ipInstancia2" == "" ]; then
	ipInstancia2="worker2"
fi
if [ "$puertoInstancia2" == "" ]; then
	puertoInstancia2="8109"
fi
if [ "$ipInstancia3" == "" ]; then
	ipInstancia3="worker3"
fi
if [ "$puertoInstancia3" == "" ]; then
	puertoInstancia3="8209"
fi

project="qinweb"

if [ "$modJk" == "0" ]; then
	sudo rm /etc/apache2/mods-enabled/jk.*
	sudo ln -s /etc/apache2/mods-available/proxy.load /etc/apache2/mods-enabled/proxy.load
	sudo ln -s /etc/apache2/mods-available/proxy.conf /etc/apache2/mods-enabled/proxy.conf
	sudo ln -s /etc/apache2/mods-available/proxy_ajp.load /etc/apache2/mods-enabled/proxy_ajp.load
	sudo ln -s /etc/apache2/mods-available/proxy_balancer.load /etc/apache2/mods-enabled/proxy_balancer.load
	sudo ln -s /etc/apache2/mods-available/proxy_balancer.conf /etc/apache2/mods-enabled/proxy_balancer.conf
fi

if [ ! -d "/etc/apache2/conf" ]; then
	echo "sudo mkdir /etc/apache2/conf"
	sudo mkdir /etc/apache2/conf
fi
if [ ! -d "/etc/apache2/logs" ]; then
	echo "sudo mkdir /etc/apache2/logs"
	sudo mkdir /etc/apache2/logs
fi
if [ ! -d "/etc/apache2/run" ]; then
	echo "sudo mkdir /etc/apache2/run"
	sudo mkdir /etc/apache2/run
fi

source "$posicion"/backupearArchivosConfiguracion.sh

if [ -f "/etc/apache2/httpd.conf.anterior" ]; then
	if [ "$esGNewSense" == "1" ]; then
		echo "Es gNewSense"
	else
		echo "#
# Based upon the NCSA server configuration files originally by Rob McCool.
#
# This is the main Apache server configuration file.  It contains the
# configuration directives that give the server its instructions.
# See http://httpd.apache.org/docs/2.2/ for detailed information about
# the directives.
#
# Do NOT simply read the instructions in here without understanding
# what they do.  They're here only as hints or reminders.  If you are unsure
# consult the online docs. You have been warned.  
#
# The configuration directives are grouped into three basic sections:
#  1. Directives that control the operation of the Apache server process as a
#     whole (the 'global environment').
#  2. Directives that define the parameters of the 'main' or 'default' server,
#     which responds to requests that aren't handled by a virtual host.
#     These directives also provide default values for the settings
#     of all virtual hosts.
#  3. Settings for virtual hosts, which allow Web requests to be sent to
#     different IP addresses or hostnames and have them handled by the
#     same Apache server process.
#
# Configuration and logfile names: If the filenames you specify for many
# of the server's control files begin with \"/\" (or \"drive:/\" for Win32), the
# server will use that explicit path.  If the filenames do *not* begin
# with \"/\", the value of ServerRoot is prepended -- so \"foo.log\"
# with ServerRoot set to \"/etc/apache2\" will be interpreted by the
# server as \"/etc/apache2/foo.log\".
#

### Section 1: Global Environment
#
# The directives in this section affect the overall operation of Apache,
# such as the number of concurrent requests it can handle or where it
# can find its configuration files.
#

#
# ServerRoot: The top of the directory tree under which the server's
# configuration, error, and log files are kept.
#
# NOTE!  If you intend to place this on an NFS (or otherwise network)
# mounted filesystem then please read the LockFile documentation (available
# at <URL:http://httpd.apache.org/docs/2.2/mod/mpm_common.html#lockfile>);
# you will save yourself a lot of trouble.
#
# Do NOT add a slash at the end of the directory path.
#
#ServerRoot \"/etc/apache2\"

#
# The accept serialization lock file MUST BE STORED ON A LOCAL DISK.
#
LockFile \${APACHE_LOCK_DIR}/accept.lock

#
# PidFile: The file in which the server should record its process
# identification number when it starts.
# This needs to be set in /etc/apache2/envvars
#
PidFile \${APACHE_PID_FILE}

#
# Timeout: The number of seconds before receives and sends time out.
#
Timeout 300

#
# KeepAlive: Whether or not to allow persistent connections (more than
# one request per connection). Set to \"Off\" to deactivate.
#
KeepAlive On

#
# MaxKeepAliveRequests: The maximum number of requests to allow
# during a persistent connection. Set to 0 to allow an unlimited amount.
# We recommend you leave this number high, for maximum performance.
#
#MaxKeepAliveRequests 100
MaxKeepAliveRequests 0

#
# KeepAliveTimeout: Number of seconds to wait for the next request from the
# same client on the same connection.
#
KeepAliveTimeout 5

##
## Server-Pool Size Regulation (MPM specific)
## 

# prefork MPM
# StartServers: number of server processes to start
# MinSpareServers: minimum number of server processes which are kept spare
# MaxSpareServers: maximum number of server processes which are kept spare
# MaxClients: maximum number of server processes allowed to start
# MaxRequestsPerChild: maximum number of requests a server process serves
#<IfModule mpm_prefork_module>
#    StartServers          5
#    MinSpareServers       5
#    MaxSpareServers      10
#    MaxClients          150
#    MaxRequestsPerChild   0
#</IfModule>
<IfModule mpm_prefork_module>
    StartServers          5
    MinSpareServers       5
    MaxSpareServers      10
    ServerLimit       10000
    MaxClients        10000
    MaxRequestsPerChild   0
</IfModule>

# worker MPM
# StartServers: initial number of server processes to start
# MinSpareThreads: minimum number of worker threads which are kept spare
# MaxSpareThreads: maximum number of worker threads which are kept spare
# ThreadLimit: ThreadsPerChild can be changed to this maximum value during a
#              graceful restart. ThreadLimit can only be changed by stopping
#              and starting Apache.
# ThreadsPerChild: constant number of worker threads in each server process
# MaxClients: maximum number of simultaneous client connections
# MaxRequestsPerChild: maximum number of requests a server process serves
#<IfModule mpm_worker_module>
#    StartServers          2
#    MinSpareThreads      25
#    MaxSpareThreads      75 
#    ThreadLimit          64
#    ThreadsPerChild      25
#    MaxClients          150
#    MaxRequestsPerChild   0
#</IfModule>
<IfModule mpm_worker_module>
    StartServers          2
    MinSpareThreads      25
    MaxSpareThreads      75 
    ThreadLimit          64
    ThreadsPerChild      25
    ServerLimit       10000
    MaxClients        10000
    MaxRequestsPerChild   0
</IfModule>

# event MPM
# StartServers: initial number of server processes to start
# MinSpareThreads: minimum number of worker threads which are kept spare
# MaxSpareThreads: maximum number of worker threads which are kept spare
# ThreadsPerChild: constant number of worker threads in each server process
# MaxClients: maximum number of simultaneous client connections
# MaxRequestsPerChild: maximum number of requests a server process serves
#<IfModule mpm_event_module>
#    StartServers          2
#    MinSpareThreads      25
#    MaxSpareThreads      75 
#    ThreadLimit          64
#    ThreadsPerChild      25
#    MaxClients          150
#    MaxRequestsPerChild   0
#</IfModule>
<IfModule mpm_event_module>
    StartServers          2
    MinSpareThreads      25
    MaxSpareThreads      75 
    ThreadLimit          64
    ThreadsPerChild      25
    ServerLimit       10000
    MaxClients        10000
    MaxRequestsPerChild   0
</IfModule>

# These need to be set in /etc/apache2/envvars
User \${APACHE_RUN_USER}
Group \${APACHE_RUN_GROUP}

#
# AccessFileName: The name of the file to look for in each directory
# for additional configuration directives.  See also the AllowOverride
# directive.
#

AccessFileName .htaccess

#
# The following lines prevent .htaccess and .htpasswd files from being 
# viewed by Web clients. 
#
<Files ~ \"^\.ht\">
    Order allow,deny
    Deny from all
    Satisfy all
</Files>

#
# DefaultType is the default MIME type the server will use for a document
# if it cannot otherwise determine one, such as from filename extensions.
# If your server contains mostly text or HTML documents, \"text/plain\" is
# a good value.  If most of your content is binary, such as applications
# or images, you may want to use \"application/octet-stream\" instead to
# keep browsers from trying to display binary files as though they are
# text.
#
# It is also possible to omit any default MIME type and let the
# client's browser guess an appropriate action instead. Typically the
# browser will decide based on the file's extension then. In cases
# where no good assumption can be made, letting the default MIME type
# unset is suggested  instead of forcing the browser to accept
# incorrect  metadata.
#
DefaultType None


#
# HostnameLookups: Log the names of clients or just their IP addresses
# e.g., www.apache.org (on) or 204.62.129.132 (off).
# The default is off because it'd be overall better for the net if people
# had to knowingly turn this feature on, since enabling it means that
# each client request will result in AT LEAST one lookup request to the
# nameserver.
#
HostnameLookups Off

# ErrorLog: The location of the error log file.
# If you do not specify an ErrorLog directive within a <VirtualHost>
# container, error messages relating to that virtual host will be
# logged here.  If you *do* define an error logfile for a <VirtualHost>
# container, that host's errors will be logged there and not here.
#
ErrorLog \${APACHE_LOG_DIR}/error.log

#
# LogLevel: Control the number of messages logged to the error_log.
# Possible values include: debug, info, notice, warn, error, crit,
# alert, emerg.
#
LogLevel error

# Include module configuration:
Include mods-enabled/*.load
Include mods-enabled/*.conf

# Include all the user configurations:
Include httpd.conf

# Include ports listing
Include ports.conf

#
# The following directives define some format nicknames for use with
# a CustomLog directive (see below).
# If you are behind a reverse proxy, you might want to change %h into %{X-Forwarded-For}i
#
LogFormat \"%v:%p %h %l %u %t \\\"%r\\\" %>s %O \\\"%{Referer}i\\\" \\\"%{User-Agent}i\\\"\" vhost_combined
LogFormat \"%h %l %u %t \\\"%r\\\" %>s %O \\\"%{Referer}i\\\" \\\"%{User-Agent}i\\\"\" combined
LogFormat \"%h %l %u %t \\\"%r\\\" %>s %O\" common
LogFormat \"%{Referer}i -> %U\" referer
LogFormat \"%{User-agent}i\" agent

# Include of directories ignores editors' and dpkg's backup files,
# see README.Debian for details.

# Include generic snippets of statements
Include conf.d/

# Include the virtual host configurations:
Include sites-enabled/" > /etc/apache2/apache2.conf.nuevo
	fi
	sudo mv -f /etc/apache2/apache2.conf.nuevo /etc/apache2/apache2.conf
fi

if [ -f "/etc/apache2/httpd.conf.anterior" ]; then
	if [ "$esGNewSense" == "1" ]; then
		if [ "$modJk" == "1" ]; then
			echo "ServerName $ipApache
LoadModule jk_module /usr/lib/apache2/modules/mod_jk.so
JkWorkersFile /etc/libapache2-mod-jk/workers.properties
JkLogFile logs/mod_jk.log
JkLogLevel error
JkLogStampFormat \"[%a %b %d %H:%M:%S %Y]\"
JkOptions +ForwardKeySize +ForwardURICompatUnparsed -ForwardDirectories
JkRequestLogFormat \"%w %V %T\"
JkMount /$project/* loadbalancer
JkUnMount /$project/images/* loadbalancer
JkMountFile conf/uriworkermap.properties
JkShmFile run/jk.shm
<Location /jkstatus>
	JkMount status
	Order deny,allow
	Deny from all
	Allow from $ipApache
</Location>" > /etc/apache2/httpd.conf.nuevo
		else
			if [ "$instancias" -ge "1" ]; then
				textoWorkers1="	BalancerMember ajp://$ipInstancia1:$puertoInstancia1 route=worker1"
			fi
			if [ "$instancias" -ge "2" ]; then
				textoWorkers2="	BalancerMember ajp://$ipInstancia2:$puertoInstancia2 route=worker2"
			fi
			if [ "$instancias" == "3" ]; then
				textoWorkers3="	BalancerMember ajp://$ipInstancia3:$puertoInstancia3 route=worker3"
			fi
			echo "ServerName $ipApache
#LoadModule proxy_module /usr/lib/apache2/modules/mod_proxy.so
#LoadModule proxy_ajp_module /usr/lib/apache2/modules/mod_proxy_ajp.so
#LoadModule proxy_balancer_module /usr/lib/apache2/modules/mod_proxy_balancer.so
#LoadModule status_module /usr/lib/apache2/modules/mod_status.so
<Location /balancer-manager>
	SetHandler balancer-manager
</Location>
<Proxy balancer://ajpCluster>
	$textoWorkers1
	$textoWorkers2
	$textoWorkers3
</Proxy>
<Location /qinweb>
	ProxyPass /APP balancer://ajpCluster/qinweb stickysession=JSESSIONID
	#ProxyPassReverse /APP balancer://ajpCluster/qinweb
</Location>" > /etc/apache2/httpd.conf.nuevo
		fi
	else
		if [ "$modJk" == "1" ]; then
			echo "ServerName $ipApache" > /etc/apache2/httpd.conf.nuevo
		else
			if [ "$instancias" -ge "1" ]; then
				textoWorkers1="	BalancerMember ajp://$ipInstancia1:$puertoInstancia1 route=worker1"
			fi
			if [ "$instancias" -ge "2" ]; then
				textoWorkers2="	BalancerMember ajp://$ipInstancia2:$puertoInstancia2 route=worker2"
			fi
			if [ "$instancias" == "3" ]; then
				textoWorkers3="	BalancerMember ajp://$ipInstancia3:$puertoInstancia3 route=worker3"
			fi
			echo "ServerName $ipApache
#LoadModule proxy_module /usr/lib/apache2/modules/mod_proxy.so
#LoadModule proxy_ajp_module /usr/lib/apache2/modules/mod_proxy_ajp.so
#LoadModule proxy_balancer_module /usr/lib/apache2/modules/mod_proxy_balancer.so
#LoadModule status_module /usr/lib/apache2/modules/mod_status.so
<Location /balancer-manager>
	SetHandler balancer-manager
</Location>
<Proxy balancer://ajpCluster>
	$textoWorkers1
	$textoWorkers2
	$textoWorkers3
</Proxy>
<Location /qinweb>
	ProxyPass balancer://ajpCluster/qinweb stickysession=JSESSIONID
	#ProxyPassReverse /APP balancer://ajpCluster/qinweb
</Location>" > /etc/apache2/httpd.conf.nuevo
		fi
	fi
	sudo mv -f /etc/apache2/httpd.conf.nuevo /etc/apache2/httpd.conf
fi
# <VirtualHost *:80>
# 	ServerName $ip
# 	# Send servlet for context / jsp-examples to worker named domain1
# 	JkMount / loadbalancer
# 	# Send JSPs for context /jsp-examples/* to worker named domain1
# 	JkMount /* loadbalancer
# </VirtualHost>" > /etc/apache2/httpd.conf.nuevo
# Include conf/mod_jk.conf

if [ "$modJk" == "0" ]; then
	if [ -f "/etc/apache2/mods-available/status.conf.anterior" ]; then
		echo "<IfModule mod_status.c>
# Allow server status reports generated by mod_status,
# with the URL of http://servername/server-status
# Uncomment and change the \"192.0.2.0/24\" to allow access from other hosts.
	<Location /server-status>
		SetHandler server-status
		Order deny,allow
		Deny from all
		Allow from $ipApache
		Satisfy all
	</Location>
	# Keep track of extended status information for each request
	ExtendedStatus On
	# Determine if mod_status displays the first 63 characters of a request or
	# the last 63, assuming the request itself is greater than 63 chars.
	# Default: Off
	#SeeRequestTail On
	<IfModule mod_proxy.c>
		# Show Proxy LoadBalancer status in mod_status
		ProxyStatus On
	</IfModule>
</IfModule>" > /etc/apache2/mods-available/status.conf
	fi
	if [ -f "/etc/apache2/mods-available/proxy_balancer.conf.anterior" ]; then
		echo "
<IfModule mod_proxy_balancer.c>
# Balancer manager enables dynamic update of balancer members
# (needs mod_status). Uncomment to enable.
	<IfModule mod_status.c>
		<Location /balancer-manager>
			SetHandler balancer-manager
			Order deny,allow
			Deny from all
			Allow from $ipApache
			Satisfy all
		</Location>
	</IfModule>
</IfModule>
" > /etc/apache2/mods-available/proxy_balancer.conf
	fi
fi

if [ "$modJk" == "1" ]; then
	if [ -f "/etc/libapache2-mod-jk/workers.properties.anterior" ]; then
		if [ "$esGNewSense" == "1" ]; then
			if [ "$instancias" == "1" ]; then
				#echo "worker.list=loadbalancer,status
				echo "worker.list=loadbalancer
worker.worker1.port=$puertoInstancia1
worker.worker1.host=$ipInstancia1
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker1.ping_mode=A #As of mod_jk 1.2.27
#worker.worker2.port=$puertoInstancia2
#worker.worker2.host=$ipInstancia2
#worker.worker2.type=ajp13
#worker.worker2.lbfactor=1
#worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
#worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker2.ping_mode=A #As of mod_jk 1.2.27
#worker.worker3.port=$puertoInstancia3
#worker.worker3.host=$ipInstancia3
#worker.worker3.type=ajp13
#worker.worker3.lbfactor=1
#worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
#worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
#worker.loadbalancer.balance_workers=worker1,worker2,worker3
#worker.loadbalancer.balance_workers=worker1,worker2
worker.loadbalancer.balance_workers=worker1
worker.loadbalancer.sticky_session=$sticky_session
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
			fi
			if [ "$instancias" == "2" ]; then
				#echo "worker.list=loadbalancer,status
				echo "worker.list=loadbalancer
worker.worker1.port=$puertoInstancia1
worker.worker1.host=$ipInstancia1
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=$puertoInstancia2
worker.worker2.host=$ipInstancia2
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker2.ping_mode=A #As of mod_jk 1.2.27
#worker.worker3.port=$puertoInstancia3
#worker.worker3.host=$ipInstancia3
#worker.worker3.type=ajp13
#worker.worker3.lbfactor=1
#worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
#worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
#worker.loadbalancer.balance_workers=worker1,worker2,worker3
worker.loadbalancer.balance_workers=worker1,worker2
#worker.loadbalancer.balance_workers=worker1
worker.loadbalancer.sticky_session=$sticky_session
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
			fi
			if [ "$instancias" == "3" ]; then
				#echo "worker.list=loadbalancer,status
				echo "worker.list=loadbalancer
worker.worker1.port=$puertoInstancia1
worker.worker1.host=$ipInstancia1
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=$puertoInstancia2
worker.worker2.host=$ipInstancia2
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker2.ping_mode=A #As of mod_jk 1.2.27
worker.worker3.port=$puertoInstancia
worker.worker3.host=$ipInstancia3
worker.worker3.type=ajp13
worker.worker3.lbfactor=1
worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
# worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
worker.loadbalancer.balance_workers=worker1,worker2,worker3
#worker.loadbalancer.balance_workers=worker1,worker2
#worker.loadbalancer.balance_workers=worker1
worker.loadbalancer.sticky_session=$sticky_session
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
			fi
		else
			if [ "$instancias" == "1" ]; then
				#echo "worker.list=loadbalancer,status
				echo "worker.list=loadbalancer
worker.worker1.port=$puertoInstancia1
worker.worker1.host=$ipInstancia1
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker1.ping_mode=A #As of mod_jk 1.2.27
#worker.worker2.port=$puertoInstancia2
#worker.worker2.host=$ipInstancia2
#worker.worker2.type=ajp13
#worker.worker2.lbfactor=1
#worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
#worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
#worker.worker2.ping_mode=A #As of mod_jk 1.2.27
#worker.worker3.port=$puertoInstancia3
#worker.worker3.host=$ipInstancia3
#worker.worker3.type=ajp13
#worker.worker3.lbfactor=1
#worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
#worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
#worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
#worker.loadbalancer.balance_workers=worker1,worker2,worker3
#worker.loadbalancer.balance_workers=worker1,worker2
worker.loadbalancer.balance_workers=worker1
worker.loadbalancer.sticky_session=$sticky_session
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
			fi
			if [ "$instancias" == "2" ]; then
				#echo "worker.list=loadbalancer,status
				echo "worker.list=loadbalancer
worker.worker1.port=$puertoInstancia1
worker.worker1.host=$ipInstancia1
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=$puertoInstancia2
worker.worker2.host=$ipInstancia2
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker2.ping_mode=A #As of mod_jk 1.2.27
#worker.worker3.port=$puertoInstancia3
#worker.worker3.host=$ipInstancia3
#worker.worker3.type=ajp13
#worker.worker3.lbfactor=1
#worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
#worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
#worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
#worker.loadbalancer.balance_workers=worker1,worker2,worker3
worker.loadbalancer.balance_workers=worker1,worker2
#worker.loadbalancer.balance_workers=worker1
worker.loadbalancer.sticky_session=$sticky_session
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
			fi
			if [ "$instancias" == "3" ]; then
				#echo "worker.list=loadbalancer,status
				echo "worker.list=loadbalancer
worker.worker1.port=$puertoInstancia1
worker.worker1.host=$ipInstancia1
worker.worker1.type=ajp13
worker.worker1.lbfactor=1
worker.worker1.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker1.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker1.ping_mode=A #As of mod_jk 1.2.27
worker.worker2.port=$puertoInstancia2
worker.worker2.host=$ipInstancia2
worker.worker2.type=ajp13
worker.worker2.lbfactor=1
worker.worker2.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker2.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker2.ping_mode=A #As of mod_jk 1.2.27
worker.worker3.port=$puertoInstancia3
worker.worker3.host=$ipInstancia3
worker.worker3.type=ajp13
worker.worker3.lbfactor=1
worker.worker3.prepost_timeout=10000 #Not required if using ping_mode=A
worker.worker3.connect_timeout=10000 #Not required if using ping_mode=A
worker.worker3.ping_mode=A #As of mod_jk 1.2.27
worker.loadbalancer.type=lb
worker.loadbalancer.balance_workers=worker1,worker2,worker3
#worker.loadbalancer.balance_workers=worker1,worker2
#worker.loadbalancer.balance_workers=worker1
worker.loadbalancer.sticky_session=$sticky_session
worker.status.type=status" > /etc/libapache2-mod-jk/workers.properties.nuevo
			fi
		fi
		sudo mv -f /etc/libapache2-mod-jk/workers.properties.nuevo /etc/libapache2-mod-jk/workers.properties
	fi
	echo "/jmx-console=loadbalancer
/jmx-console/*=loadbalancer
/web-console=loadbalancer
/web-console/*=loadbalancer
/admin-console=loadbalancer
/admin-console/*=loadbalancer
/$project=loadbalancer
/$project/*=loadbalancer
$project=loadbalancer" > /etc/apache2/conf/uriworkermap.properties.nuevo
	sudo mv -f /etc/apache2/conf/uriworkermap.properties.nuevo /etc/apache2/conf/uriworkermap.properties
	if [ -f "/etc/apache2/mods-available/jk.conf.anterior" ]; then
		if [ "$esGNewSense" != "1" ]; then
			echo "JkWorkersFile /etc/libapache2-mod-jk/workers.properties
JkLogFile logs/mod_jk.log
JkLogLevel error
JkLogStampFormat \"[%a %b %d %H:%M:%S %Y]\"
JkOptions +ForwardKeySize +ForwardURICompatUnparsed -ForwardDirectories
JkRequestLogFormat \"%w %V %T\"
JkMount /$project/* loadbalancer
JkUnMount /$project/images/* loadbalancer
JkMountFile conf/uriworkermap.properties
JkShmFile run/jk.shm
<Location /jkstatus>
	JkMount status
	Order deny,allow
	Deny from all
	Allow from $ipApache
</Location>" > /etc/apache2/mods-available/jk.conf.nuevo
			sudo mv -f /etc/apache2/mods-available/jk.conf.nuevo /etc/apache2/mods-available/jk.conf
		fi
	fi
	if [ -f "/etc/apache2/sites-available/default.anterior" ]; then
		if [ "$esGNewSense" == "1" ]; then
			echo "<VirtualHost *:80>
	ServerAdmin webmaster@localhost

	ServerName $ipApache
	# Send servlet for context / jsp-examples to worker named domain1
	JkMount / loadbalancer
	# Send JSPs for context /jsp-examples/* to worker named domain1
	JkMount /* loadbalancer

	DocumentRoot /var/www/
	<Directory />
		Options FollowSymLinks
		AllowOverride None
	</Directory>
	<Directory /var/www/>
		Options Indexes FollowSymLinks MultiViews
		AllowOverride None
		Order allow,deny
		allow from all
	</Directory>

	ScriptAlias /cgi-bin/ /usr/lib/cgi-bin/
	<Directory \"/usr/lib/cgi-bin\">
		AllowOverride None
		Options +ExecCGI -MultiViews +SymLinksIfOwnerMatch
		Order allow,deny
		Allow from all
	</Directory>

	ErrorLog \${APACHE_LOG_DIR}/error.log

	# Possible values include: debug, info, notice, warn, error, crit,
	# alert, emerg.
	LogLevel error

	CustomLog \${APACHE_LOG_DIR}/access.log combined
	ServerSignature On

	Alias /doc/ \"/usr/share/doc/\"
	<Directory \"/usr/share/doc/\">
		Options Indexes MultiViews FollowSymLinks
		AllowOverride None
		Order deny,allow
		Deny from all
		Allow from 127.0.0.0/255.0.0.0 ::1/128
	</Directory>

</VirtualHost>" > /etc/apache2/sites-available/default.nuevo
			sudo mv -f /etc/apache2/sites-available/default.nuevo /etc/apache2/sites-available/default
		else
			echo "<VirtualHost *:80>
	ServerAdmin webmaster@localhost

	ServerName $ipApache
	# Send servlet for context / jsp-examples to worker named domain1
	JkMount / loadbalancer
	# Send JSPs for context /jsp-examples/* to worker named domain1
	JkMount /* loadbalancer

	DocumentRoot /var/www
	<Directory />
		Options FollowSymLinks
		AllowOverride None
	</Directory>
	<Directory /var/www/>
		Options Indexes FollowSymLinks MultiViews
		AllowOverride None
		Order allow,deny
		allow from all
	</Directory>

	ScriptAlias /cgi-bin/ /usr/lib/cgi-bin/
	<Directory \"/usr/lib/cgi-bin\">
		AllowOverride None
		Options +ExecCGI -MultiViews +SymLinksIfOwnerMatch
		Order allow,deny
		Allow from all
	</Directory>

	ErrorLog \${APACHE_LOG_DIR}/error.log

	# Possible values include: debug, info, notice, warn, error, crit,
	# alert, emerg.
	LogLevel error

	CustomLog \${APACHE_LOG_DIR}/access.log combined

	Alias /doc/ \"/usr/share/doc/\"
	<Directory \"/usr/share/doc/\">
		Options Indexes MultiViews FollowSymLinks
		AllowOverride None
		Order deny,allow
		Deny from all
		Allow from 127.0.0.0/255.0.0.0 ::1/128
</Directory>

</VirtualHost>" > /etc/apache2/sites-available/default.nuevo
			sudo mv -f /etc/apache2/sites-available/default.nuevo /etc/apache2/sites-available/default
		fi
	fi
fi

source "$posicion"/manejarPermisos.sh
