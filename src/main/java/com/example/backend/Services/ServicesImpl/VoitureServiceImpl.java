package com.example.backend.Services.ServicesImpl;

import com.example.backend.DAO.DAOI.VoitureDAOI;
import com.example.backend.Entity.Voiture;
import com.example.backend.Services.ServicesI.VoitureServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
@Service
public class VoitureServiceImpl implements VoitureServiceI {
    @Autowired
    VoitureDAOI voitureDAOI;

    @Override
    public Voiture save(Voiture entity) {
        return voitureDAOI.save(entity);
    }

    @Override
    public Voiture update(Voiture entity) {

        Voiture voiture = findById(entity.getId());

        voiture.setCarteGrise(entity.getCarteGrise());
        voiture.setDatePoliceAssurance(entity.getDatePoliceAssurance());
        voiture.setDateVisiteTechnique(entity.getDateVisiteTechnique());
        voiture.setVignette(entity.isVignette());

        voitureDAOI.save(voiture);

        return voiture;
    }

    @Override
    public void delete(Long id) {
        voitureDAOI.deleteById(id);
    }

    @Override
    public Voiture findById(Long id) {
        return voitureDAOI.findById(id).get();
    }

    @Override
    public List<Voiture> findAll() {
        return voitureDAOI.findAll();
    }

    @Override
    public List<Voiture> findAllVoitureByDatePoliceAssuranceBetween(Date dateStart, Date dateEnd) {
        return voitureDAOI.findByDatePoliceAssuranceBetween(dateStart,dateEnd);
    }

    @Override
    public List<Voiture> findAllVoitureByDateVisiteTechniqueBetween(Date dateStart, Date dateEnd) {
        return voitureDAOI.findByDateVisiteTechniqueBetween(dateStart,dateStart);
    }

    @Override
    public Voiture findVoitureByCarteGriseId(Long id) {
        return voitureDAOI.findByCarteGriseId(id);
    }


}
