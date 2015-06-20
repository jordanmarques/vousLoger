package vousloger;

/**
 * Created by jordanmarques on 18/06/15.
 */
public class Appartement {
    private int numero;
    private String typeAppat;
    private String adresse;
    private Float montantVente;
    private Float vendu;
    private String loginProp;

    public Appartement(int numero, String typeAppat, String adresse, Float vendu, Float montantVente, String loginProp) {
        this.numero = numero;
        this.typeAppat = typeAppat;
        this.adresse = adresse;
        this.vendu = vendu;
        this.montantVente = montantVente;
        this.loginProp = loginProp;
    }

    public String getTypeAppat() {
        return typeAppat;
    }

    public void setTypeAppat(String typeAppat) {
        this.typeAppat = typeAppat;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Float getMontantVente() {
        return montantVente;
    }

    public void setMontantVente(Float montantVente) {
        this.montantVente = montantVente;
    }

    public Float getVendu() {
        return vendu;
    }

    public void setVendu(Float vendu) {
        this.vendu = vendu;
    }

    public String getLoginProp() {
        return loginProp;
    }

    public void setLoginProp(String loginProp) {
        this.loginProp = loginProp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
