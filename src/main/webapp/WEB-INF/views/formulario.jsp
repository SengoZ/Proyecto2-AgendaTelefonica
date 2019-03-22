<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formulario de contacto</title>

    <link rel="stylesheet" href="css/estilos.css">
    <link rel="stylesheet" href="css/font-awesome.css">

    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/script.js"></script>
</head>
<body>

    <section class="form_wrap">

        <section class="cantact_info">
            <section class="info_title">
                <span class="fa fa-user-circle"></span>
                <h2>ALTA/MODIFICACIÓN<br>DE CONTACTOS</h2>
            </section>
            <section class="info_items">
                <p><span class="fa fa-envelope"></span> Grupo 3 LucaTic</p>
                <p><span class="fa fa-mobile"></span> +1(585) 902-8665</p>
            </section>
        </section>

        <form action="" class="form_contact">
            <h2>Alta/Modificación de contactos</h2>
                        <div class = "formularioCliente" id = "formularioCliente">

            <div class="form">
            <label for="form">Nombre</label>
            <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Ej. Freddie">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Primer Apellido</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. Mercury">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Segundo Apellido</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. García">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">DNI</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. 05236780D">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Fecha de Nacimiento</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. 05/07/1985">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Telefono</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. 05/07/1985">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Direccion</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. C/Anabel Segura 11">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Código postal</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. 28500">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Localidad</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. Pozuelo">
            </div>

            <div class="form-group">
            <label for="formGroupExampleInput2">Provincia</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ej. Madrid">
            </div>

            <div>
            <button type="button" class="btn btn-primary btn-lg">Enviar</button>
            </div>

            
        
        </div>
        </form>
</section>
   

</body>
</html>
