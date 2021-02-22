package com.example.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean vignette;
    private Date datePoliceAssurance;
    private Date dateVisiteTechnique;
    @OneToOne
    private CarteGrise carteGrise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVignette() {
        return vignette;
    }

    public void setVignette(boolean vignette) {
        this.vignette = vignette;
    }

    public Date getDatePoliceAssurance() {
        return datePoliceAssurance;
    }

    public void setDatePoliceAssurance(Date datePoliceAssurance) {
        this.datePoliceAssurance = datePoliceAssurance;
    }

    public Date getDateVisiteTechnique() {
        return dateVisiteTechnique;
    }

    public void setDateVisiteTechnique(Date dateVisiteTechnique) {
        this.dateVisiteTechnique = dateVisiteTechnique;
    }

    public CarteGrise getCarteGrise() {
        return carteGrise;
    }

    public void setCarteGrise(CarteGrise carteGrise) {
        this.carteGrise = carteGrise;
    }
}
