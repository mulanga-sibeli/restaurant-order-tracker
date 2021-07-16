<?php
    require "DataBase.php";
    $db = new DataBase();
    if ($db->dbConnect()) {
        if ($db->addToOrder("orders", $_POST['username'], $_POST['item_name'], $_POST['status'], $_POST['rating'], $_POST['res_name'])) {
            echo "Success";
        } else echo "NO success";
    } else echo "Error: Database Connection";
?>

