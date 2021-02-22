package com.example.backend.Services.ServicesImpl;

import com.example.backend.DAO.DAOI.SanctionDAOI;
import com.example.backend.Entity.Sanction;
import com.example.backend.Services.ServicesI.SanctionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class SanctionServiceImpl implements SanctionServiceI {
    @Autowired
    SanctionDAOI sanctionDAOI;


    @Override
    public Sanction save(Sanction entity) {
        return sanctionDAOI.save(entity);
    }

    @Override
    public Sanction update(Sanction entity) {
        Sanction sanction= findById(entity.getId());

        sanction.setDescription(entity.getDescription());
        sanction.setPenalite(entity.getPenalite());
        sanctionDAOI.save(sanction);

        return sanction;
    }

    @Override
    public void delete(Long id) {
        sanctionDAOI.deleteById(id);
    }

    @Override
    public Sanction findById(Long id) {
        return sanctionDAOI.findById(id).get();
    }

    @Override
    public List<Sanction> findAll() {
        return sanctionDAOI.findAll();
    }

    @Override
    public List<Sanction> findAllSanctionByDescriptionContaining(String description) {
        return sanctionDAOI.findByDescriptionContaining(description);
    }

    @Override
    public List<Sanction> findAllSanctionByPenaliteContaining(String penalite) {
        return sanctionDAOI.findByPenaliteContaining(penalite);
    }


}
