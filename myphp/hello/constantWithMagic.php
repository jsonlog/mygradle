<?php
namespace MyProject;
 
echo '命名空间为："', __NAMESPACE__, '"'; // 输出 "MyProject"
?>


<?php
echo '这是第 " '  . __LINE__ . ' " 行';
?>

<?php
echo '该文件位于 " '  . __FILE__ . ' " ';
?>

<?php
echo '该文件位于 " '  . __DIR__ . ' " ';
?>

<?php
function test() {
    echo  '函数名为：' . __FUNCTION__ ;
}
test();
?>

<?php
class test {
    function _print() {
        echo '类名为：'  . __CLASS__ . "<br>";
        echo  '函数名为：' . __FUNCTION__ ;
    }
}
$t = new test();
$t->_print();
?>

<?php
class Base {
    public function sayHello() {
        echo 'Hello ';
    }
}
 
trait SayWorld {
    public function sayHello() {
        parent::sayHello();
        echo 'World!';
    }
}
 
class MyHelloWorld extends Base {
    use SayWorld;
}
 
$o = new MyHelloWorld();
$o->sayHello();
?>

<?php
function test2() {
    echo  '函数名为：' . __METHOD__ ;
}
test2();
?>