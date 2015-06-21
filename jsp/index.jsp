<%@ page import="vousloger.helper.BDDHelper" %>
<%@ page import="vousloger.pojo.Appartement" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>
<div>
	<div class="panel panel-default" style="margin:1%">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Liste d'Appartements</div>
		<table class="table table-striped">
			<td>Type</td><td>Adresse</td><td>Montant</td></tr>
			<%
				BDDHelper bddHelper = new BDDHelper();
				List<Appartement> appartementList = bddHelper.loadAllAppartements();
				for(Appartement appart : appartementList){
					out.println("<tr>");
					out.println("<td>"+appart.getTypeAppat()+"</td>");
					out.println("<td>"+appart.getAdresse()+"</td>");
					out.println("<td>"+appart.getMontantVente()+"</td>");
					out.println("</tr>");
				}
			%>

		</table>

	</div>
</div>
<%@ include file="footer.jsp" %>
