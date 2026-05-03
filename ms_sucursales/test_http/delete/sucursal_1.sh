#!/bin/bash

url='http://localhost:8080/api/v1/sucursales/1'

curl -v -X DELETE -H "Accept: application/json" $url
