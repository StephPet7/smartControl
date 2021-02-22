package com.example.backend.DAO.DAOI;

import com.example.backend.Entity.CarteGrise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarteGriseDAOI extends JpaRepository<CarteGrise, Long> {

    List<CarteGrise> findByAdresseContaining(String adresse);
    List<CarteGrise> findByNumeroChassisContaining(String numeroChassis);
    List<CarteGrise> findByImmatriculationContaining(String immatriculation);
    List<CarteGrise> findByNomProprietaireContaining(String nomProprietaire);

    List<CarteGrise> findByDateAcquisitionBetween(Date dateStart, Date dateEnd);
    List<CarteGrise> findByDateExpirationBetween(Date dateStart, Date dateEnd);

}
