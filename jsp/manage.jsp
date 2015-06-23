<%@ page import="vousloger.helper.BDDHelper" %>
<%@ page import="vousloger.pojo.Appartement" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>

<div class="panel panel-default col-md-5 pull-left" style="margin-left:50px">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Appartements en vente</div>
	<table class="table table-striped">
		<th>Numero</th><th>Type</th><th>Adresse</th><th>Montant</th><th>Action</th></tr>
			<%
				BDDHelper bddHelper = new BDDHelper();
				List<Appartement> appartementOnSaleList = bddHelper.loadAppartementsOnSaleByUser((String) session.getAttribute("login"));
				for(Appartement appart : appartementOnSaleList){
					out.println("<tr>");
					out.println("<td>"+appart.getNumero()+"</td>");
					out.println("<td>"+appart.getTypeAppat()+"</td>");
					out.println("<td>"+appart.getAdresse()+"</td>");
					out.println("<td>"+appart.getMontantVente()+" "+"&#8364"+"</td>");

					%>
						<td>
							<form action="saleAnAppartement" method="get">
								<button name="appartement-id" type="submit" value= "<%=appart.getNumero() %>" class="btn btn-xs btn-default"> Vendu </button>
							</form>

					<%
					%>

							<form action="removeAnAppartement" method="get">
								<button name="appartement-id" type="submit" value= "<%=appart.getNumero() %>" class="btn btn-xs btn-default"> Supprimer </button>
							</form>
						</td>
						<%
					out.println("</tr>");
				}%>



	</table>
</div>

<div class="col-md-3"></div>
	<div class="panel panel-default col-md-5 pull-right" style="margin-right:50px">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Appartements vendu</div>
	<table class="table table-striped">
		<th>Type</th><th>Adresse</th><th>Montant</th></tr>
			<%
				List<Appartement> appartementSoldList = bddHelper.loadAppartementsSoldByUser((String) session.getAttribute("login"));
				for(Appartement appart : appartementSoldList){
					out.println("<tr>");
					out.println("<td>"+appart.getTypeAppat()+"</td>");
					out.println("<td>"+appart.getAdresse()+"</td>");
					out.println("<td>"+appart.getMontantVente()+" "+"&#8364"+"</td>");
					out.println("</tr>");
				}

			%>
	</table>
</div>

<%@ include file="footer.jsp" %>

