package com.example.backend.Services.ServicesI;

import com.example.backend.Entity.PosteControle;

import java.util.List;

public interface PosteControleServiceI extends DefaultServices<PosteControle, Long>{

    List<PosteControle> findAllPosteControleByAdresse(String adresse);
    List<PosteControle> findAllPosteControleByNumeroPoste(String numeroPoste);
}
