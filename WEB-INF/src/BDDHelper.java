import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordanmarques on 18/06/15.
 */
public class BDDHelper {
    private Connection conBdd;
    private String urlBdd;
    private Statement statement;
    private ResultSet appartementsResultats;


    public BDDHelper()  {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }

        this.urlBdd = "jdbc:mysql://localhost:8889/ProjetJ2E";

        try {
            this.conBdd = DriverManager.getConnection(urlBdd, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Appartement> loadAllAppartements() {

        List<Appartement> appartementList = new ArrayList<>();

        String appartementsRequete = "SELECT * from APPARTEMENTS";
        try {
            statement = conBdd.createStatement();
            appartementsResultats = statement.executeQuery(appartementsRequete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (appartementsResultats.next()) {

                int numero = appartementsResultats.getInt("Numero");
                String typeAppat = appartementsResultats.getString("TypeAppat");
                String adresse = appartementsResultats.getString("Adresse");
                Float montantVente = appartementsResultats.getFloat("MontantVente");
                Float vendu = appartementsResultats.getFloat("Vendu");
                String loginProp = appartementsResultats.getString("LoginProp");

                appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appartementList;
    }

    @Override
    public String toString() {
        return "BDDHelper{" +
                "conBdd=" + conBdd +
                ", urlBdd='" + urlBdd + '\'' +
                ", statement=" + statement +
                ", appartementsResultats=" + appartementsResultats +
                '}';
    }
}
