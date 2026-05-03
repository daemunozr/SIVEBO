#!/bin/bash

url='localhost:8080/api/v1/sucursales/comuna/1'

curl -v -I -H "Accept: application/json" $url
curl -s $url | jq '.' --tab
