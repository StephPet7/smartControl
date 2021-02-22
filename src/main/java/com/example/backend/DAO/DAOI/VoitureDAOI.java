package com.example.backend.DAO.DAOI;

import com.example.backend.Entity.PosteControle;
import com.example.backend.Entity.Transporteur;
import com.example.backend.Entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface VoitureDAOI extends JpaRepository<Voiture, Long> {

    public List<Voiture> findByDatePoliceAssuranceBetween(Date dateStart, Date dateEnd);
    public List<Voiture> findByDateVisiteTechniqueBetween(Date dateStart, Date dateEnd);

    @Query("select v from Voiture v where v.carteGrise.id = ?1 ")
    Voiture findByCarteGriseId(Long id);


}
