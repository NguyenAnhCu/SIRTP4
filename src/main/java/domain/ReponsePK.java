package domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReponsePK implements Serializable {
    private Long idSondage;
    private String emailParticipant;

    public ReponsePK() {
    }

    public ReponsePK(Long idSondage, String emailParticipant) {
        this.idSondage = idSondage;
        this.emailParticipant = emailParticipant;
    }

    public Long getIdSondage() {
        return idSondage;
    }

    public void setIdSondage(Long idSondage) {
        this.idSondage = idSondage;
    }

    public String getEmailParticipant() {
        return emailParticipant;
    }

    public void setEmailParticipant(String emailParticipant) {
        this.emailParticipant = emailParticipant;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
