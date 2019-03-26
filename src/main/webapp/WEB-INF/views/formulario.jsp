<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

        <form:form class="form_contact" method="post" action="save" modelAttribute="contacto">
			<h2>Alta/Modificación de contactos</h2>
			<div class="formularioCliente" id="formularioCliente">

				<div class="form">
					<form:label for="form" path="pers.idpersona">ID</form:label>
					<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${pers.idpersona}" path="pers.idpersona" />
				</div>
				<div class="form">
					<form:label for="form" path="pers.nombre">Nombre</form:label>
					<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${pers.nombre}" path="pers.nombre" />
				</div>

				<div class="form">
					<form:label for="form" path="pers.apellido1">Primer Apellido</form:label>
					<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${pers.apellido1}" path="pers.apellido1" />
				</div>

				<div class="form">
					<form:label for="form" path="pers.apellido2">Segundo Apellido</form:label>
					<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${pers.apellido2}" path="pers.apellido2" />
				</div>

				<div class="form">
					<form:label for="form" path="pers.dni">DNI</form:label>
					<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${pers.dni}" path="pers.dni" />
				</div>

				<div class="form">
					<form:label for="form" path="pers.fechanacimiento">Fecha de Nacimiento</form:label>
					<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${pers.fechanacimiento}" path="pers.fechanacimiento" />
				</div>
			</div>

			<div class="form">
				<form:label for="form" path="tel.telefono">Teléfono</form:label>
				<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${tel.telefono}" path="tel.telefono" />
			</div>

			<div class="form">
				<form:label for="form" path="dir.direccion">Dirección</form:label>
				<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${dir.direccion}" path="dir.direccion" />
			</div>

			<div class="form">
				<form:label for="form" path="dir.codpostal">Código postal</form:label>
				<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${dir.codpostal}" path="dir.codpostal" />
			</div>
			
			<div class="form">
				<form:label for="form" path="dir.localidad">Localidad</form:label>
				<form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="${dir.localidad}" path="dir.localidad" />
			</div>

			<div class="form">
				<form:label for="form" path="dir.provincia.provincia">Provincia</form:label>
				<!--<form:select type="text" class="form-control" id="formGroupExampleInput" name="item" placeholder="${prov.provincia}" path="prov.provincia" items="${listaProv}">
				</form:select>-->
				<form:select class="form-control" placeholder="${prov.idprovincia}" path="prov.idprovincia" name="provincia">
					<option value="${prove.idprovincia}" selected>${prove.provincia}</option>
				    <c:forEach items="${listaProv}" var="provincia">
				    	<c:if test="${provincia.idprovincia != prove.idprovincia}">
				            <option value="${provincia.idprovincia}">${provincia.provincia}</option>
				        </c:if>
				    </c:forEach>
				</form:select>
			</div>
			<div style="padding-left: 50%; padding-top: 10%">
				<a href="save"><button type="submit"
				class="btn btn-primary btn-lg">Enviar</button></a>
			</div>
		</form:form>
</section>
   

</body>
</html>
