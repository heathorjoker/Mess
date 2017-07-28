<?php
require_once '/home/a8532754/public_html/db_connect.php';
$obj=new DB_CONNECT();
$conn=$obj -> connect();

$sql1="Insert into PASSWD(MESS_ID,PASSWD) values(1,'pass')";
$sql2="Insert into OWNER values(1,'omkar',9404516,1)";
$sql3="INSERT into MESS values(1,'just for you','parbhani','katraj')";
$sql4="Insert into MENU values(1,'dal,roti')";

$conn ->query($sql1);
$conn ->query($sql2);
$conn ->query($sql3);
$conn ->query($sql4);
?>
