<?php

require_once '/home/a8532754/public_html/db_connect.php';
$obj=new DB_CONNECT();
$conn=$obj->connect();

$name=$_POST["name"];
$mid=$_POST["mid"];

$messid=((int)$mid);

$query="update a8532754_mess.OWNER set CONTACT= '$name' where MESS_ID = $messid ";
$conn->query($query);



?>
