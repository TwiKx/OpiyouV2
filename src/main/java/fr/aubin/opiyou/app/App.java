package fr.aubin.opiyou.app;


import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domain.Youtuber;
import fr.aubin.opiyou.service.Channels;
import fr.aubin.opiyou.service.YoutuberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;

public class App {
    final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args){

        YoutuberService test = new YoutuberService();
        String pass = "test";
        try {
            byte[] salt = test.getSalt();
            String securedPass = test.encryptSHA256Password(pass, salt);
            System.out.println(securedPass);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }



    }
}
