<?php session_start();

    if(isset($_SESSION['usuario'])) {
        header('location: index.php');
    }

    
    
    if ($_SERVER['REQUEST_METHOD'] == 'POST'){
        
        $correo = $_POST['correo'];
        $usuario = $_POST['usuario'];
        $contrasena = $_POST['contrasena'];
        $contrasena2 = $_POST['contrasena2'];
        
        
        $error = '';
        
        if (empty($correo) or empty($usuario) or empty($contrasena) or empty($contrasena2)){
            
            $error .= '<i>Hay campos sin llenar</i>';
        }else{
            try{
                $conexion = new PDO('mysql:host=localhost;dbname=id17831507_login', 'id17831507_root', 'Olakease123@');
            }catch(PDOException $prueba_error){
                echo "Error: " . $prueba_error->getMessage();
            }
            
            $statement = $conexion->prepare('SELECT * FROM login WHERE usuario = :usuario LIMIT 1');
            $statement->execute(array(':usuario' => $usuario));
            $resultado = $statement->fetch();
            
                        
            if ($resultado != false){
                $error .= '<i>Este usuario ya está registrado</i>';
            }
            
            if ($contrasena != $contrasena2){
                $error .= '<i>Las contraseñas son distintas</i>';
            }
            
            
        }
        
        if ($error == ''){
            $statement = $conexion->prepare('INSERT INTO login (id, correo, usuario, contrasena) VALUES (null, :correo, :usuario, :contrasena)');
            $statement->execute(array(
                
                ':correo' => $correo,
                ':usuario' => $usuario,
                ':contrasena' => $contrasena
                
            ));
            
            $error .= '<i">Usuario registrado</i>';
        }
    }


    require 'PHP/registro-vista.php';

?>