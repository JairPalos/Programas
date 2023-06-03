<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Crear cuenta</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post" class="form">
    <section class="form-regis">
      <h5>Crear cuenta</h5>
      <input class="controls" type="text" name="correo" value="" placeholder="Correo electrónico">
      <input class="controls" type="text" name="usuario" value="" placeholder="Usuario">
      <input class="controls" type="password" name="contrasena" value="" placeholder="Ingresa la contraseña">
      <input class="controls" type="password" name="contrasena2" value="" placeholder="Confirma la Contraseña">
      <?php if(!empty($error)): ?>
              <div class="mensaje">
                  <?php echo $error; ?>
              </div>
              <?php endif; ?>
        <button type="submit">Crear cuenta<label class="buttons">
        <br></br>
      <p><a href="login.php">¿Tienes una cuenta? Inicia sesión</a></p>
    </section>
  </body>
</html>
