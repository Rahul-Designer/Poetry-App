<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $db = "poetrydb";

    $conn = new mysqli($servername,$username,$password,$db);
    if($conn->connect_error){
        die("connection failded: " .$conn->connect_error);
    }

    $query = "SELECT * FROM poetry";

    $result = $conn->query($query);

    $row = $result->fetch_all(MYSQLI_ASSOC);

    if(empty($row)){
        $response = array("status"=>"0","message"=>"Record is empty","data"=>$row);
    }
    else{
        $response = array("status"=>"1","message"=>"Record is available","data"=>$row);
    }
    echo json_encode($response);

?>