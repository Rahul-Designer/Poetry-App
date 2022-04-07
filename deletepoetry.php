<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $db = "poetrydb";
  
    $conn = new mysqli($servername,$username,$password,$db);
    if($conn->connect_error){
        die("connection failded: " .$conn->connect_error);
    }
    $p_ID = $_POST['poetry_id'];

    $query = "DELETE FROM poetry WHERE id = '$p_ID'";

    $result = $conn->query($query);

    if($result == 1){
        $response = array("status"=>"1","message"=>"Poetry succesfully Deleted");
    }
    else{
        $response = array("status"=>"","message"=>"Poetry not deleted succesfully");
    }

    echo json_encode($response);

?>
