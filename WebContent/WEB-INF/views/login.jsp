<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Chamados</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/snackbar.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
    <br><br>
    	<form action="usuario_logar">
    		<div class="form-group">
    		<label> Usuario (id)</label>
    		<input class="form-control" type="text" name="id" required>
    		</div>
    		<div class="form-group">
    		<label> Senha</label>
    		<input class="form-control" type="password" name="pw" required>
    		</div>
    		<button class="btn btn-primary" type="submit">Logar</button>
    	</form>
    </div>
    <div id="snackbar">${snackbarAlert}</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
    	var text = "${snackbarAlert}";
    	if (text != ""){
        // Get the snackbar DIV
        var x = document.getElementById("snackbar")

        // Add the "show" class to DIV
        x.className = "show";

        // After 3 seconds, remove the show class from DIV
        setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
    	}
    
    </script>
</body>

</html>