#!/bin/bash
#make recursive javac easier
shopt -s globstar
#make a build directory (if there isn't one already)
mkdir -p build/
#compile the src
javac -d build -classpath build src/**/*.java
#compile the tests
javac -d build -classpath build tests/**/*.java
#print the file
echo "========================================="
echo "          FILE TO BE EVALUATED           "
echo "========================================="
echo ""
cat ZLispExamples/ex3.zli
echo ""
echo ""
echo "========================================="
echo "             EVALUATED LISP              "
echo "========================================="
echo ""
cd build
java EvalerTest
