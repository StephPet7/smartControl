package com.example.backend.DAO.DAOI;

import com.example.backend.Entity.PosteControle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteControleDAOI extends JpaRepository<PosteControle, Long> {

    List<PosteControle> findByAdresseContaining(String adresse);
    List<PosteControle> findByNumeroPoste(String numeroPoste);
}
