#!/bin/sh
cd src/project1
javac -d ../../bin StopWatch.java StopWatchDriver.java
cd ../../bin
java project1.StopWatchDriver
