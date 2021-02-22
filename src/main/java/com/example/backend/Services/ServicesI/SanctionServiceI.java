package com.example.backend.Services.ServicesI;

import com.example.backend.Entity.Sanction;

import java.util.List;

public interface SanctionServiceI extends DefaultServices<Sanction, Long>{

    List<Sanction> findAllSanctionByDescriptionContaining(String description);
    List<Sanction> findAllSanctionByPenaliteContaining(String penalite);
}
