<?php
require_once '/home/a8532754/public_html/db_connect.php';
$obj=new DB_CONNECT();
$conn=$obj -> connect();

#Getting the MESS ID and passing mess id to array
$Mid = $_POST["mess_id"];
$messid =((int)$Mid);
$arr["mess_id"]=$Mid;

#Getting result from owner table
$query = "select OWNER_NAME,CONTACT from a8532754_mess.OWNER where MESS_ID = $messid";
$result=$conn -> query($query) or die(mysql_error());
$row=$result ->fetch_array(MYSQLI_NUM);
$arr["owner_name"]=$row[0];
$arr["contact"]=$row[1];

#Getting result from MESSs table
$query = "select MESS_NAME,ADDRESS,AREA from a8532754_mess.MESS where MESS_ID = $messid";
$result=$conn -> query($query) or die(mysql_error());
$row=$result ->fetch_array(MYSQLI_NUM);
$arr["mname"]=$row[0];
$arr["addr"]=$row[1];
$arr["area"]=$row[2];




#sending array
echo json_encode($arr);

?>

