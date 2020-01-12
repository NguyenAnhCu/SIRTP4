package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("DATELIEU")
public class ReponseDateLieu extends Reponse implements Serializable{
    private Long id;
    private DatePropose dateReponse;
    private LieuPropose lieuPropose;
    private Type type = Type.LIEUDATE;

    public ReponseDateLieu(){

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
