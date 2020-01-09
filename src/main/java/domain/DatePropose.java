package domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DatePropose implements Serializable {
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date  dateProsopes;
    private boolean Pause;

    public DatePropose(){
    }

    public DatePropose(Date dateProsopes, boolean pause) {
        this.dateProsopes = dateProsopes;
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

    public Date getDateProsopes() {
        return dateProsopes;
    }

    public void setDateProsopes(Date dateProsopes) {
        this.dateProsopes = dateProsopes;
    }

    public boolean isPause() {
        return Pause;
    }

    public void setPause(boolean pause) {
        Pause = pause;
    }
}
