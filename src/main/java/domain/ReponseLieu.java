package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("LIEU")
public class ReponseLieu extends Reponse implements Serializable {
    private LieuPropose lieuPropose;
    private Type type = Type.LIEU;
    public ReponseLieu(){

    }

    @ManyToOne
    public LieuPropose getLieuPropose() {
        return lieuPropose;
    }

    public void setLieuPropose(LieuPropose lieuPropose) {
        this.lieuPropose = lieuPropose;
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
