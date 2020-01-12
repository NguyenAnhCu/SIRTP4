package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass( AssidutePK.class )
public class Assidute implements Serializable {
    private String emailParticipant;
    private Long idReunion;
    private Reunion reunion;

    private Utilisateur participant;

    private String code;
    boolean present;

    public Assidute(){
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Id
    @Column(name = "ASSIDUTE_ID_PARTICIPANT_FK")
    public String getEmailParticipant() {
        return emailParticipant;
    }

    public void setEmailParticipant(String emailParticipant) {
        this.emailParticipant = emailParticipant;
    }

    @Id
    @Column(name = "ASSIDUTE_ID_REUUION_FK")
    public Long getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Long idReunion) {
        this.idReunion = idReunion;
    }

    @ManyToOne( cascade = CascadeType.PERSIST )
    @JoinColumn(name = "ASSIDUTE_ID_REUUION_FK", insertable = false, updatable = false )
    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
        this.idReunion = reunion.getId();
    }

    @ManyToOne( cascade = CascadeType.PERSIST )
    @JoinColumn( name = "ASSIDUTE_ID_PARTICIPANT_FK",insertable = false, updatable = false)
    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur participant) {
        this.participant = participant;
        this.emailParticipant = participant.getEmail();
    }
}
