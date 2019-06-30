if [ -d myshell ];then
    cd myjava/src/main/java;
else
    cd ./../myjava/src/main/java;
fi

# cd com/util;
# javac hello.java staticClass.java
# java hello

javac com/util/hello.java
java com.util.hello

cd -;
