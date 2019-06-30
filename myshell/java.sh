#!bin/sh
if [ -d myshell ];then
    cd myjava/src/main/java;
else
    cd ./../myjava/src/main/java;
fi

# cd com/util;
# javac hello.java staticClass.java
# java hello

if [ -n "$1" ];then
    echo $1
    javac com/util/MDtable.java
    java com.util.MDtable
else
    javac com/util/hello.java
    java com.util.hello
fi

cd -;
