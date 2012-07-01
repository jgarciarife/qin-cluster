#!/bin/bash

echo "instalarPaquetes.sh"

sudo apt-get update > /dev/null
sudo apt-get upgrade > /dev/null
sudo apt-get dist-upgrade > /dev/null
sudo apt-get autoremove -f > /dev/null
sudo dpkg --configure -a > /dev/null
echo "automake"
sudo apt-get install automake > /dev/null
echo "gcc"
sudo apt-get install gcc > /dev/null
echo "make"
sudo apt-get install make > /dev/null
echo "apache2"
sudo apt-get install apache2 > /dev/null
echo "apache2-mpm-worker"
sudo apt-get install apache2-mpm-worker > /dev/null
echo "apache2-utils"
sudo apt-get install apache2-utils > /dev/null
echo "libapr1-dev"
sudo apt-get install libapr1-dev > /dev/null
echo "libaprutil1-dev"
sudo apt-get install libaprutil1-dev > /dev/null
echo "libapache2-mod-jk"
sudo apt-get install libapache2-mod-jk > /dev/null
sudo apt-get update > /dev/null
sudo apt-get upgrade > /dev/null
sudo apt-get dist-upgrade > /dev/null
sudo apt-get autoremove -f > /dev/null
sudo dpkg --configure -a > /dev/null
