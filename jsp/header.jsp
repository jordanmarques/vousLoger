<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/html">

<header>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>VousLoger</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
</header>
<body>
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand " href="loadAppartements" style="padding:0px;margin-right:5px" title="Vous Loger">
                    <img src="${pageContext.request.contextPath}/image/home.png" style="height:48px;width:48px;">
                </a>
                <a class="navbar-brand" href="loadAppartements"><span>Vous Loger</span></a>
            </div>
            <div id="navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="glyphicon glyphicon-search"></i> Rechercher <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="loadStudio">Studio</a></li>
                            <li><a href="loadT1">T1</a></li>
                            <li><a href="loadT2">T2</a></li>
                            <li><a href="loadT3">T3</a></li>
                        </ul>
                    </li>

                    <%
                        if(session.getAttribute("name")== null || session.getAttribute("name")==""){
                    %>
                            <li class="dropdown" ng-hide="user">
                                <a class="dropdown-toggle" href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-cog"></i> Se connecter<strong class="caret"></strong></a>
                                <div class="dropdown-menu" style="padding: 15px;">
                                    <form action="checkUser" method="get">
                                        <input id="authenticationLogin" name="authentication-login" type="text" placeholder="Login"/>
                                        <input id="authenticationPassword" name="authentication-password" type="password" placeholder="Mot de passe" />
                                        <button id="loginButton" class="btn btn-xs btn-primary btn-block" type="submit"
                                        style="background-color:rgb(223, 73, 55);border-color:rgb(223, 73, 55)">Connexion</button>
                                        <center><a href="register">Cr&eacuteer un compte</a></center>
                                    </form>
                                </div>
                            </li>
                        <% }else{ %>
                           <li class="dropdown" ng-show="user">
                                <a id="manageButton" class="dropdown-toggle" href="#" data-toggle="dropdown" ng-cloak>
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                <span><% out.print(session.getAttribute("name")); %></span><strong class="caret"></strong>
                                </a>
                                <div class="dropdown-menu" style="padding: 15px;">
                                    <div>
                                        <center>
                                        <form action="manage" method="get">
                                            <button id="logoutButton" class="btn btn-xs btn-primary"
                                                style="background-color:rgb(223, 73, 55);border-color:rgb(223, 73, 55)">
                                                <i class="icon-off"></i>Mon Compte
                                            </button>
                                        </form>
                                        </br>
                                        <form action="deconnexion" method="get">
                                            <button href="deconnexion" id="logoutButton" class="btn btn-xs btn-primary"
                                                style="background-color:rgb(223, 73, 55);border-color:rgb(223, 73, 55)">
                                                <i class="icon-off"></i>D&eacuteconnexion
                                            </button>
                                        </form>
                                        </center>
                                    </div>
                                </div>
                            </li>
                        <% } %>
                </ul>
            </div>
        </div>
    </nav>