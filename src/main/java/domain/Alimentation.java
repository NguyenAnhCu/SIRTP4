package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Alimentation implements Serializable {
    private Long id;
    private String libelle;
    private TypeAlimentation typeAlimentation;

    public Alimentation(){
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TypeAlimentation getTypeAlimentation() {
        return typeAlimentation;
    }

    public void setTypeAlimentation(TypeAlimentation typeAlimentation) {
        this.typeAlimentation = typeAlimentation;
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
