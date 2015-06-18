import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordanmarques on 18/06/15.
 */
public class main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String urlBdd = "jdbc:mysql://localhost:8889/ProjetJ2E";

        List<Appartement> appartementList = null;
        try {
            appartementList = getAppartements(urlBdd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    private static List<Appartement> getAppartements(String urlBdd) throws SQLException {
        Connection conBdd = DriverManager.getConnection(urlBdd, "root", "root");


        List<Appartement> appartementList = new ArrayList<>();
        String appartementsRequete = "SELECT * from APPARTEMENTS";
        Statement statement = conBdd.createStatement();

        ResultSet appartementsResultats = statement.executeQuery(appartementsRequete);


        while (appartementsResultats.next()) {
            int numero = appartementsResultats.getInt("Numero");
            String typeAppat = appartementsResultats.getString("TypeAppat");
            String adresse = appartementsResultats.getString("Adresse");
            Float montantVente = appartementsResultats.getFloat("MontantVente");
            Float vendu = appartementsResultats.getFloat("Vendu");
            String loginProp = appartementsResultats.getString("LoginProp");

            appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
        }
        return appartementList;
    }
}
