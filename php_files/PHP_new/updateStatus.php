<?php
  require "DataBase.php";
  $db = new DataBase();
  $status = $_REQUEST['status'];
  $pos = $_REQUEST['pos'];
  $timeOrder = $_REQUEST['timeOrder'];
  if ($status == "Preparing") {
      $sql = "UPDATE orders SET status = '$status', time = '$timeOrder' WHERE order_no = '$pos'";
  }else $sql = "UPDATE orders SET status = '$status' WHERE order_no = '$pos'";
  if ($db->dbConnect()) {
      if ($res = mysqli_query($db->dbConnect(), $sql)) {
           echo "Success";
      }
  } else echo "Can't Connect to database";
?>

