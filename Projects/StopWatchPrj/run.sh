#!/bin/sh
cd src/project1
javac -d ../../bin StopWatch.java StopWatchDriver.java MyTimerPanel.java
cd ../../bin
java project1.StopWatchDriver
