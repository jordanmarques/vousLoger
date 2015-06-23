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
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public BDDHelper()  {
    }

    public List<Appartement> loadAllAppartements() {

        List<Appartement> appartementList = new ArrayList<>();

        String appartementsRequete = "SELECT * from APPARTEMENTS WHERE Vendu=0";
        try {
            statement = Singleton.getInstance().createStatement();
            resultSet = statement.executeQuery(appartementsRequete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {

                String numero = resultSet.getString("Numero");
                String typeAppat = resultSet.getString("TypeAppat");
                String adresse = resultSet.getString("Adresse");
                Float montantVente = resultSet.getFloat("MontantVente");
                Float vendu = resultSet.getFloat("Vendu");
                String loginProp = resultSet.getString("LoginProp");

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
            resultSet = statement.executeQuery(appartementsRequete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {

                String numero = resultSet.getString("Numero");
                String typeAppat = resultSet.getString("TypeAppat");
                String adresse = resultSet.getString("Adresse");
                Float montantVente = resultSet.getFloat("MontantVente");
                Float vendu = resultSet.getFloat("Vendu");
                String loginProp = resultSet.getString("LoginProp");

                appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appartementList;
    }

    public List<Appartement> loadAllT1() {

        List<Appartement> appartementList = new ArrayList<>();

        String appartementsRequete = "SELECT * from APPARTEMENTS WHERE Vendu=0 AND TypeAppat='T1'";
        try {
            statement = Singleton.getInstance().createStatement();
            resultSet = statement.executeQuery(appartementsRequete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {

                String numero = resultSet.getString("Numero");
                String typeAppat = resultSet.getString("TypeAppat");
                String adresse = resultSet.getString("Adresse");
                Float montantVente = resultSet.getFloat("MontantVente");
                Float vendu = resultSet.getFloat("Vendu");
                String loginProp = resultSet.getString("LoginProp");

                appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appartementList;
    }

    public List<Appartement> loadAllT2() {

        List<Appartement> appartementList = new ArrayList<>();

        String appartementsRequete = "SELECT * from APPARTEMENTS WHERE Vendu=0 AND TypeAppat='T2'";
        try {
            statement = Singleton.getInstance().createStatement();
            resultSet = statement.executeQuery(appartementsRequete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {

                String numero = resultSet.getString("Numero");
                String typeAppat = resultSet.getString("TypeAppat");
                String adresse = resultSet.getString("Adresse");
                Float montantVente = resultSet.getFloat("MontantVente");
                Float vendu = resultSet.getFloat("Vendu");
                String loginProp = resultSet.getString("LoginProp");

                appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appartementList;
    }

    public List<Appartement> loadAllT3() {

        List<Appartement> appartementList = new ArrayList<>();

        String appartementsRequete = "SELECT * from APPARTEMENTS WHERE Vendu=0 AND TypeAppat='T3'";
        try {
            statement = Singleton.getInstance().createStatement();
            resultSet = statement.executeQuery(appartementsRequete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {

                String numero = resultSet.getString("Numero");
                String typeAppat = resultSet.getString("TypeAppat");
                String adresse = resultSet.getString("Adresse");
                Float montantVente = resultSet.getFloat("MontantVente");
                Float vendu = resultSet.getFloat("Vendu");
                String loginProp = resultSet.getString("LoginProp");

                appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appartementList;
    }

    public void register(String nom, String login, String mdp){

        try {
            preparedStatement = Singleton.getInstance().prepareStatement("INSERT INTO PROPRIETAIRES(Nom, Login, Mdp) VALUES(?,?,?)");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2,login);
            preparedStatement.setString(3,mdp);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkUser(String login, String mdp){

        try {
            preparedStatement = Singleton.getInstance().prepareStatement("SELECT Nom FROM PROPRIETAIRES WHERE Login=? AND Mdp=?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,mdp);
            ResultSet userResult = preparedStatement.executeQuery();

            if (userResult.next()){
                return userResult.getString("Nom");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Appartement> loadAppartementsOnSaleByUser(String user){

        List<Appartement> appartementList = new ArrayList<>();

        try {
            preparedStatement = Singleton.getInstance().prepareStatement("SELECT * from APPARTEMENTS WHERE Vendu=0 AND LoginProp=?");
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {

                String numero = resultSet.getString("Numero");
                String typeAppat = resultSet.getString("TypeAppat");
                String adresse = resultSet.getString("Adresse");
                Float montantVente = resultSet.getFloat("MontantVente");
                Float vendu = resultSet.getFloat("Vendu");
                String loginProp = resultSet.getString("LoginProp");

                appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appartementList;
    }

    public List<Appartement> loadAppartementsSoldByUser(String user){

        List<Appartement> appartementList = new ArrayList<>();

        try {
            preparedStatement = Singleton.getInstance().prepareStatement("SELECT * from APPARTEMENTS WHERE Vendu=1 AND LoginProp=?");
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {

                String numero = resultSet.getString("Numero");
                String typeAppat = resultSet.getString("TypeAppat");
                String adresse = resultSet.getString("Adresse");
                Float montantVente = resultSet.getFloat("MontantVente");
                Float vendu = resultSet.getFloat("Vendu");
                String loginProp = resultSet.getString("LoginProp");

                appartementList.add(new Appartement(numero, typeAppat, adresse, vendu, montantVente, loginProp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appartementList;
    }

    public void saleAnAppartement(String id){

        try {
            preparedStatement = Singleton.getInstance().prepareStatement("UPDATE APPARTEMENTS SET Vendu=1 WHERE Numero=?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeAnAppartement(String id){

        try {
            preparedStatement = Singleton.getInstance().prepareStatement("DELETE FROM APPARTEMENTS WHERE Numero=?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addAppartement(String type, String adress, String price, String user) {
        try {
            preparedStatement = Singleton.getInstance().prepareStatement("INSERT INTO APPARTEMENTS(TypeAppat, Adresse, MontantVente, Vendu, LoginProp) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, type);
            preparedStatement.setString(2,adress);
            preparedStatement.setString(3,price);
            preparedStatement.setString(4,"0");
            preparedStatement.setString(5,user);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getLastIdAppartByUser(String user){
        String id = null;
        try {
            preparedStatement = Singleton.getInstance().prepareStatement("SELECT max(Numero) FROM APPARTEMENTS WHERE LoginProp=?");
            preparedStatement.setString(1, user);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            id = resultSet.getString("max(Numero)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;

    }
}

