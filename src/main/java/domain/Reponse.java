package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reponse implements Serializable {

    protected ReponsePK reponsePK;
    private Utilisateur participant;
    private Sondage sondage;
    private Type type;

    DatePropose dateReponse;
    LieuPropose lieuPropose;


    public Reponse(){
    }

    public Reponse(Utilisateur participant, Sondage sondage) {
        this.participant = participant;
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
    public LieuPropose getLieuPropose() {
        return lieuPropose;
    }

    public void setLieuPropose(LieuPropose lieuPropose) {
        this.lieuPropose = lieuPropose;
    }

    @EmbeddedId
    protected ReponsePK getReponsePK() {
        return reponsePK;
    }

    public void setReponsePK(ReponsePK reponsePK) {
        this.reponsePK = reponsePK;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_UTILISATEUR",insertable = false, updatable = false)
    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur participant) {
        this.participant = participant;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_SONDAGE",insertable = false, updatable = false)
    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
        // Intégrité
        this.type = sondage.getType();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
