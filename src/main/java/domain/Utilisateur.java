package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur implements Serializable {

    private String Email;
    private String nom;
    private String preNom;
    private List <Alimentation> preferences = new ArrayList<Alimentation>();
    private List<Alimentation> allergies = new ArrayList<Alimentation>();
    private List<Sondage> sondages = new ArrayList<Sondage>();

    List<Assidute> assidute;

    public Utilisateur(){

    }

    public Utilisateur(String nom, String preNom, List<Alimentation> preferences, List<Alimentation> allergies, List<Sondage> sondages, List<Assidute> assidute) {
        this.nom = nom;
        this.preNom = preNom;
        this.preferences = preferences;
        this.allergies = allergies;
        this.sondages = sondages;
        this.assidute = assidute;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Utilisateur_Preference", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "preference_id"))
    public List<Alimentation> getPreferences() {
        return preferences;
    }
    public void setPreferences(List<Alimentation> preferences) {
        this.preferences = preferences;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Utilisateur_Allergie", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "allergie_id"))
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

    @OneToMany(mappedBy = "participant", cascade = CascadeType.PERSIST)
    public List<Assidute> getAssidute() {
        return assidute;
    }

    public void setAssidute(List<Assidute> assidute) {
        this.assidute = assidute;
    }

    public void addAllergies(Alimentation alimentation){
        allergies.add(alimentation);
    }
    public void addPrefereneces(Alimentation alimentation){
        preferences.add(alimentation);
    }


}
