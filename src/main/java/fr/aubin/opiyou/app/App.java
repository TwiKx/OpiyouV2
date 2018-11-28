package fr.aubin.opiyou.app;


import fr.aubin.opiyou.domain.Youtuber;
import fr.aubin.opiyou.service.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    final static Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args){

        Channels channel = new Channels();
        Long test;
        test = channel.getSubsCount("gussdxvideo");

        System.out.print("nbr abos : " + test.toString());
    }
}
