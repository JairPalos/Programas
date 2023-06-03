<!DOCTYPE html>
<head>
    <title>Tienda de Helados</title>
    <link href="https://fonts.googleapis.com/css2?family=Nerko+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles.css" />
    <script src="scripts.js"></script>
</head>
<body>

    <div class="page-nav">
        <div class="cerrar">
            <a href="cerrar.php">
            <button class="cerrar">Cerrar sesión</a>
        </div>
        <img src="images/logo_uaem.jpg" style=float:left width="80" height="80"/>
        <h1><center>Tienda de Helados</center></h1>
        <button id="checkout" class="button-checkout" onclick="pay()">Pagar</button>
    </div>
    <div class="page-content">
        <div class="product-container">
            <h3>Helado de Fresa</h3>
            <img src="images/fresa.jpg" />
            <h1>$50</h1>
            <button class="button-add" onclick="add('Helado de Fresa', 50)">Agregar</button>
        </div>

        <div class="product-container">
            <h3>Helado de Vainilla</h3>
            <img src="images/vainilla.jpg" />
            <h1>$50</h1>
            <button class="button-add" onclick="add('Helado de Vainilla', 50)">Agregar</button>
        </div>

        <div class="product-container">
            <h3>Helado de Chocolate</h3>
            <img src="images/choco.jpg" />
            <h1>$50</h1>
            <button class="button-add" onclick="add('Helado de Chocolate', 50)">Agregar</button>
        </div>

        <div class="product-container">
            <h3>Helado Napolitano</h3>
            <img src="images/napo.jpg" />
            <h1>$100</h1>
            <button class="button-add" onclick="add('Helado Napolitano', 100)">Agregar</button>
        </div>

        <div class="product-container">
            <h3>Helado de Nuez</h3>
            <img src="images/nuez.png" />
            <h1>$80</h1>
            <button class="button-add" onclick="add('Helado de Nuez', 80)">Agregar</button>
        </div>
    </div>
</body>