#!/bin/bash
if [ -d myshell ];then
    cd myshell
else
    pwd;
fi
ls -l
# for((i = 1;i < 10; i++));do
# 	mkdir "_00"$i
# done
common(){
    # read name
    # make -j64 2>&1 | tee b.log;
    varlet="qinjx"
    echo $varlet
    echo ${#varlet} It is a test #length
    a=5
    b=6
    result=$[a+b] # 注意等号两边不能有空格
    echo "result 为： $result"
    echo -n `expr $a + $b` #不换行
    echo -e "OK! \c" # -e 开启转义 \c不换行
    echo '$name\"' # 不转义
    echo `date`
    

    delete=a1
    # 命名只能使用英文字母，数字和下划线，首个字符不能以数字开头
    printf "%b %s\n" true $delete;
    unset delete
    printf "\ddd \0ddd \n" 012 0x127 #八进制 十六进制
    printf %s abc def
    printf "警告字符，通常为ASCII的BEL字符\a后退 \\ \b换页\f回车\r水平制表符\t垂直制表符\v \n"
    # -8s 指一个宽度为8个字符 -表示左对齐，没有则表示右对齐 
    printf "%-10s %-8s %-4s\n" 姓名 性别 体重kg  
    printf "%-10s %-8s %-4.2f\n" 郭靖 男 66.1234 
    printf "%-10s %-8s %-4.2f\n" 杨过 男 48.6543

    # myUrl="http://www.google.com"
    # readonly myUrl
    # myUrl="https://github.com/jsonlog"

    your_name='robot'
    str="Hello, I know you are \"${your_name}\"! \n"
    echo -e $str
    
    str='this is a string'
    greeting_2='hello, '$your_name' !'
    echo $greeting_2

    string="robot is a great site"
    echo ${string:1:4}
    # echo `expr index "$string" io`

    array_name=(value0 value1 value2 value3)
        echo ${array_name[@]}
    array_name[0]=value0
    array_name[1]=value01
    array_name[n]=value00n
        echo ${array_name[n]} ${#array_name[@]} ${#array_name[*]} ${#array_name[1]} # length

    # :<<EOF
    # 注释内容...
    # EOF

    # :<<'
    # 注释内容...
    # 注释内容...
    # '

    # :<<!
    # 注释内容...
    # 注释内容...
    # !

    echo $0
    if [ -n "$1" ]; then
        echo "包含第一个参数"
    else
        echo "没有包含第一参数"
    fi
    echo "参数个数为：$#";
    echo "传递的参数作为一个字符串显示：$*";
    echo "-- \$* 演示 ---"
    for i in "$*"; do
        echo $i
    done

    echo "-- \$@ 演示 ---在引号中返回每个参数"
    for i in "$@"; do
        echo $i
    done
    echo "脚本运行的当前进程ID号 $$"
    echo "后台运行的最后一个进程的ID号 $!"
    echo "显示最后命令的退出状态 $?"

}
function operator(){
    val=`expr 2 + 2`
    echo "两数之和为 : $val"

    a=10
    b=20

    val=`expr $a + $b`
    echo "a + b : $val"

    val=`expr $a - $b`
    echo "a - b : $val"

    val=`expr $a \* $b`
    echo "a * b : $val"

    val=`expr $b / $a`
    echo "b / a : $val"

    val=`expr $b % $a`
    echo "b % a : $val"

    if [ $a == $b ]
    then
    echo "a 等于 b"
    fi
    if [ $a != $b ]
    then
    echo "a 不等于 b"
    fi

if [ $a -eq $b ]
then
   echo "$a -eq $b : a 等于 b"
else
   echo "$a -eq $b: a 不等于 b"
fi
if [ $a -ne $b ]
then
   echo "$a -ne $b: a 不等于 b"
else
   echo "$a -ne $b : a 等于 b"
fi
if [ $a -gt $b ]
then
   echo "$a -gt $b: a 大于 b"
else
   echo "$a -gt $b: a 不大于 b"
fi
if [ $a -lt $b ]
then
   echo "$a -lt $b: a 小于 b"
else
   echo "$a -lt $b: a 不小于 b"
fi
if [ $a -ge $b ]
then
   echo "$a -ge $b: a 大于或等于 b"
else
   echo "$a -ge $b: a 小于 b"
fi
if [ $a -le $b ]
then
   echo "$a -le $b: a 小于或等于 b"
else
   echo "$a -le $b: a 大于 b"
fi

if [ $a != $b ]
then
   echo "$a != $b : a 不等于 b"
else
   echo "$a == $b: a 等于 b"
fi
if [ $a -lt 100 -a $b -gt 15 ]
then
   echo "$a 小于 100 且 $b 大于 15 : 返回 true"
else
   echo "$a 小于 100 且 $b 大于 15 : 返回 false"
fi
if [ $a -lt 100 -o $b -gt 100 ]
then
   echo "$a 小于 100 或 $b 大于 100 : 返回 true"
else
   echo "$a 小于 100 或 $b 大于 100 : 返回 false"
fi
if [ $a -lt 5 -o $b -gt 100 ]
then
   echo "$a 小于 5 或 $b 大于 100 : 返回 true"
else
   echo "$a 小于 5 或 $b 大于 100 : 返回 false"
fi

if [[ $a -lt 100 && $b -gt 100 ]]
then
   echo "返回 true"
else
   echo "返回 false"
fi

if [[ $a -lt 100 || $b -gt 100 ]]
then
   echo "返回 true"
else
   echo "返回 false"
fi

a="abc"
b="efg"

if [ $a = $b ]
then
   echo "$a = $b : a 等于 b"
else
   echo "$a = $b: a 不等于 b"
fi
if [ $a != $b ]
then
   echo "$a != $b : a 不等于 b"
else
   echo "$a != $b: a 等于 b"
fi
if [ -z $a ]
then
   echo "-z $a : 字符串长度为 0"
else
   echo "-z $a : 字符串长度不为 0"
fi
if [ -n "$a" ]
then
   echo "-n $a : 字符串长度不为 0"
else
   echo "-n $a : 字符串长度为 0"
fi
if [ $a ]
then
   echo "$a : 字符串不为空"
else
   echo "$a : 字符串为空"
fi

}
readfile(){
    file="build.gradle"
if [ -r $file ]
then
   echo "文件可读"
else
   echo "文件不可读"
fi
if [ -w $file ]
then
   echo "文件可写"
else
   echo "文件不可写"
fi
if [ -x $file ]
then
   echo "文件可执行"
else
   echo "文件不可执行"
fi
if [ -f $file ]
then
   echo "文件为普通文件"
else
   echo "文件为特殊文件"
fi
if [ -d $file ]
then
   echo "文件是个目录"
else
   echo "文件不是个目录"
fi
if [ -s $file ]
then
   echo "文件不为空"
else
   echo "文件为空"
fi
if [ -e $file ]
then
   echo "文件存在"
else
   echo "文件不存在"
fi
}
test(){
    num1=100
    num2=100
    if test $[num1] -eq $[num2]
    then
        echo '两个数相等！'
    else
        echo '两个数不相等！'
    fi

    num1="ru1noob"
    num2="runoob"
    if test $num1 = $num2
    then
        echo '两个字符串相等!'
    else
        echo '两个字符串不相等!'
    fi

    if test -e ./shell.sh
    then
        echo '文件已存在!'
    else
        echo '文件不存在!'
    fi

    #与( -a )、或( -o )、非( ! )
    if test -e ./notFile -o -e ./bash
    then
        echo '至少有一个文件存在!'
    else
        echo '两个文件都不存在'
    fi
}
myfunction(){
    if [ $(ps -ef | grep -c "net") -gt 1 ]; then echo "true"; fi

    for loop in 1 2 3 4 5
    do
        echo "The value is: $loop"
    done

    for str in 'This is a string'
    do
        echo "$str ,"
    done

    int=1
    while(( $int<=5 ))
    do
        echo $int
        let "int++" # 用于执行一个或多个表达式
    done

    # echo '按下 <CTRL-D> 退出'
    # echo -n '输入你最喜欢的网站名: '
    # while read FILM
    # do
    #     echo "是的！$FILM 是一个好网站"
    # done

    a=0
    until [ ! $a -lt 10 ]
    do
        echo -n $a
        a=`expr $a + 1`
    done

    aNum=2
    case $aNum in
        1)  echo '你选择了 1'
        ;;
        2)  echo '你选择了 2'
        ;;
        3)  echo '你选择了 3' # )
        ;;
        4)  echo '你选择了 4'
        ;;
        *)  echo '你没有输入 1 到 4 之间的数字'
        ;; # break
    esac

    # while :
    # do
    #     echo -n "输入 1 到 5 之间的数字: "
    #     read aNum
    #     case $aNum in
    #         1|2|3|4|5) echo "你输入的数字为 $aNum!"
    #         ;;
    #         *) echo "你输入的数字不是 1 到 5 之间的!"
    #             continue
    #             echo "游戏结束"
    #         ;;
    #     esac
    # done

    for((i=1;i<=5;i++));do
        echo "这是第 $i 次调用";
    done;

    # command1 < infile > outfile
    # command > file 2>&1 # 0stdin 1stdout 2stderr
    #  command 2 >> file # 追加

    # wc -l << EOF
    #     欢迎来到
    #     菜鸟教程
    #     www.runoob.com
    # EOF

    # command > /dev/null 2>&1 # 禁止输出
}
# common
# operator
# readfile
# test # TODO
myfunction

if [ ! -d myshell ];then
    cd ..
elif [ -d myshell] || [ -f test ];then # &&
    ls -l;
fi