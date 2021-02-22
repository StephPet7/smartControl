package com.example.backend.Controller;


import com.example.backend.Entity.Transporteur;
import com.example.backend.Services.ServicesImpl.TransporteurServiceImpl;
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

@Api(description="Api management Transporteur")
@RestController
@RequestMapping("/api/Transporteur/")
public class TransporteurController {

    private static final Logger logger = LoggerFactory.getLogger(TransporteurController.class);
    @Autowired
    TransporteurServiceImpl transporteurServiceImpl;


    @ApiOperation(value="find Transporteur by id")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Transporteur findTransporteurById(@PathVariable Long id) {
        logger.info("find transporteur by id");
        return transporteurServiceImpl.findById(id);
    }

    @ApiOperation(value="delete Transporteur by id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete transporteur by id");
        transporteurServiceImpl.delete(id);
    }

    @ApiOperation(value="get all Transporteur")
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Transporteur> findAllTransporteur() {
        logger.info("find all transporteur");
        return transporteurServiceImpl.findAll();
    }

    @ApiOperation(value="update a Transporteur")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Transporteur updateTransporteur(@RequestBody Transporteur transporteur) {
        logger.info("update a transporteur");
        return transporteurServiceImpl.update(transporteur);
    }

    @ApiOperation(value="add a Transporteur")
    @RequestMapping(value = "/{Vignette}/{datePoliceAssurance}/{dateVisiteTechnique}/{dateCarteBleue}/{datePatente}" +
            "/{impotStationnement}", method = RequestMethod.POST)
    public ResponseEntity<Transporteur> addTransporteur(@PathVariable Date datePoliceAssurance,@PathVariable
            Date dateVisiteTechnique,@PathVariable Date dateCarteBleue,@PathVariable Date datePatente,
            @PathVariable boolean impotStationnement, @PathVariable boolean Vignette) {
        logger.info("add a Transporteur");
        Transporteur transporteur=new Transporteur();
        transporteur.setDateVisiteTechnique(dateVisiteTechnique);
        transporteur.setDatePoliceAssurance(datePoliceAssurance);
        transporteur.setVignette(Vignette);
        transporteur.setDateCarteBleue(dateCarteBleue);
        transporteur.setDatePatente(datePatente);
        transporteur.setImpotStationnement(impotStationnement);


        Transporteur responseTransporteur=transporteurServiceImpl.save(transporteur);

        if(responseTransporteur==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/id/{id}").
                buildAndExpand(responseTransporteur.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
