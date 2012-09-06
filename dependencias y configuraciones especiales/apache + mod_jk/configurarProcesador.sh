#!/bin/bash

echo "configurarProcesador.sh"

posicion="$PWD"

echo performance > /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor
echo performance > /sys/devices/system/cpu/cpu1/cpufreq/scaling_governor
echo performance > /sys/devices/system/cpu/cpu2/cpufreq/scaling_governor
echo performance > /sys/devices/system/cpu/cpu3/cpufreq/scaling_governor

nucleo0=`more /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor`
nucleo1=`more /sys/devices/system/cpu/cpu1/cpufreq/scaling_governor`
nucleo2=`more /sys/devices/system/cpu/cpu2/cpufreq/scaling_governor`
nucleo3=`more /sys/devices/system/cpu/cpu3/cpufreq/scaling_governor`

echo "Núcleo 0: $nucleo0"
echo "Núcleo 1: $nucleo1"
echo "Núcleo 2: $nucleo2"
echo "Núcleo 3: $nucleo3"
