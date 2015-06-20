<%@ page import="vousloger.myhelper.BDDHelper" %>
<%@ include file="header.jsp" %>
<div>
	<div class="panel panel-default" style="margin:1%">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Liste d'Appartements</div>
		<table class="table table-striped">
			<tr><td>Numero</td><td>Type</td><td>Adresse</td><td>Montant</td></tr>

			<tr><td>1</td><td>Studio</td><td>11 rue X</td><td>350.000</td></tr>
			<tr><td>1</td><td>Studio</td><td>11 rue X</td><td>350.000</td></tr>
			<tr><td>1</td><td>Studio</td><td>11 rue X</td><td>350.000</td></tr>
			<tr><td>1</td><td>Studio</td><td>11 rue X</td><td>350.000</td></tr>
			<tr><td>1</td><td>Studio</td><td>11 rue X</td><td>350.000</td></tr>
		</table>
		<%
			BDDHelper bddHelper = new BDDHelper();
		%>
	</div>
</div>
<%@ include file="footer.jsp" %>
