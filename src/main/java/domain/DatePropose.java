package domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DatePropose implements Serializable {
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date dateProsope;
    private boolean Pause;

    public DatePropose(){
    }

    public DatePropose(Date dateProsopes, boolean pause) {
        this.dateProsope = dateProsopes;
        Pause = pause;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateProsope() {
        return dateProsope;
    }

    public void setDateProsope(Date dateProsope) {
        this.dateProsope = dateProsope;
    }

    public boolean isPause() {
        return Pause;
    }

    public void setPause(boolean pause) {
        Pause = pause;
    }
}
