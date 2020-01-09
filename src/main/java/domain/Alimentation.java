package domain;

import java.io.Serializable;

public class Alimentation implements Serializable {
    private Long id;
    private String libelle;

    public Alimentation(){
    }
    public Alimentation(String libelle) {
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
