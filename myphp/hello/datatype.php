<?php 
$x = "Hello world!";
echo $x;
echo "<br>"; 
$x = 'Hello world!';
echo $x;
?>

<?php 
echo "<br>";
echo "<br>";
$x = 5985;
var_dump($x);
echo "<br>"; 
$x = -345; // 负数 
var_dump($x);
echo "<br>"; 
$x = 0x8C; // 十六进制数
var_dump($x);
echo "<br>";
$x = 047; // 八进制数
var_dump($x);
?>

<?php 
echo "<br>";
echo "<br>";
$x = 10.365;
var_dump($x);
echo "<br>"; 
$x = 2.4e3;
var_dump($x);
echo "<br>"; 
$x = 8E-5;
var_dump($x);
?>

<?php 
echo "<br>";
echo "<br>";
$cars=array("Volvo","BMW","Toyota");
var_dump($cars);
?>

<?php
class Car
{
  var $color;
  function __construct($color="green") {
    $this->color = $color;
  }
  function what_color() {
    return $this->color;
  }
}
?>

<?php
echo "<br>";
echo "<br>";
$x="Hello world!";
$x=null;
var_dump($x);
?>
