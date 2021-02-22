package com.example.backend.Controller;

import com.example.backend.Entity.CarteGrise;
import com.example.backend.Services.ServicesImpl.CarteGriseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@Api(description ="Api management CarteGrise")
@RestController
@RequestMapping("/api/CarteGrise/")
public class CarteGriseController {

    private static final Logger logger = LoggerFactory.getLogger(CarteGriseController.class);
    @Autowired
    CarteGriseServiceImpl carteGriseServiceImpl;


    @ApiOperation(value="find CarteGrise by id")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public CarteGrise findCarteGriseById(@PathVariable Long id) {
        logger.info("find carteGrise by id");
        return carteGriseServiceImpl.findById(id);
    }

    @ApiOperation(value="delete CarteGrise by id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete carteGrise by id");
        carteGriseServiceImpl.delete(id);
    }

    @ApiOperation(value="get all CarteGrise")
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<CarteGrise> findAllCarteGrise() {
        logger.info("find all carteGrise");
        return carteGriseServiceImpl.findAll();
    }

    @ApiOperation(value="update a CarteGrise")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CarteGrise updateCarteGrise(@RequestBody CarteGrise carteGrise) {
        logger.info("update a carteGrise");
        return carteGriseServiceImpl.update(carteGrise);
    }

    @ApiOperation(value="add a CarteGrise")
    @RequestMapping(value = "/{NomProprietaire}/{Immatriculation}/{DateAcquisition}/{DateExpiration}"
            +"/{NumeroChassis}/{Adresse}", method = RequestMethod.POST)
    public ResponseEntity<CarteGrise> addCarteGrise(@PathVariable String NomProprietaire, @PathVariable String Immatriculation,
                                                    @PathVariable Date DateAcquisition, @PathVariable Date DateExpiration,
                                                    @PathVariable String NumeroChassis, @PathVariable  String Adresse) {
        logger.info("add a CarteGrise");
        CarteGrise carteGrise=new CarteGrise();
        carteGrise.setNomProprietaire(NomProprietaire);
        carteGrise.setImmatriculation(Immatriculation);
        carteGrise.setDateAcquisition(DateAcquisition);
        carteGrise.setDateExpiration(DateExpiration);
        carteGrise.setNumeroChassis(NumeroChassis);
        carteGrise.setAdresse(Adresse);

        CarteGrise responseCarteGrise=carteGriseServiceImpl.save(carteGrise);

        if(responseCarteGrise==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/id/{id}").
                buildAndExpand(responseCarteGrise.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}

