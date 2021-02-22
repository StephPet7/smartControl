package com.example.backend.Services.ServicesI;

import com.example.backend.Entity.CarteGrise;

import java.util.Date;
import java.util.List;

public interface CarteGriseServiceI extends DefaultServices<CarteGrise,Long>{
    List<CarteGrise> findAllCarteGriseByAdresseContaining(String adresse);
    List<CarteGrise> findAllCarteGriseByNumeroChassisContaining(String numeroChassis);
    List<CarteGrise> findAllCarteGriseByImmatriculationContaining(String immatriculation);
    List<CarteGrise> findAllCarteGriseByNomProprietaireContaining(String nomProprietaire);

    List<CarteGrise> findAllCarteGriseByDateAcquisitionBetween(Date dateStart, Date dateEnd);
    List<CarteGrise> findAllCarteGriseByDateExpirationBetween(Date dateStart, Date dateEnd);
}
