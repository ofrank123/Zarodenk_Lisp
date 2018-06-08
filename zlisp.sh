#!/bin/bash

if [ "$1" == '' ]; then
    echo 'error: no file provided'
    exit 1
fi
    
#print the file
echo "========================================="
echo "          FILE TO BE EVALUATED           "
echo "========================================="
echo ""
cat "$1"
echo ""
echo ""
echo "========================================="
echo "             EVALUATED LISP              "
echo "========================================="
echo ""
cd dist
java -jar Zarodenk_Lisp.jar "../$1"
