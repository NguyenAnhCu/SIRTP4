package domain;

import java.io.Serializable;
import java.util.List;

public class Reunion implements Serializable {
    Long Id;
    String intitule;
    String resume;
    String dateValide;
    String lienPad;
    List<Participant> participants;
    List<Sondage> sondages;
    List<DatePropose> dateProposes;

    public Reunion(){
    }

    public Reunion(String intitule, String resume, String dateValide, String lienPad, List<Participant> participants, List<Sondage> sondages, List<DatePropose> dateProposes) {
        this.intitule = intitule;
        this.resume = resume;
        this.dateValide = dateValide;
        this.lienPad = lienPad;
        this.participants = participants;
        this.sondages = sondages;
        this.dateProposes = dateProposes;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDateValide() {
        return dateValide;
    }

    public void setDateValide(String dateValide) {
        this.dateValide = dateValide;
    }

    public String getLienPad() {
        return lienPad;
    }

    public void setLienPad(String lienPad) {
        this.lienPad = lienPad;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
    public List<Sondage> getSondages() {
        return sondages;
    }

    public void setSondages(List<Sondage> sondages) {
        this.sondages = sondages;
    }
    public List<DatePropose> getDateProposes() {
        return dateProposes;
    }

    public void setDateProposes(List<DatePropose> dateProposes) {
        this.dateProposes = dateProposes;
    }
}
