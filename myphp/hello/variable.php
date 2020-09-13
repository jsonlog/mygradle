<?php
$txt="Hello world!";
$x=5;
$y=10.5;
?>

<?php
$x=5; // 全局变量

function myTest()
{
    $y=10; // 局部变量
    echo "<p>测试函数内变量:<p>";
    echo "变量 x 为: $x";
    echo "<br>";
    echo "变量 y 为: $y";
} 

myTest();

echo "<p>测试函数外变量:<p>";
echo "变量 x 为: $x";
echo "<br>";
echo "变量 y 为: $y";
?>

<?php
$x=5;
$y=10;
 
function myTest2()
{
    global $x,$y;
    $y=$x+$y;
}
 
myTest2();
echo "<br>";
echo $y; // 输出 15
?>

<?php
$x=5;
$y=10;
 
function myTest3()
{
    $GLOBALS['y']=$GLOBALS['x']+$GLOBALS['y'];
} 
 
myTest3();
echo $y;
?>

<?php
function myTest4()
{
    static $x=0;
    echo $x;
    $x++;
    echo PHP_EOL;    // 换行符
}
echo "<br>";
myTest4();
myTest4();
myTest4();
?>

<?php
function myTest5($x)
{
    echo $x;
}
myTest5(19);
?>