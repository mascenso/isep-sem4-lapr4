#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export BASE_CP=eapli.base/base.app.bootstrap/target/base.app.bootstrap-0.1.0.jar:base.app.bootstrap/target/dependency/*;

#REM call the java VM, e.g,
java -cp $BASE_CP eapli.base.app.bootstrap.BaseBootstrap
