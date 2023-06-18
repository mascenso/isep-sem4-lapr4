#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=eCourse.app.bootstrap/target/app.bootstrap-0.1.0.jar:eCourse.app.bootstrap/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP shareboardHttpServer.SBPServer 8081
