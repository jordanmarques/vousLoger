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
                    <li><a href="#"><i class="glyphicon glyphicon-cog"></i> Se connecter</a></li>
                </ul>
            </div>
        </div>
    </nav>