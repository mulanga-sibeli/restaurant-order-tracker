<?php
require "DataBaseConfig.php";

class DataBase {
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct() {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data) {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $username, $password) {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($username == $dbusername && $password == $dbpassword) {
                $login = true;
            } else $login = false;
        } else $login = false;
        return $login;
    }

    function stafflogIn($table, $username, $password) {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where res_name = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['res_name'];
            $dbpassword = $row['res_password'];
            if ($username == $dbusername && $password == $dbpassword) {
                $login = true;
            } else $login = false;
        } else $login = false;
        return $login;
    }

    function errorHandler($username, $email) {
        $username = $this->prepareData($username);
        $email = $this->prepareData($email);
        $result = mysqli_query($this->connect, "SELECT * FROM user");
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
	    if ($username == $row['username']) return "Username already exists";
	    else if ($email == $row['email']) return "Email already exists";
        }
	return "No success";
    }

    function addToOrder($table, $username, $item_name, $status, $rating, $res_name) {
        $username = $this->prepareData($username);
	$item_name = $this->prepareData($item_name);
	$status = $this->prepareData($status);
	$rating = $this->prepareData($rating);
	$res_name = $this->prepareData($res_name);
	$this->sql = 
		"INSERT INTO " . $table . " (username, item_name, status, rating, res_name) VALUES ('" . $username . "','" . $item_name . "','" . $status . "','" . $rating . "','" . $res_name . "')";
	if (mysqli_query($this->connect, $this->sql)) return true;
	else return false;
    }

    function signUp($table, $username, $fullname, $email, $password) {
        $username = $this->prepareData($username);
	$fullname = $this->prepareData($fullname);
	$email = $this->prepareData($email);
        $password = $this->prepareData($password);
	$result = mysqli_query($this->connect, "SELECT * FROM user");
	$row = mysqli_fetch_assoc($result);
	if (mysqli_num_rows($result) != 0) {
	    if ($username == $row['username'] || $email == $row['email']) return false;
	}
	$this->sql = 
            "INSERT INTO " . $table . " (username, fullname, email, password) VALUES ('" . $username . "','" . $fullname . "','" . $email . "','" . $password . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
}

?>
