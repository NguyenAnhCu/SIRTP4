package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * setSondage et setParticipant sont à utiliser pour la primaryKey
 * pour les contraintes métiers sur le type de Reponse
 * qui doit correspondre au type de Sondage
 */
@Entity
public class Reponse implements Serializable {

    protected ReponsePK reponsePK = new ReponsePK();
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

    public void setDateReponse(DatePropose dateReponse) throws Exception {
        if(type.equals(Type.DATE))
            this.dateReponse = dateReponse;
        else throw new Exception("le Type de votre reponse n'est pas "+ type +"\nET type de Reponse attendu pour ce objet doit être "+sondage.getType());
    }

    @ManyToOne
    public LieuPropose getLieuPropose() {
        return lieuPropose;
    }

    public void setLieuPropose(LieuPropose lieuPropose) throws Exception {
        if(type.equals(Type.LIEU))
            this.lieuPropose = lieuPropose;
        else throw new Exception("le Type de votre reponse n'est pas "+ type +",\nET type de Reponse attendu pour ce objet doit être "+sondage.getType());
    }

    /**
     * Le Getter de la clé primaire nécessaire à JPA
     *
     * @return
     */
    @EmbeddedId
    protected ReponsePK getReponsePK() {
        return reponsePK;
    }

    public void setReponsePK(ReponsePK reponsePK) {
        this.reponsePK = reponsePK;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EMAILPARTICIPANT",insertable = false, updatable = false)
    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur participant) {
        this.participant = participant;
        reponsePK.setEmailParticipant(participant.getEmail());
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "IDSONDAGE",insertable = false, updatable = false)
    public Sondage getSondage() {
        return sondage;
    }

    public void setSondage(Sondage sondage) {
        this.sondage = sondage;
        // Intégrité
        this.type = sondage.getType();
        reponsePK.setIdSondage(sondage.getId());
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @PrePersist
    public void prePersist() throws Exception {
        switch (type){
            case LIEU: if (lieuPropose == null) throw new Exception("lieuReponse cannot be null"); break;
            case DATE: if (dateReponse == null) throw new Exception("dateReponse cannot be null"); break;
            case LIEUDATE: if(dateReponse == null | lieuPropose == null ) throw new Exception("lieuReponse and dateReponse cannot be null");break;
        }
    }
}
