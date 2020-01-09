package domain;

import java.io.Serializable;
import java.util.List;

public class Participant implements Serializable {

    private String Email;
    private String nom;
    private String preNom;
    private List <Alimentation> preferences;
    private List<Alimentation> allergies;
    private List<Sondage> sondages;

    public Participant(){
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public List<Alimentation> getPreferences() {
        return preferences;
    }
    public void setPreferences(List<Alimentation> preferences) {
        this.preferences = preferences;
    }

    public List<Alimentation> getAllergies() {
        return allergies;
    }
    public void setAllergies(List<Alimentation> allergies) {
        this.allergies = allergies;
    }
    public List<Sondage> getSondages() {
        return sondages;
    }
    public void setSondages(List<Sondage> sondages) {
        this.sondages = sondages;
    }

}
