<?php
$cars=array("Volvo","BMW","Toyota");
echo "I like " . $cars[0] . ", " . $cars[1] . " and " . $cars[2] . ".";
echo count($cars);
?>

<?php
$cars=array("Volvo","BMW","Toyota");
$arrlength=count($cars);
 
for($x=0;$x<$arrlength;$x++)
{
    echo $cars[$x];
    echo "<br>";
}
?>

<?php
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
echo "Peter is " . $age['Peter'] . " years old.";
?>

<?php
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
 
foreach($age as $x=>$x_value)
{
    echo "Key=" . $x . ", Value=" . $x_value;
    echo "<br>";
}
?>

<?php
$cars=array("Volvo","BMW","Toyota");
sort($cars);
?>

<?php
$numbers=array(4,6,2,22,11);
sort($numbers);
?>

<?php
$cars=array("Volvo","BMW","Toyota");
rsort($cars);//降序 reduce
?>

<?php
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
asort($age);//值 
?>

<?php
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
ksort($age);//键 key
?>

<?php
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
arsort($age);//值 r降
?>

<?php
$age=array("Peter"=>"35","Ben"=>"37","Joe"=>"43");
krsort($age);//键 r降
?>