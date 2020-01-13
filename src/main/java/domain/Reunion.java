package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Reunion implements Serializable {
    Long Id;
    String intitule;
    String resume;

    DatePropose lieuValide;
    DatePropose dateValide;
    String lienPad;
    List<Sondage> sondages = new ArrayList<Sondage>();
    List<DatePropose> dateProposes = new ArrayList<DatePropose>();
    List<LieuPropose> lieuProposes = new ArrayList<LieuPropose>();

    List<Assidute> assidute = new ArrayList<Assidute>();

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


    @OneToOne(cascade = CascadeType.PERSIST)
    public DatePropose getDateValide() {
        return dateValide;
    }

    public void setDateValide(DatePropose dateValide) {
        this.dateValide = dateValide;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public DatePropose getLieuValide() {
        return lieuValide;
    }

    public void setLieuValide(DatePropose lieuValide) {
        this.lieuValide = lieuValide;
    }

    @OneToMany
    public List<LieuPropose> getLieuProposes() {
        return lieuProposes;
    }

    public void setLieuProposes(List<LieuPropose> lieuProposes) {
        this.lieuProposes = lieuProposes;
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
    @OneToMany
    public List<DatePropose> getDateProposes() {
        return dateProposes;
    }

    public void setDateProposes(List<DatePropose> dateProposes) {
        this.dateProposes = dateProposes;
    }

    public void addDateProposes(DatePropose datePropose){
        dateProposes.add(datePropose);
    }

    @OneToMany(mappedBy = "reunion", cascade = CascadeType.PERSIST)
    public List<Assidute> getAssidute() {
        return assidute;
    }

    public void setAssidute(List<Assidute> assidute) {
        this.assidute = assidute;
    }


}
