package domain;

import java.io.Serializable;
import java.util.List;

public class Sondage implements Serializable {
    Long id;
    String lien;
    Participant createur;
    Reunion reunion;
    List<Reponse> reponses;

    public Sondage(){

    }

    public Sondage(String lien, Participant createur, Reunion reunion, List<Reponse> reponses) {
        this.lien = lien;
        this.createur = createur;
        this.reunion = reunion;
        this.reponses = reponses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Participant getCreateur() {
        return createur;
    }

    public void setCreateur(Participant createur) {
        this.createur = createur;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Reunion getReunion() {
        return reunion;
    }
    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }
}
