<%@ include file="header.jsp" %>
<center>

<div class="panel panel-default" style="margin:5%;margin-left:20%;margin-right:20%">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Cr&eacuteer un compte</div>
    <form  action="registerInBdd" method="get" style="margin:10px">
        <input id="registerName" name="register-name" type="text" placeholder="Nom"/>
        </br>
        <input id="registerLogin" name="register-login" type="text" placeholder="Login"/>
        </br>
        <input id="registerPassword" name="register-password" type="password" placeholder="Mot de passe" />
        </br></br>
        <button id="registerButton" type="submit" class="btn btn-xs btn-primary"
            style="background-color:rgb(223, 73, 55);border-color:rgb(223, 73, 55)">
            Valider
        </button>
    </form>
    </div>
</center>
<%@ include file="footer.jsp" %>