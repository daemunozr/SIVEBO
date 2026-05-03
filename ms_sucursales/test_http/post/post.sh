#!/bin/bash

url='http://localhost:8080/api/v1/sucursales'

curl -v $url --json @sucursal_1.json && echo
curl -v $url --json @sucursal_2.json && echo
