package domain;

import java.io.Serializable;

public class Participant_ReunionPK implements Serializable {
    private static final long serialVersionUID = 1L;

    Long Reunion_id;
    String participant_Email;

    public Participant_ReunionPK(){

    }

    public void setParticipant_Email(String participant_Email) {
        this.participant_Email = participant_Email;
    }

    public String getParticipant_Email() {
        return participant_Email;
    }


    public Long getReunion_id() {
        return Reunion_id;
    }

    public void setReunion_id(Long reunion_id) {
        Reunion_id = reunion_id;
    }
}
