<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>PROYECTO 2 - AGENDA</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!--bootstrap-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!--FONT AWESOME-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">

    <!--CSS-->
    <link rel="stylesheet" href="resources/css/listadoCont.css">
    
    <spring:url value="resources/css/listadoCont.css" var="list" />
	<link href="${list}" rel="stylesheet" />
	<style type="text/css">
		/* The Modal (background) */
		.modal {
			display: none; /* Hidden by default */
			position: fixed; /* Stay in place */
			z-index: 1; /* Sit on top */
			padding-top: 100px; /* Location of the box */
			left: 0;
			top: 0;
			width: 100%; /* Full width */
			height: 100%; /* Full height */
			overflow: auto; /* Enable scroll if needed */
			background-color: rgb(0, 0, 0); /* Fallback color */
			background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
		}
		
		/* Modal Content */
		.modal-content {
			background-color: #fefefe;
			margin: auto;
			padding: 20px;
			border: 1px solid #888;
			width: 40%;
		}
		
		/* The Close Button */
		.close {
			color: #aaaaaa;
			float: left;
			font-size: 28px;
			font-weight: bold;
		}
		
		.close:hover, .close:focus {
			color: #000;
			text-decoration: none;
			cursor: pointer;
		}
	</style>
</head>
<body>
    <!-- Navigation -->
    <nav class="navegacion" id="principio">
        <div class="row" id="arriba"style="background:  url('resources/images/bg-pattern.png'), url('resources/images/Burning_Orange.jpg');">
           <div class="col-md-2">
        
           </div>
            <div class="col-md-5" id="empieza">
                <i class="fab fa-buromobelexperte"></i>
                <a href="#listado" style="color: white" class="arriba">Empieza Ahora</a>
            </div>
            <div class="col-md-2" id="redes">
                <i class="far fa-share-square"></i>
                <a href="#asides" style="color: white" class="listado">Redes Sociales</a>
            </div>
            <div class="col-md-3" id="contacto">
                <i class="far fa-smile"></i>
                <a href="#contacto" style="color: white" class="contact">Contacto</a>
            </div>
        </div>
    </nav>



    <header style="background:  url('resources/images/bg-pattern.png'), url('resources/images/Burning_Orange.jpg');">
        <div class="row">
           <div class="col-md-2">
           
           </div>
            <div class="col-md-4">
                <p id="entrada">Bienvenido a tu agenda online! Organiza tus contactos de manera más eficaz! Empieza ahora!</p>
                <div id="botonout">
                   <p><i class="fas fa-book-open" id="libro"></i></p>
                    <button onclick="window.location.href='#listado'" type="button" class="btn btn-outline-info" id="boton">Accede a Tu Agenda</button>
                </div>
            </div>
            <div class="col-md-1">
           
           </div>
            <div class="col-md-4" id="movil">
                <img style="width:70%" src="resources/images/movil.png" alt="MÓVIL" title="MÓVIL">
            </div>
            <div class="col-md-1">
           
           </div>
        </div>
    </header>


    <div align="center" id="listado">
	    <div class="row" style="margin: auto; padding-top: 2em; padding-left: 12em;">
	        <div class="col-md-5" >
	            <h1>AGENDA DE CONTACTOS</h1>
	        </div>
	    </div>
                
	     <div class="row" id="buscar">
		     <div class="col-md-4" style="padding-bottom: 1em;">
		     	<a href="new"><button type="button" class="btn btn-outline-info" id="alta">Nuevo contacto</button></a>
		     </div>
	         <div class="col-md-7"  style="padding-top: 3em;">
	            <form method="get" action="buscarId?nombre=${buscarNombre}">
	                <p>
	                   <input type="text" name="buscarNombre" placeholder="Buscar por nombre">
	                </p>
	            </form>
	         </div>
	     </div>
	     <div style="height: 35em; overflow-x: hidden; overflow-y: scroll;">
	     	<table class="table">
	         	<thead id="cabecera">
		             <tr>
		                 <th id="nombre">Nombre</th>
		                 <th id="apellido1">Primer Apellido</th>
		                 <th id="apellido2">Segundo Apellido</th>
		                 <th id="teléfono">Telefono</th>
		                 <th id="acciones">Acciones</th>
		             </tr>
	         	</thead>
	            <tbody>
					<c:forEach var="persona" items="${listaContactos}" varStatus="status">
						<tr>
							<td>${persona.nombre}</td>
							<td>${persona.apellido1}</td>
							<td>${persona.apellido2}</td>
							<td>
								<c:forEach var="telefonos" items="${persona.telefonos}" varStatus="status">
									${telefonos.telefono} <br />
								</c:forEach>
							</td>
							
							<td>
								<a href="ficha?id=${persona.idpersona}"><i class="fas fa-user">Ficha</i></a> | <a href="delete?id=${persona.idpersona}" id="borrar"><i class="fas fa-trash-alt">Borrar</i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	     </div>
    </div>
    <!-- The Modal -->
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<p style="text-align: center; color: black;">${message}</p>
		</div>

	</div>
	<script>
		var modal = document.getElementById('myModal');
		var span = document.getElementsByClassName("close")[0];
		var myVar= '${message}';
		if(myVar!=""){
			modal.style.display = "block";
			span.onclick = function() {
				modal.style.display = "none";
				window.location.hash = '#listado';
			    window.location.reload(true);
			}
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
					window.location.hash = '#listado';
				    window.location.reload(true);
				}
			}	
		}
		
	</script>



    <aside id="redes">
       <div id="asides">
        <div class="row">
            <div class="col-md-2">

            </div>
            <div class="col-md-10">
                <p>We <i class="fas fa-heart" id="heart"></i> new friends!</p>
                <p id="icons"><i class="fab fa-twitter" id="twitter"></i> <i class="fab fa-facebook-square" id="facebook"></i> <i class="fab fa-google-plus" id="google"></i></p>
            </div>
        </div>
       </div>
    </aside>



    <footer id="contacto">
        <p>© Your Website 2019. All Rights Reserved.</p>
        <p>tuagendapersonal@lucatic.com
            <br>+34 684 23 51 42</p>
    </footer>
</body>
</html>