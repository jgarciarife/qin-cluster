#!/bin/bash

echo "resetearProcesador.sh"

posicion="$PWD"

echo ondemand > /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor
echo ondemand > /sys/devices/system/cpu/cpu1/cpufreq/scaling_governor
echo ondemand > /sys/devices/system/cpu/cpu2/cpufreq/scaling_governor
echo ondemand > /sys/devices/system/cpu/cpu3/cpufreq/scaling_governor

nucleo0=`more /sys/devices/system/cpu/cpu0/cpufreq/scaling_governor`
nucleo1=`more /sys/devices/system/cpu/cpu1/cpufreq/scaling_governor`
nucleo2=`more /sys/devices/system/cpu/cpu2/cpufreq/scaling_governor`
nucleo3=`more /sys/devices/system/cpu/cpu3/cpufreq/scaling_governor`
frecuencias=`more /proc/cpuinfo | grep MHz`

echo "Esperando a que los núcleos tomen los cambios..."
sleep 30
echo "Núcleo 0: $nucleo0"
echo "Núcleo 1: $nucleo1"
echo "Núcleo 2: $nucleo2"
echo "Núcleo 3: $nucleo3"
echo "Frecuencias: $frecuencias"
