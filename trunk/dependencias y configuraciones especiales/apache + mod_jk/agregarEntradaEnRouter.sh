#!/bin/bash

echo "agregarEntradaEnRouter.sh"

sudo route add -net 224.0.0.0/4 dev eth0 2> /dev/null
sudo route add -net 224.0.0.0/4 dev eth1 2> /dev/null
sudo route add -net 224.0.0.0/4 dev eth2 2> /dev/null
