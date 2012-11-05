#!/bin/bash

rm $HOME/.config/monitors.xml~
rm $HOME/.config/monitors.xml
rm $HOME/monitors.xml~
rm $HOME/monitors.xml
xrandr --output LVDS1 --auto --primary
xrandr --output VGA1 --auto --right-of LVDS1
