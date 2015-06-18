import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordanmarques on 18/06/15.
 */
public class main {

    public static void main(String[] args) throws Exception {

        List<Appartement> appartementList = null;

        BDDHelper bddHelper = new BDDHelper();
        appartementList = bddHelper.loadAllAppartements();


        System.out.println("<html>");

        System.out.println("<head>");
        String title = "VousLoger";
        System.out.println("<title>" + title + "</title>");
        System.out.println("</head>");

        System.out.println("<body>");
        System.out.println("<h1>Listes d'appartements disponible:</h1>");

        System.out.println("<table>");
        System.out.println("<tr>");
        System.out.println("<th>Type d'appartement</th>");
        System.out.println("<th>Adresse</th>");
        System.out.println("<th>Montant Vente</th>");
        System.out.println("</tr>");
        System.out.println("<tr>");

        for(Appartement appart : appartementList){
            System.out.println("<td>"+appart.getTypeAppat()+"</td>");
            System.out.println("<td>"+appart.getAdresse()+"</td>");
            System.out.println("<td>"+appart.getMontantVente()+"</td>");
        }
        System.out.println("</tr>");
        System.out.println("</table>");
        System.out.println("</body>");
        System.out.println("</html>");
    }
}
