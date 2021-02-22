package com.example.backend.Services.ServicesImpl;

import com.example.backend.DAO.DAOI.PosteControleDAOI;
import com.example.backend.Entity.PosteControle;
import com.example.backend.Services.ServicesI.PosteControleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class PosteControleServiceImpl implements PosteControleServiceI {
    @Autowired
    PosteControleDAOI posteControleDAOI;

    @Override
    public PosteControle save(PosteControle entity) {
        return posteControleDAOI.save(entity);
    }

    @Override
    public PosteControle update(PosteControle entity) {
        PosteControle posteControle= findById(entity.getId());

        posteControle.setAdresse(entity.getAdresse());
        posteControle.setNumeroPoste(entity.getNumeroPoste());

        posteControleDAOI.save(entity);
        return posteControle;
    }

    @Override
    public void delete(Long id) {
        posteControleDAOI.deleteById(id);
    }

    @Override
    public PosteControle findById(Long id) {
        return posteControleDAOI.findById(id).get();
    }

    @Override
    public List<PosteControle> findAll() {
        return posteControleDAOI.findAll();
    }

    @Override
    public List<PosteControle> findAllPosteControleByAdresse(String adresse) {
        return posteControleDAOI.findByAdresseContaining(adresse);
    }

    @Override
    public List<PosteControle> findAllPosteControleByNumeroPoste(String numeroPoste) {
        return posteControleDAOI.findByNumeroPoste(numeroPoste);
    }


}
