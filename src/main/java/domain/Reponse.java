package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPEREPONSE", discriminatorType = DiscriminatorType.STRING, length=5)
public abstract class Reponse implements Serializable {
    Long id;
    Sondage sondage;
    Utilisateur auteur;
    private DatePropose dateReponse;

    public Reponse(){

    }

    public Reponse(Sondage sondage, Utilisateur auteur) {
        this.sondage = sondage;
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
    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public void setDateReponse(DatePropose dateReponse) {
    }

    public void setLieuPropose(LieuPropose lieuPropose) {

    }



}
