package domain;

import java.io.Serializable;

public class Participant_Reunion implements Serializable {

    Participant_ReunionPK participant_reunionPK;
    String code;

    public Participant_Reunion(){

    }
    public Participant_Reunion(Participant_ReunionPK participant_reunionPK, String code) {
        this.participant_reunionPK = participant_reunionPK;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Participant_ReunionPK getParticipant_reunionPK() {
        return participant_reunionPK;
    }

    public void setParticipant_reunionPK(Participant_ReunionPK participant_reunionPK) {
        this.participant_reunionPK = participant_reunionPK;
    }
}
