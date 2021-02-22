package com.example.backend.Controller;

import com.example.backend.Entity.Sanction;
import com.example.backend.Services.ServicesImpl.SanctionServiceImpl;
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


@Api(description ="Api management Sanction")
@RestController
@RequestMapping("/api/Sanction/")
public class SanctionController {

    private static final Logger logger = LoggerFactory.getLogger(SanctionController.class);
    @Autowired
    SanctionServiceImpl sanctionServiceImpl;


    @ApiOperation(value="find Sanction by id")
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Sanction findSanctionById(@PathVariable Long id) {
        logger.info("find sanction by id");
        return sanctionServiceImpl.findById(id);
    }

    @ApiOperation(value="delete Sanction by id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete sanction by id");
        sanctionServiceImpl.delete(id);
    }

    @ApiOperation(value="get all Sanction")
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Sanction> findAllSanction() {
        logger.info("find all sanction");
        return sanctionServiceImpl.findAll();
    }

    @ApiOperation(value="update a Sanction")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Sanction updateSanction(@RequestBody Sanction sanction) {
        logger.info("update a sanction");
        return sanctionServiceImpl.update(sanction);
    }

    @ApiOperation(value="add a Sanction")
    @RequestMapping(value = "/{Description}/{Penalite}", method = RequestMethod.POST)
    public ResponseEntity<Sanction> addSanction(@PathVariable String Description,@PathVariable String Penalite) {
        logger.info("add a Sanction");
        Sanction sanction=new Sanction();
        sanction.setDescription(Description);
        sanction.setPenalite(Penalite);
        


        Sanction responseSanction=sanctionServiceImpl.save(sanction);

        if(responseSanction==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/id/{id}").
                buildAndExpand(responseSanction.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}

