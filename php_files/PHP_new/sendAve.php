<?php
  require "DataBase.php";
  $db = new DataBase();
  $res_name = $_REQUEST['res_name'];
  if ($db->dbConnect()) {
      if ($result = mysqli_query($db->dbConnect(), "SELECT AVG(rating) FROM orders WHERE rating != 'N/A' AND res_name = '$res_name'")) {
           $ans = mysqli_fetch_assoc($result);
           echo $ans['AVG(rating)'];
      } echo "0";
      mysqli_close($db->dbConnect());
  } else echo "Can't Connect to database";
?>
