<?php session_start();

    if(isset($_SESSION['usuario'])) {
        header('location: index.php');
    }

    $error = '';

    if($_SERVER['REQUEST_METHOD'] == 'POST'){

        $usuario = $_POST['usuario'];
        $contrasena = $_POST['contrasena'];

        try{
            $conexion = new PDO('mysql:host=localhost;dbname=id17831507_login', 'id17831507_root', 'Olakease123@');
            }catch(PDOException $prueba_error){
                echo "Error: " . $prueba_error->getMessage();
            }

        $statement = $conexion->prepare('
        SELECT * FROM login WHERE usuario = :usuario AND contrasena = :contrasena'
        );

        $statement->execute(array(
            ':usuario' => $usuario,
            ':contrasena' => $contrasena
        ));

        $resultado = $statement->fetch();

        if ($resultado !== false){
            $_SESSION['usuario'] = $usuario;
            header('location: principal.php');
        }else{
            $error .= '<i>No se ha encontrado el usuario</i>';
        }
    }

require 'PHP/login-vista.php';


?>
