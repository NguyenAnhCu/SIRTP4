package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("DATE")
public class ReponseDate extends Reponse implements Serializable {
    private DatePropose dateReponse;
    private Type type = Type.DATE;

    public ReponseDate(){
    }

    @ManyToOne
    public DatePropose getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(DatePropose dateReponse) {
        this.dateReponse = dateReponse;
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
