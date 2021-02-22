package com.example.backend.Services.ServicesImpl;

import com.example.backend.DAO.DAOI.TransporteurDAOI;
import com.example.backend.Entity.Transporteur;
import com.example.backend.Services.ServicesI.TransporteurServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
@Service
public class TransporteurServiceImpl implements TransporteurServiceI {

    @Autowired
    TransporteurDAOI transporteurDAOI;

    @Override
    public Transporteur save(Transporteur entity) {
        return transporteurDAOI.save(entity);
    }

    @Override
    public Transporteur update(Transporteur entity) {
        Transporteur transporteur= findById(entity.getId());



        transporteur.setImpotStationnement(entity.isImpotStationnement());
        transporteur.setCarteGrise(entity.getCarteGrise());
        transporteur.setDateCarteBleue(entity.getDateCarteBleue());
        transporteur.setDatePoliceAssurance(entity.getDatePoliceAssurance());
        transporteur.setDatePatente(entity.getDatePatente());
        transporteur.setDateVisiteTechnique(entity.getDateVisiteTechnique());
        transporteur.setVignette(entity.isVignette());

        transporteurDAOI.save(transporteur);
        return transporteur;
    }

    @Override
    public void delete(Long id) {
        transporteurDAOI.deleteById(id);
    }

    @Override
    public Transporteur findById(Long id) {
        return transporteurDAOI.findById(id).get();
    }

    @Override
    public List<Transporteur> findAll() {
        return transporteurDAOI.findAll();
    }

    @Override
    public List<Transporteur> findAllDateCarteBleueBetween(Date dateStart, Date dateEnd) {
        return transporteurDAOI.findByDateCarteBleueBetween(dateStart,dateEnd);
    }

    @Override
    public List<Transporteur> findAllDatePatenteBetween(Date dateStart, Date dateEnd) {
        return transporteurDAOI.findByDatePatenteBetween(dateStart,dateEnd);
    }


}
