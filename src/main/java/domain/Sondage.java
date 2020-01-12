package domain;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sondage implements Serializable {
    private Long id;
    private String lien;
    private Utilisateur createur;
    private Reunion reunion;
    private List<Reponse> reponses = new ArrayList<Reponse>();
    private Type type;

    public Sondage(){

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @ManyToOne
    public Reunion getReunion() {
        return reunion;
    }
    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @OneToMany(mappedBy = "sondage")
    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addReponse(Reponse reponse) {
        try{
            reponses.add(reponse);
        }catch (Exception e){
            System.out.println("Reponse incompatible");

        }
    }
}
