#!/bin/bash

url='localhost:8080/api/v1/sucursales/buscar?nombre=providencia'

curl -v -I -H "Accept: application/json" $url
curl -s $url | jq '.' --tab
