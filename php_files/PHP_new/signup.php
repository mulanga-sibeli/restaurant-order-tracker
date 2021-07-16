<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username']) && isset($_POST['fullname']) && isset($_POST['email']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("user", $_POST['username'], $_POST['fullname'], $_POST['email'], $_POST['password'])) {
            echo "Sign Up Success";
        } else echo $db->errorHandler($_POST['username'], $_POST['email']);
    } else echo "Error: Database Connection";
} else echo "All fields are required";
?>
