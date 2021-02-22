package com.example.backend.Services.ServicesI;

import com.example.backend.Entity.Voiture;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VoitureServiceI extends DefaultServices<Voiture, Long> {

    public List<Voiture> findAllVoitureByDatePoliceAssuranceBetween(Date dateStart, Date dateEnd);
    public List<Voiture> findAllVoitureByDateVisiteTechniqueBetween(Date dateStart, Date dateEnd);
    Voiture findVoitureByCarteGriseId(Long id);

}
