<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="parts/header.jsp" %>
<title>Inscription</title>
</head>
    <body>
        <div class="loader"></div>
        <form action="register" method="POST">
            <div class="form-group">
                <label for="nameYoutuber">Nom : </label>
                <input type="text" class="form-control" id="nameYoutuber" name="nameYoutuber"></input>
            </div>
            <div class="form-group">
                <label for="firstNameYoutuber">Prénom : </label>
                <input type="text" class="form-control" id="firstNameYoutuber" name="firstNameYoutuber"></input>
            </div>
            <div class="form-group">
                <label for="usernameYoutube">Username Youtube : </label>
                <input type="text" class="form-control" id="usernameYoutube" name="usernameYoutube"></input>
                <small id="usernameHelp" class="form-text text-muted">Votre username se trouve dans l'url de votre chaine : http://youtube/user/-username-</small>
            </div>
            <div class="form-group">
                <label for="channelName">Nom de la chaine : </label>
                <input type="text" class="form-control" id="channelName" name="channelName"></input>
            </div>
            <h3>Accès à la platforme : </h3>
            <div class="form-group">
                <label for="loginYT">Identifiant : </label>
                <input type="text" class="form-control" id="loginYT" name="loginYT"></input>
            </div>
            <div class="form-group">
                <label for="passYT">Mot de passe : </label>
                <input type="password" class="form-control" id="passYT" name="passYT"></input>
             </div>
             <button type="submit" class="btn btn-primary">Envoyer</button>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $('.loader').fadeOut(3000);
        </script>
    </body>
</html>