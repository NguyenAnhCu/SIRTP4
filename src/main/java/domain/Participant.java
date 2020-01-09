package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Participant implements Serializable {

    private String Email;
    private String nom;
    private String preNom;
    private List <Alimentation> preferences;
    private List<Alimentation> allergies;
    private List<Sondage> sondages;

    public Participant(){
    }

    @Id
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
    @ManyToMany
    public List<Alimentation> getPreferences() {
        return preferences;
    }
    public void setPreferences(List<Alimentation> preferences) {
        this.preferences = preferences;
    }
    @ManyToMany
    public List<Alimentation> getAllergies() {
        return allergies;
    }
    public void setAllergies(List<Alimentation> allergies) {
        this.allergies = allergies;
    }
    @OneToMany(mappedBy = "createur", cascade = CascadeType.PERSIST)
    public List<Sondage> getSondages() {
        return sondages;
    }
    public void setSondages(List<Sondage> sondages) {
        this.sondages = sondages;
    }

}
