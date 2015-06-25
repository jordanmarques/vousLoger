<%@ page import="vousloger.helper.BDDHelper" %>
<%@ page import="vousloger.pojo.Appartement" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>


<%
BDDHelper bddHelper = new BDDHelper();
if(session.getAttribute("newAppart") == "1"){
%>
	<div class="alert alert-warning alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>F&eacutelicitation!</strong> Vous venez de cr&eacuteer l'appartement n&#176
	  <%
	  	out.print(bddHelper.getLastIdAppartByUser((String) session.getAttribute("login")));
	  %>
	</div>

<%
	session.setAttribute("newAppart", "0");
}
%>

<div class="panel panel-default col-md-5 pull-left" style="margin-left:50px;padding:0;">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Appartements en vente <button class="btn btn-xs btn-default pull-right" data-toggle="modal" data-target="#appartModal"><i class="glyphicon glyphicon-plus" style="color:#777;"></i> Ajouter un appartement</button></div>
	<table class="table table-striped">
		<th>Numero</th><th>Type</th><th>Adresse</th><th>Montant</th><th>Action</th></tr>
			<%
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

<div class="col-md-2"></div>

<div class="panel panel-default col-md-5 pull-right" style="margin-right:50px;padding:0;">
	<div class="panel-heading" style="background-color:rgb(223, 73, 55);color:white">Appartements vendu</div>
	<table class="table table-striped">
		<th>Numero</th><th>Type</th><th>Adresse</th><th>Montant</th></tr>
			<%
				List<Appartement> appartementSoldList = bddHelper.loadAppartementsSoldByUser((String) session.getAttribute("login"));
				for(Appartement appart : appartementSoldList){
					out.println("<tr>");
					out.println("<td>"+appart.getNumero()+"</td>");
					out.println("<td>"+appart.getTypeAppat()+"</td>");
					out.println("<td>"+appart.getAdresse()+"</td>");
					out.println("<td>"+appart.getMontantVente()+" "+"&#8364"+"</td>");
					out.println("</tr>");
				}

			%>
	</table>
</div>

<div class="modal fade bs-example-modal-sm" id="appartModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >Cr&eacuteer un Appartement</h4>
      </div>

      <div class="modal-body">
        <form action="addAppartement" method="get">
			<select class="btn btn-default" name="appart-type">
				<optgroup label="Type">
					<option value="STUDIO">Studio</option>
					<option value="T1">T1</option>
					<option value="T2">T2</option>
					<option value="T3">T3</option>
				</optgroup>
		  </select>
		  </br>
		  <input name="appart-adress" type="text" placeholder="Adresse" required/>
		  </br>
		  <input name="appart-price" type="number" placeholder="Montant" required/>
      </div>

      <div class="modal-footer" >
        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
        <button type="submit" class="btn btn-primary" style="background-color:rgb(223, 73, 55);border-color:rgb(223, 73, 55);">Enregistrer</button>
      </div>
	</form>
    </div>
  </div>
</div>

<%@ include file="footer.jsp" %>

