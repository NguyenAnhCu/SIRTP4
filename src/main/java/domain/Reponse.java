package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reponse implements Serializable {
    Long id;
    Sondage sondage;

    @Column(nullable=false)
    DatePropose dateReponse;
    Utilisateur auteur;

    public Reponse(){

    }

    public Reponse(Sondage sondage, DatePropose dateReponse, Utilisateur auteur) {
        this.sondage = sondage;
        this.dateReponse = dateReponse;
        this.auteur = auteur;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
    }

    @ManyToOne
    public DatePropose getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(DatePropose dateReponse) {
        this.dateReponse = dateReponse;
    }

    @ManyToOne
    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }
}
