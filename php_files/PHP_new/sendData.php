<?php
  require "DataBase.php";
  $db = new DataBase();
  $output = array();
  /* Select queries return a resultset */

  $sql = "UPDATE orders SET orders.img_src = (SELECT img_src FROM menu WHERE orders.item_name = menu.item_name)";
  
  if ($db->dbConnect()) {
           $update = mysqli_query($db->dbConnect(), $sql);
           if ($result = mysqli_query($db->dbConnect(), "SELECT * from orders")){
                 while ($row = mysqli_fetch_assoc($result)){
                     $output[]=$row;
                 }
           }
      mysqli_close($db->dbConnect());
      echo json_encode($output);
  } else echo "Can't Connect to database";
?>
