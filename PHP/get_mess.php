<?php

require_once '/home/a8532754/public_html/db_connect.php';
$obj=new DB_CONNECT();
$conn=$obj -> connect();

$query="select MESS_NAME,ADDRESS,AREA from a8532754_mess.MESS";
$result = $conn ->query($query) or die(mysql_error());


$arr = array();
$i=0;

while($row = $result ->fetch_array(MYSQLI_NUM))
{
$arr[$i]=$row[0];
$i++;
}

echo json_encode($arr);
?>

