<?php session_start();

    if(isset($_SESSION['usuario'])){
        require 'PHP/principal-vista.php';
    }else{
        header ('location: login.php');
    }
        
?>