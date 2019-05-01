#!/bin/bash
# 添加这句以防子进程被杀掉
MY_PROCESS=`which java`
echo "MY_PROCESS:$MY_PROCESS"
export JENKINS_NODE_COOKIE=${MY_PROCESS}
export BUILD_ID=${MY_PROCESS}
echo 'install'
mvn jar:jar install:install help:evaluate -Dexpression=project.name

echo 'get name'
NAME=`mvn help:evaluate -Dexpression=project.name | grep "^[^\[]"`
if [[ -n "$NAME" ]];then
    echo "name:$NAME"
else
    echo "name not found"
    exit 1
fi

echo 'get version'
VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`
if [[ -n "$VERSION" ]];then
    echo "version:$VERSION"
else
    echo "version not found"
    exit 2
fi

echo 'copy ibk.jar'
echo `pwd`
cp target/${NAME}-${VERSION}.jar /usr/local/${NAME}.jar
chmod +x /usr/local/${NAME}.jar

if [[ -f "/usr/local/$NAME.jar" ]];then
    echo "stop Application"
    echo `ps -ef | grep ${NAME}`
    echo `ps -ef | grep ${NAME} | grep -v grep`
    echo `ps -ef | grep ${NAME} | grep -v grep | awk '{print $2}'`
    pid=`ps -ef | grep ${NAME} | grep -v grep | awk '{print $2}'`
    echo "pid：$pid"
    if [[ -n "$pid" ]];then
        kill -9 ${pid}
    fi

    echo "start Application"
    echo "$(date "+%Y-%m-%d %H:%M:%S") start Application" >> /var/log/${NAME}.log
    nohup java -jar /usr/local/${NAME}.jar >> /var/log/${NAME}.log &
    sleep 2
    echo 'deploy finish'
else
    echo "${NAME}.jar not found"
    exit 3
fi