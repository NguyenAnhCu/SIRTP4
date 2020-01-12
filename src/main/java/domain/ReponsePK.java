package domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReponsePK implements Serializable {
    private Long idSondage;
    private String emailAuteur;

    public ReponsePK() {
    }

    public ReponsePK(Long idSondage, String emailAuteur) {
        this.idSondage = idSondage;
        this.emailAuteur = emailAuteur;
    }

    public Long getIdSondage() {
        return idSondage;
    }

    public void setIdSondage(Long idSondage) {
        this.idSondage = idSondage;
    }

    public String getEmailAuteur() {
        return emailAuteur;
    }

    public void setEmailAuteur(String emailAuteur) {
        this.emailAuteur = emailAuteur;
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
