<%@ page import="vousloger.helper.BDDHelper" %>
<%@ page import="vousloger.pojo.Appartement" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>
<div>
	<div class="panel panel-default" style="margin:1%">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Liste d'Appartements</div>
		<table class="table table-striped">
			<th>Type</th><th>Adresse</th><th>Montant</th></tr>
			<%
				BDDHelper bddHelper = new BDDHelper();
				List<Appartement> appartementList = bddHelper.loadAllAppartements();
				for(Appartement appart : appartementList){
					out.println("<tr>");
					out.println("<td>"+appart.getTypeAppat()+"</td>");
					out.println("<td>"+appart.getAdresse()+"</td>");
					out.println("<td>"+appart.getMontantVente()+" "+"&#8364"+"</td>");
					out.println("</tr>");
				}
			%>

		</table>

	</div>
</div>
<%@ include file="footer.jsp" %>
