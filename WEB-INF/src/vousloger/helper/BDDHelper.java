package vousloger.helper;

import vousloger.pojo.Appartement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordanmarques on 18/06/15.
 */
public class BDDHelper {
    private Statement statement;
    private ResultSet appartementsResultats;


    public BDDHelper()  {
    }

    public List<Appartement> loadAllAppartements() {

        List<Appartement> appartementList = new ArrayList<>();

        String appartementsRequete = "SELECT * from APPARTEMENTS WHERE Vendu=0";
        try {
            statement = Singleton.getInstance().createStatement();
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

    public List<Appartement> loadAllStudio() {

        List<Appartement> appartementList = new ArrayList<>();

        String appartementsRequete = "SELECT * from APPARTEMENTS WHERE Vendu=0 AND TypeAppat='STUDIO'";
        try {
            statement = Singleton.getInstance().createStatement();
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

}
