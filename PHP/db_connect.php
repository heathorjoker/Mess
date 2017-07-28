<?php
 
/**
 * A class file to connect to database
 */
class DB_CONNECT {
 
    // constructor
    function __construct() {
        // connecting to database
        
    }
 
    // destructor
    function __destruct() {
        // closing db connection
        $this->close();
    }
 
    /**
     * Function to connect with database
     */
    function connect() {
        // import database connection variables
        require_once '/home/a8532754/public_html/db_config.php';
 
        // Connecting to mysql database
	$conn = new mysqli(DB_SERVER, DB_USER, DB_PASSWORD);

	if ($conn->connect_error) {
		    die("Connection failed: " . $conn->connect_error);
	}
 
       
 
        // returing connection cursor
        return $conn;
    }
 
    /**
     * Function to close db connection
     */
    function close() {
        // closing db connection
       mysqli_close();
    }
 
}
 
?>
