package fr.aubin.opiyou.app;


import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domain.Youtuber;
import fr.aubin.opiyou.service.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args){

        Youtuber youtuber = new Youtuber(1, "Bobby", "Teddy", "gussdxvideo", "GussDX", 0, "test", "test", "https://www.youtube.com/user/gussdxvideo");
        YoutuberDAO maDao = new YoutuberDAO();
        maDao.createYoutuber(youtuber);
        maDao.setSubsYoutuber(youtuber);
    }
}
