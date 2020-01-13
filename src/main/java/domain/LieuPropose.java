package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LieuPropose implements Serializable {
    private Long id;
    private String lieu;

    public LieuPropose() {
    }

    public LieuPropose(String lieu) {
        this.lieu = lieu;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable=false)
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
