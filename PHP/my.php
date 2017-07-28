 <?php

define('DB_USER', "a8532754_root"); // db user
define('DB_PASSWORD', "mess123"); // db password (mention your db password here)
define('DB_SERVER', "mysql9.000webhost.com"); // db serve

$conn = new mysqli(DB_SERVER, DB_USER, DB_PASSWORD);

	if ($conn->connect_error) {
		    die("Connection failed: " . $conn->connect_error);
	}

#MESS information
 $name = $_POST['name'];
 $addr= $_POST['addr'];
 $area = $_POST['area'];

#owner information
 $owner = $_POST['owner'];
 $cont = $_POST['contact'];
 $contact=((int)$cont);

#Menu information
 $menu = $_POST["menu"];

#password 
 $pass = $_POST['passwd'];

#PASSWD TABLE REGISTRATION 
$sql = "INSERT INTO a8532754_mess.PASSWD". "(PASSWD) ". "VALUES('$pass')";
$status1=$conn -> query($sql) or die(mysql_error());

#GETTING MESS_ID
$sql2= "select MESS_ID from a8532754_mess.PASSWD where PASSWD='$pass'";
$res1= $conn -> query($sql2) or die(mysql_error());
$row=$res1 ->fetch_array(MYSQLI_NUM);
$mid = ((int)$row[0]);

#Inserting into owner table with taken mess_id
$sql3 = "INSERT INTO a8532754_mess.OWNER". "(MESS_ID,OWNER_NAME,CONTACT) ". "VALUES($mid,'$owner',$contact)";
$status2=$conn -> query($sql3);

#Inserting into MESS table with already taken mess_id
$sql4 = "INSERT INTO a8532754_mess.MESS". "(MESS_ID,MESS_NAME,ADDRESS,AREA) ". "VALUES($mid,'$name','$addr','$area')";
$status3=$conn -> query($sql4);

#Inserting into MENU table with already taken mess_id
$sql5="insert into a8532754_mess.MENU(MESS_ID,MENU) values($mid,'no menu yet')";
$status4=$conn -> query($sql5);

#check if all conditions satisfied and send appropriate message
if(($status1 and $status2) and ($status3 and $status4))
{
$string1 = "You have been successfully registered . . .";
$string2 ="MESS ID :".$mid;
$string3 ="You will be requiring the MESS ID for logging in,So we recommend you to Note it down or remember carefully";
$string4 ="Thanks for registering and Now you can login!!!";
}
else
{
$string1 ="You Registration didn't complete";
$string2= "We recommend you to reregister";
$string3= "Check your internet connection firstly";
$string4= "Thanks though!!!";
}
$arr["status"]=$string1;
$arr["messid"]=$string2;
$arr["reco"]=$string3;
$arr["thank"]=$string4;

echo json_encode($arr);
?> 
