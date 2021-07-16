<?php
  require "DataBase.php";
  $db = new DataBase();
  $rating = $_REQUEST['rating'];
  $pos = $_REQUEST['pos'];
  $sql = "UPDATE orders SET rating = '$rating' WHERE order_no = '$pos'";
  if ($db->dbConnect()) {
      if ($res = mysqli_query($db->dbConnect(), $sql)) {
           echo "Success";
      }
  } else echo "Can't Connect to database";
?>

