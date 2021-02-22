package com.example.backend.DAO.DAOI;

import com.example.backend.Entity.PosteControle;
import com.example.backend.Entity.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanctionDAOI extends JpaRepository<Sanction, Long> {

    List<Sanction> findByDescriptionContaining(String description);
    List<Sanction> findByPenaliteContaining(String penalite);

}
