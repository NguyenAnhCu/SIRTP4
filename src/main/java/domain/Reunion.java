package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Reunion implements Serializable {
    Long Id;
    String intitule;
    String resume;

    DatePropose dateValide;
    String lienPad;
    List<Sondage> sondages;
    List<DatePropose> dateProposes;
    List<Assidute> assidute;

    public Reunion(){
    }


    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "DATE_VALIDE")
    public DatePropose getDateValide() {
        return dateValide;
    }

    public void setDateValide(DatePropose dateValide) {
        this.dateValide = dateValide;
    }

    public String getLienPad() {
        return lienPad;
    }

    public void setLienPad(String lienPad) {
        this.lienPad = lienPad;
    }

    @OneToMany(mappedBy = "reunion", cascade = CascadeType.PERSIST)
    public List<Sondage> getSondages() {
        return sondages;
    }

    public void setSondages(List<Sondage> sondages) {
        this.sondages = sondages;
    }
    @ManyToMany
    public List<DatePropose> getDateProposes() {
        return dateProposes;
    }

    public void setDateProposes(List<DatePropose> dateProposes) {
        this.dateProposes = dateProposes;
    }

    @OneToMany(mappedBy = "reunion", cascade = CascadeType.PERSIST)
    public List<Assidute> getAssidute() {
        return assidute;
    }

    public void setAssidute(List<Assidute> assidute) {
        this.assidute = assidute;
    }
}
