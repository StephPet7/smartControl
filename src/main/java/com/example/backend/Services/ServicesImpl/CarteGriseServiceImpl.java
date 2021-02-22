package com.example.backend.Services.ServicesImpl;

import com.example.backend.DAO.DAOI.CarteGriseDAOI;
import com.example.backend.Entity.CarteGrise;
import com.example.backend.Services.ServicesI.CarteGriseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
@Service
public class CarteGriseServiceImpl implements CarteGriseServiceI {
    @Autowired
    CarteGriseDAOI carteGriseDAOI;

    @Override
    public CarteGrise save(CarteGrise entity) {
        return carteGriseDAOI.save(entity);
    }

    @Override
    public CarteGrise update(CarteGrise entity) {
        CarteGrise carteGrise = findById(entity.getId());

        carteGrise.setAdresse(entity.getAdresse());
        carteGrise.setDateAcquisition(entity.getDateAcquisition());
        carteGrise.setDateExpiration(entity.getDateExpiration());
        carteGrise.setImmatriculation(entity.getImmatriculation());
        carteGrise.setNomProprietaire(entity.getNomProprietaire());
        carteGrise.setNumeroChassis(entity.getNumeroChassis());

        carteGriseDAOI.save(carteGrise);
        return carteGrise;
    }

    @Override
    public void delete(Long id) {
        carteGriseDAOI.deleteById(id);
    }

    @Override
    public CarteGrise findById(Long id) {
        return carteGriseDAOI.findById(id).get();
    }

    @Override
    public List<CarteGrise> findAll() {
        return carteGriseDAOI.findAll();
    }

    @Override
    public List<CarteGrise> findAllCarteGriseByAdresseContaining(String adresse) {
        return carteGriseDAOI.findByAdresseContaining(adresse);
    }

    @Override
    public List<CarteGrise> findAllCarteGriseByNumeroChassisContaining(String numeroChassis) {
        return carteGriseDAOI.findByNumeroChassisContaining(numeroChassis);
    }

    @Override
    public List<CarteGrise> findAllCarteGriseByImmatriculationContaining(String immatriculation) {
        return carteGriseDAOI.findByImmatriculationContaining(immatriculation);
    }

    @Override
    public List<CarteGrise> findAllCarteGriseByNomProprietaireContaining(String nomProprietaire) {
        return carteGriseDAOI.findByNomProprietaireContaining(nomProprietaire);
    }

    @Override
    public List<CarteGrise> findAllCarteGriseByDateAcquisitionBetween(Date dateStart, Date dateEnd) {
        return carteGriseDAOI.findByDateAcquisitionBetween(dateStart,dateEnd);
    }

    @Override
    public List<CarteGrise> findAllCarteGriseByDateExpirationBetween(Date dateStart, Date dateEnd) {
        return carteGriseDAOI.findByDateExpirationBetween(dateStart,dateEnd);
    }


}
