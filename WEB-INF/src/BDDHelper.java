import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordanmarques on 18/06/15.
 */
public class BDDHelper {

    public BDDHelper() {
    }

    public List<Appartement> loadAllAppartements() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String urlBdd = "jdbc:mysql://localhost:8889/ProjetJ2E";
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
