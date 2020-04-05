#!/bin/sh


if [[ "$*" = *"-b"* ]]  || [[ "$*" = *"--build"* ]]
    then
          mvn clean install
fi

mvn spring-boot:run
