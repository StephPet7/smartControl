package com.example.backend.DAO.DAOI;

import com.example.backend.Entity.PosteControle;
import com.example.backend.Entity.Transporteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransporteurDAOI extends JpaRepository<Transporteur, Long> {
    public List<Transporteur> findByDateCarteBleueBetween(Date dateStart, Date DateEnd);
    public List<Transporteur> findByDatePatenteBetween(Date dateStart, Date DateEnd);
}
