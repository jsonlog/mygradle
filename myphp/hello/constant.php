<?php
// 区分大小写的常量名
define("GREETING", "欢迎访问 Runoob.com",true); //true case_insensitive
echo GREETING;    // 输出 "欢迎访问 Runoob.com"
echo '<br>';
echo greeting;   // 输出 "greeting"
?>

<?php
echo '<br>';
define("GREETING", "欢迎访问 Runoob.com");
 
function myTest() {
    echo GREETING;
}
 
myTest();    // 输出 "欢迎访问 Runoob.com"
?>