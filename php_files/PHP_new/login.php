<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("user", $_POST['username'], $_POST['password'])) {
	    echo "Login Success";
        } else echo "Username or Password wrong";
    } else echo "Error: Database Connection";
} else echo "All fields are required!";
?>