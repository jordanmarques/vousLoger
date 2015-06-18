import java.math.BigDecimal;

/**
 * Created by jordanmarques on 18/06/15.
 */
public class Proprietaire {

    private String nom;
    private String login;
    private String mdp;

    public Proprietaire(String nom, String login, String mdp) {
        this.nom = nom;
        this.login = login;
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
