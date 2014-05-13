#!/usr/bin/env bash
python3 xsdtocls/main.py $1 resources/spreadshirt.xsd ~/personal/tmp/dump
echo ''
python3 xsdtocls/main.py $1 resources/facebook.xsd ~/personal/tmp/dump
