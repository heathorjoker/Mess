<?php
require_once '/home/a8532754/public_html/db_connect.php';
$obj=new DB_CONNECT();
$conn=$obj -> connect();

#checking if login info is correct
$Mid = $_POST["mess_id"];
$messid =((int)$Mid);
$pass = $_POST["passwd"];
$query = "select MESS_ID from a8532754_mess.PASSWD where MESS_ID = $messid AND PASSWD = '$pass' AND set_bit = 0";
$result=$conn -> query($query) or die(mysql_error());

if(mysqli_num_rows($result)>0)
{
$arr["id"]=$Mid;
echo json_encode($arr);
}
else
{
$arr["id"]="0";
echo json_encode($arr);
}


?>;
