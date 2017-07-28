 <?php
$host= 	"mysql9.000webhost.com";
$user= 	"a8532754_root";
$passwd = "mess123";
$database ="a8532754_mess";

$conn = new mysqli($host, $user, $passwd);

if($conn->connect_error)
{
die();
}

$query="select * from a8532754_mess";
$result=$conn -> query($query);

while($row = $result->fetch_array(MYSQLI_NUM))
{
echo $row[0]."has passwd".$row[1];

}

$conn->close();
?>
