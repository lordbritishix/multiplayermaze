#!/bin/bash
#rm -rf ../common/src/main/java/com/quitevis/mazeserver/api/generated
#mkdir ../common/src/main/java/com/quitevis/mazeserver/api/generated

protoc --java_out=../common/src/main/java/ MazeServerApi.proto

