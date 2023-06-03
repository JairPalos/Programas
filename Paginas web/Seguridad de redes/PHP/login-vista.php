<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Iniciar sesión</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post" class="form">
      <section class="form-login">
        <h5>Iniciar sesión</h5>
        <input class="controls" type="text" name="usuario" value="" placeholder="Usuario">
        <input class="controls" type="password" name="contrasena" value="" placeholder="Contraseña">
        <?php if(!empty($error)): ?>
              <div class="mensaje">
                  <?php echo $error; ?>
              </div>
              <?php endif; ?>
        <button type="submit">Ingresar<label class="buttons">
        <br></br>
       <p><a href="registro.php">¿No tienes cuenta? Crea una</a></p>
      </section>
    </form>
  </body>
</html>
