import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoadAppartements extends HttpServlet {
    /**
	 * 
	 */
	private List<Appartement> appartementList;
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		BDDHelper bddHelper = new BDDHelper();
		try {
			appartementList = bddHelper.loadAllAppartements();
			appartementList = new ArrayList();
			Appartement appartement = new Appartement(2, "studio", "rue olala", 3.2F, 3.2F, "jmarques");
			appartementList.add(appartement);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		out.println("<html>");
    	
    	out.println("<head>");
    	String title = "VousLoger";
    	out.println("<title>" + title + "</title>");
    	out.println("</head>");
    	
    	out.println("<body>");
		out.println("<h1>Listes d'appartements disponible:</h1>");

		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Type d'appartement</th>");
		out.println("<th>Adresse</th>");
		out.println("<th>Montant Vente</th>");
		out.println("</tr>");
		out.println("<tr>");
		for(Appartement appart : appartementList){
			out.println("<td>"+appart.getTypeAppat()+"</td>");
			out.println("<td>"+appart.getAdresse()+"</td>");
			out.println("<td>"+appart.getMontantVente()+"</td>");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
    }
}
