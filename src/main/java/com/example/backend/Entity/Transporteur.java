package com.example.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Transporteur extends Voiture{

    private boolean impotStationnement;
    private Date dateCarteBleue;
    private Date datePatente;

    public boolean isImpotStationnement() {
        return impotStationnement;
    }

    public void setImpotStationnement(boolean impotStationnement) {
        this.impotStationnement = impotStationnement;
    }

    public Date getDateCarteBleue() {
        return dateCarteBleue;
    }

    public void setDateCarteBleue(Date dateCarteBleue) {
        this.dateCarteBleue = dateCarteBleue;
    }

    public Date getDatePatente() {
        return datePatente;
    }

    public void setDatePatente(Date datePatente) {
        this.datePatente = datePatente;
    }
}
