package com.example.backend.Services.ServicesI;

import com.example.backend.Entity.Transporteur;

import java.util.Date;
import java.util.List;

public interface TransporteurServiceI extends DefaultServices<Transporteur,Long> {
    public List<Transporteur> findAllDateCarteBleueBetween(Date dateStart, Date dateEnd);
    public List<Transporteur> findAllDatePatenteBetween(Date dateStart, Date dateEnd);
}
