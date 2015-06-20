package vousloger.servlet;


import vousloger.myhelper.BDDHelper;
import vousloger.pojo.Appartement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class LoadAppartements extends HttpServlet {

    private BDDHelper bddHelper;
	private static final long serialVersionUID = 1L;

	public void init(){
		this.bddHelper = new BDDHelper();
	}

	protected void doGet (HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");

		BDDHelper bddHelper = new BDDHelper();
		List<Appartement> appartementList = this.bddHelper.loadAllAppartements();


    	
    	out.println("<head>");
    	String title = "VousLoger";
    	out.println("<title>" + title + "</title>");
    	out.println("</head>");
    	
    	out.println("<body>");
		out.println("<h1>Listes d'appartements disponible:</h1>");

		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Type d'appartement</td>");
		out.println("<td>Adresse</td>");
		out.println("<td>Montant Vente</td>");
		out.println("</tr>");

		for(Appartement appart : appartementList){
			out.println("<tr>");
			out.println("<td>"+appart.getTypeAppat()+"</td>");
			out.println("<td>"+appart.getAdresse()+"</td>");
			out.println("<td>"+appart.getMontantVente()+"</td>");
			out.println("</tr>");
		}


		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
    }

}
