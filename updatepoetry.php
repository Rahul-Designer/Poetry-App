<?php
    $servername = "localhost";
    $username = "root";
    $password = "";
    $db = "poetrydb";
 
    $conn = new mysqli($servername,$username,$password,$db);
    if($conn->connect_error){
        die("connection failded: " .$conn->connect_error);
    }
 
    $POETRY = $_POST['poetry_data'];
    $ID = $_POST['id'];

    $query = "UPDATE poetry SET poetry_data = '$POETRY' WHERE id = '$ID'";

    $result = $conn->query($query);

    if($result == 1){
        $response = array("status"=>"1","message"=>"Poetry succesfully updated");
    }
    else{
        $response = array("status"=>"","message"=>"Poetry not updated succesfully");
    }

    echo json_encode($response);



?>