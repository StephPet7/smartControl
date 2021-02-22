package com.example.backend.Controller;


import com.example.backend.Entity.PosteControle;
import com.example.backend.Services.ServicesImpl.PosteControleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description ="Api management PosteControle")
@RestController
@RequestMapping("/api/PosteControle/")
public class PosteControleController {

    private static final Logger logger = LoggerFactory.getLogger(PosteControleController.class);
    @Autowired
    PosteControleServiceImpl posteControleServiceImpl;


    @ApiOperation(value="find PosteControle by id")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public PosteControle findPosteControleById(@PathVariable Long id) {
        logger.info("find posteControle by id");
        return posteControleServiceImpl.findById(id);
    }

    @ApiOperation(value="delete PosteControle by id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete posteControle by id");
        posteControleServiceImpl.delete(id);
    }

    @ApiOperation(value="get all PosteControle")
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<PosteControle> findAllPosteControle() {
        logger.info("find all posteControle");
        return posteControleServiceImpl.findAll();
    }

    @ApiOperation(value="update a PosteControle")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public PosteControle updatePosteControle(@RequestBody PosteControle posteControle) {
        logger.info("update a posteControle");
        return posteControleServiceImpl.update(posteControle);
    }

    @ApiOperation(value="add a PosteControle")
    @RequestMapping(value = "/{Adresse}/{NumeroPoste}", method = RequestMethod.POST)
    public ResponseEntity<PosteControle> addPosteControle(@PathVariable String Adresse, @PathVariable String NumeroPoste) {
        logger.info("add a PosteControle");
        PosteControle posteControle=new PosteControle();
        posteControle.setAdresse(Adresse);
        posteControle.setNumeroPoste(NumeroPoste);



        PosteControle responsePosteControle=posteControleServiceImpl.save(posteControle);

        if(responsePosteControle==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/id/{id}").
                buildAndExpand(responsePosteControle.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
