package fr.aubin.opiyou.service;

import fr.aubin.opiyou.dao.CommercialDAO;
import fr.aubin.opiyou.domain.Commercial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CommercialService {
    final Logger LOGGER = LoggerFactory.getLogger(CommercialService.class);
    CommercialDAO dao = new CommercialDAO();
    ArrayList<Commercial> commercials = new ArrayList<>();

    public ArrayList<Commercial> getAllCommercials(){
        commercials = dao.getAllCommercials();
        return commercials;
    }
}
