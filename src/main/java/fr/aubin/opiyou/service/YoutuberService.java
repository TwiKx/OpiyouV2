package fr.aubin.opiyou.service;

import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domain.Youtuber;

public class YoutuberService {

    YoutuberDAO maDao = new YoutuberDAO();

    public Youtuber checkUser(String user, String pass){
        Youtuber tempYt = maDao.checkConnect(user, pass);
        return tempYt;
    }
}
