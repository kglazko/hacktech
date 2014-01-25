<?php

if (!isset($_POST['action'])) {
    return;
}
$db = mysqli_connect('localhost', 'root', 'happyhacking', 'fistbump');
if (mysqli_connect_errno($db)) {
    //handle error hwere   
    echo 'COULD NOT CONNECT TO DB: ' . mysqli_connect_error();
}
if ($_POST['action'] == 'newusr') {
    if (!isset($_POST['usr']) || !isset($_POST['pwd']) || !isset($_POST['email'])) {
        //handle error here
        return -1;
    }
    //check if exists but meh
    $db->query("INSERT INTO main(usr,pwd,email) VALUES (" . $_POST['usr'] . "," . $_POST['pwd'] . "," . $_POST['email'] . ")");
    return;
}
?>