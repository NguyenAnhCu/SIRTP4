package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Reponse implements Serializable {
    Long id;
    Sondage sondage;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    DatePropose dateReponse;
    Participant auteur;

    public Reponse(){

    }

    public Reponse(Sondage sondage, DatePropose dateReponse, Participant auteur) {
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
    public Participant getAuteur() {
        return auteur;
    }

    public void setAuteur(Participant auteur) {
        this.auteur = auteur;
    }
}
