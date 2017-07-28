<?php
require_once '/home/a8532754/public_html/db_connect.php';
$obj = new DB_CONNECT();
$conn =$obj ->connect();

#Getting the area
$area = $_POST["area"];

$query = "select MESS_ID,MESS_NAME from a8532754_mess.MESS where AREA='$area'";

$result = $conn ->query($query) or die(mysql_error());

$arr =array();

while($row = $result ->fetch_array(MYSQL_NUM))
{
 array_push($arr,array("messid" => $row[0],"name" => $row[1]));
	
}

echo json_encode($arr);
?>
