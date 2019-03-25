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

	 <!--bootstrap-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!--FONT AWESOME-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
	
	<spring:url value="resources/css/estilos.css" var="estilos"/>
    <link href="${estilos}" rel="stylesheet" />
    <spring:url value="resources/css/font-awesome.css" var="font-awesome"/>
    <link href="${font-awesome}" rel="stylesheet" />  

    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/script.js"></script>
</head>
<body style="background:  url('resources/images/bg-pattern.png'), url('resources/images/Burning_Orange.jpg'); background-repeat: repeat, no-repeat; background-size: auto, cover; background-attachment: fixed;">

    <section class="form_wrap">

        <section class="cantact_info" style="background-image:  url('resources/images/fondo.jpg'); background-size: cover; background-position: center;"> 
            <section class="info_title">
                <span class="fa fa-user-circle"></span>
                <h2>ALTA/MODIFICACIÓN<br>DE CONTACTOS</h2>
            </section>
            <section class="info_items">
                <p><span class="fa fa-envelope"></span> Grupo 3 LucaTic</p>
                <p><span class="fa fa-mobile"></span> +1(585) 902-8665</p>
            </section>
        </section>

        <form:form class="form_contact" method="post" modelAttribute="persona" action="save" var="persona" item =" ${persona}">
            <h2>Alta/Modificación de contactos</h2>
            <div class = "formularioCliente" id = "formularioCliente" >

            <div class="form">
            <form:label for="form" path="nombre">Nombre</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.nombre}" path="nombre"/>
            </div>

			<div class="form">
            <form:label for="form" path="apellido1">Primer Apellido</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.apellido1}" path="apellido1"/>
            </div>
            
            <div class="form">
            <form:label for="form" path="apellido2">Segundo Apellido</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.apellido2}" path="apellido2"/>
            </div>
          	
          	<div class="form">
            <form:label for="form" path="dni">DNI</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.dni}" path="dni"/>
            </div>
			
			<div class="form">
            <form:label for="form" path="fechanacimiento">Fecha de Nacimiento</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.fechanacimiento}" path="fechanacimiento"/>
            
            </div>
            
            <div class="form">
            <form:label for="form" path="telefonos[0].telefono">Teléfono</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.telefonos[0].telefono}" path="telefonos[0].telefono"/>
            </div>
			
			<div class="form">
            <form:label for="form" path="direccions[0].direccion">Dirección</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.direccions[0].direccion}" path="direccions[0].direccion"/>
            </div>
            
            <div class="form">
            <form:label for="form" path="direccions[0].codpostal">Código postal</form:label>
            <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.direccions[0].codpostal}" path="direccions[0].codpostal"/>
            </div>
            
            <div class="form">
            <form:label for="form" path="direccions[0].localidad">Provincia</form:label>
            <form:select type="text" class="form-control" id="formGroupExampleInput" placeholder= "${persona.direccions[0].localidad}" path="direccions[0].localidad" items="${listaProv}">
            	<c:forEach var="item" items="${listaProv}">
		            <option value="${provincia.idprovincia}">${provincia.provincia}</option>
		    	</c:forEach>
            </form:select>
            </div>
         
            <div style="padding-left: 50%; padding-top: 25%">
            <a href="save"><button type="submit" class="btn btn-primary btn-lg">Enviar</button></a>
            </div>

            
        
        </div>
        </form:form>
</section>
   

</body>
</html>
