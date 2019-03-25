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
    <title>Ficha de contacto</title>

	<spring:url value="resources/css/estilos.css" var="estilos"/>
    <link href="${estilos}" rel="stylesheet" />
    <spring:url value="resources/css/font-awesome.css" var="font-awesome"/>
    <link href="${font-awesome}" rel="stylesheet" />  

    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/script.js"></script>
</head>
<body>

    <section class="form_wrap">

        <section class="cantact_info">
            <section class="info_title">
                <span class="fa fa-user-circle"></span>
                <h2>FICHA<br>DEL CONTACTO</h2>
            </section>
            <section class="info_items">
                <p><span class="fa fa-envelope"></span> Grupo 3 LucaTic</p>
                <p><span class="fa fa-mobile"></span> +1(585) 902-8665</p>
            </section>
        </section>

        <form:form class="form_contact" method="get" modelAttribute="persona" action="buscarId" var="ficha" item =" ${ficha}">
            <h2>Ficha del Contacto</h2>
            <div class = "formularioCliente" id = "formularioCliente" >

            <div class="form">
            <form:label for="form" path="nombre">Nombre</form:label>
            <p>${persona.nombre}</p>
            <p id="invisible">.</p>
            </div>

			<div class="form">
            <form:label for="form" path="apellido1">Primer Apellido</form:label>
            <p>${persona.apellido1}</p>
            <p id="invisible">.</p>
            </div>
            
            <div class="form">
            <form:label for="form" path="apellido2">Segundo Apellido</form:label>
            <p>${persona.apellido2}</p>
            <p id="invisible">.</p>
            </div>
          	
          	<div class="form">
            <form:label for="form" path="dni">DNI</form:label>
            <p>${persona.dni}</p>
            <p id="invisible">.</p>
            </div>
			
			<div class="form">
            <form:label for="form" path="fechanacimiento">Fecha de Nacimiento</form:label>
            <p>${persona.fechanacimiento}</p>
            <p id="invisible">.</p>
            </div>
            
            <div class="form">
            <form:label for="form" path="telefonos[0].telefono">Teléfono</form:label>
            <p>${persona.telefonos[0].telefono}</p>
            <p id="invisible">.</p>
			</div>
			
			<div class="form">
            <form:label for="form" path="direccions[0].direccion">Dirección</form:label>
            <p>${persona.direccions[0].direccion}</p>
            <p id="invisible">.</p>
            </div>
            
            <div class="form">
            <form:label for="form" path="direccions[0].codpostal">Código postal</form:label>
            <p>${persona.direccions[0].codpostal}</p>
            <p id="invisible">.</p>
            </div>
            
            <div class="form">
            <form:label for="form" path="direccions[0].localidad">Provincia</form:label>
            <p>${persona.direccions[0].localidad}</p>
            <p id="invisible">.</p>
            <p id="invisible">.</p>           
            </div>
         
            <div>
            <a href="vuelta"><button type="button" class="btn btn-primary btn-lg">Volver</button></a>
		    <a href="editar"><button type="button" class="btn btn-primary btn-lg">Editar</button></a>
            </div>

            
        
        </div>
        </form:form>
</section>
   

</body>
</html>
