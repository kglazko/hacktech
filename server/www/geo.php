<?php

if (isset($_POST['long']) && isset($_POST['lat']) && isset($_POST['usr']) && isset($_POST['activity'])) {
    $db = mysqli_connect('localhost', 'root', 'happyhacking');
    $db->query('INSERT INTO geo (long, lat, usr, activity) VALUES (' . "$_POST[long],$_POST[lat],$_POST[usr],$_POST[activity]) ON DUPLICATE KEY UPDATE");
    return;
}
if (isset($_GET['long']) && isset($_GET['lat'])) {
    $spread_m = 500;
    $earth_r = 6378137;
//    $spread_deg = $spread_m / 111111;
    
    $spread_lat = 180/pi*$spread_m/$earth_r;
    $spread_long = 180/pi*$spread_m/($earth_r*cos(pi*$_GET['lat']/180));
    
    $long_min = $_GET['long'] - $spread_long;
    $long_max = $_GET['long'] + $spread_long;
    $lat_min = $_GET['lat'] + $spread_lat;
    $lat_max = $_GET['lat'] + $spread_lat;
    $result = $db->query("SELECT * FROM geo WHERE long < $long_max AND long > $long_min AND lat < $lat_max AND lat > $lat_min");
    $return=[];
    while ($row = mysqli_fetch_assoc($result)) {
        $return[] = $row;
    }
    echo $return;
}
?>