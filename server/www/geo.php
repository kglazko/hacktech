<?php
error_reporting(-1);
if (isset($_POST['lon']) && isset($_POST['lat']) && isset($_POST['usr']) && isset($_POST['activity'])) {
    $db = mysqli_connect('localhost', 'root', 'happyhacking','fistbump');
$q = 'INSERT INTO `fistbump`.`geo` (`lon`, `lat`, `usr`, `activity`) VALUES ('. "'$_POST[lon]', '$_POST[lat]', '$_POST[usr]', '$_POST[activity]') ON DUPLICATE KEY UPDATE usr=VALUES(usr)";
echo $q."<br />";
    if(!$db->query($q)){
echo $db->error;
}
    return;
}
if (isset($_GET['lon']) && isset($_GET['lat'])) {
    $spread_m = 500;
    $earth_r = 6378137;
//    $spread_deg = $spread_m / 111111;
    
    $spread_lat = 180/pi*$spread_m/$earth_r;
    $spread_long = 180/pi*$spread_m/($earth_r*cos(pi()*$_GET['lat']/180));
    
    $long_min = $_GET['lon'] - $spread_long;
    $long_max = $_GET['lon'] + $spread_long;
    $lat_min = $_GET['lat'] + $spread_lat;
    $lat_max = $_GET['lat'] + $spread_lat;
    $result = $db->query("SELECT * FROM geo WHERE long < $long_max AND long > $long_min AND lat < $lat_max AND lat > $lat_min");
if(!$result)echo $db->error;
    $return=[];
    while ($row = mysqli_fetch_assoc($result)) {
        $return[] = $row;
    }
    echo $return;
}
?>