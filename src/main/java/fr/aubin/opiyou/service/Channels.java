package fr.aubin.opiyou.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import fr.aubin.opiyou.dao.ConnexionBDD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Channels {

    final Logger LOGGER = LoggerFactory.getLogger(Channels.class);

    public long getSubsCount(String username) {
        long subs=0;
        HttpRequestInitializer httpRequestInitializer = new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {
            }
        };
        YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), httpRequestInitializer).setApplicationName("Opiyou").build();
        try {
            YouTube.Channels.List search = youtube.channels().list("statistics");
            search.setForUsername(username);
            search.setKey("AIzaSyBH5cpvnKUmCysF2zVuFnV2dL47saO8bo4");
            ChannelListResponse response = search.execute();
            List<Channel> channels = response.getItems();
            for (Channel channel : channels) {
                subs = channel.getStatistics().getSubscriberCount().longValue();
            }
        }catch (Exception e) {
            LOGGER.error("Error subscount", e);
        }

        return subs;
    }
}
