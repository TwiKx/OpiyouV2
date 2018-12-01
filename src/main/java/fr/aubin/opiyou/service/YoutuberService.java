package fr.aubin.opiyou.service;

import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domain.Youtuber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class YoutuberService {

    final Logger LOGGER = LoggerFactory.getLogger(YoutuberService.class);

    YoutuberDAO maDao = new YoutuberDAO();

    public Youtuber checkUser(String user, String pass){
        Youtuber tempYt = maDao.checkConnect(user, pass);
        return tempYt;
    }

    public void newYoutuber(Youtuber youtuber){
        maDao.createYoutuber(youtuber);
    }

    public String encryptSHA256Password(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            LOGGER.error("Error while generating encrypted pass : ", e);
        }
        return generatedPassword;
    }

}
