package com.example.backend.Controller;

import com.example.backend.Entity.Voiture;
import com.example.backend.Services.ServicesImpl.VoitureServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Api(description="Api management Voiture")
@RestController
@RequestMapping("/api/Voiture/")
public class VoitureController {

    private static final Logger logger = LoggerFactory.getLogger(VoitureController.class);
    @Autowired
    VoitureServiceImpl voitureServiceImpl;


    @ApiOperation(value="find Voiture by id")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Voiture findVoitureById(@PathVariable Long id) {
        logger.info("find voiture by id");
        return voitureServiceImpl.findById(id);
    }

    @ApiOperation(value="delete Voiture by id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete voiture by id");
        voitureServiceImpl.delete(id);
    }

    @ApiOperation(value="get all Voiture")
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Voiture> findAllVoiture() {
        logger.info("find all voiture");
        return voitureServiceImpl.findAll();
    }

    @ApiOperation(value="update a Voiture")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Voiture updateVoiture(@RequestBody Voiture voiture) {
        logger.info("update a voiture");
        return voitureServiceImpl.update(voiture);
    }

    @ApiOperation(value="add a Voiture")
    @RequestMapping(value = "/{datePoliceAssurance}/{dateVisiteTechnique}/{Vignette}", method = RequestMethod.POST)
    public ResponseEntity<Voiture> addVoiture(@PathVariable Date datePoliceAssurance,@PathVariable
            Date dateVisiteTechnique, @PathVariable boolean Vignette) {
        logger.info("add a Voiture");
        Voiture voiture=new Voiture();
        voiture.setDateVisiteTechnique(dateVisiteTechnique);
        voiture.setDatePoliceAssurance(datePoliceAssurance);
        voiture.setVignette(Vignette);


        Voiture responseVoiture=voitureServiceImpl.save(voiture);

        if(responseVoiture==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/id/{id}").
                buildAndExpand(responseVoiture.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
