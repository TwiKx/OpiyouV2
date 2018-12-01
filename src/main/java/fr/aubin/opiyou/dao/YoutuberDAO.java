package fr.aubin.opiyou.dao;

import fr.aubin.opiyou.domain.Youtuber;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.aubin.opiyou.service.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YoutuberDAO {

    final static Logger LOGGER = LoggerFactory.getLogger(YoutuberDAO.class);

    ConnexionBDD connexion = new ConnexionBDD();
    Youtuber tempYT = null;
    ArrayList<Youtuber> listeYT = new ArrayList<Youtuber>();

    //CRUD
    public void createYoutuber(Youtuber myYoutuber) {
        //query
        String query = "INSERT INTO youtuber (nameYoutuber, firstnameYoutuber, usernameYoutube, channelNameYoutube, subscribersCountYoutube, loginYoutuber, pwdYoutuber, linkChannel) VALUES ('" + myYoutuber.getNameYoutuber() + "','" + myYoutuber.getFirstnameYoutuber() + "','" + myYoutuber.getUsernameYoutuber() + "','" + myYoutuber.getChannelNameYoutube() + "','" + myYoutuber.getSubscribersCount() + "','" + myYoutuber.getLoginYoutuber() + "','" + myYoutuber.getPwdYoutuber() + "','" + myYoutuber.getLinkChannel() + "')";
        connexion.connectDB();
        connexion.updateData(query);
        connexion.closeConnection();
    }

    public Youtuber readByIdYoutuber(int idYoutuber){
        String query = "SELECT * FROM youtuber WHERE idYoutuber="+idYoutuber;
        ResultSet resultSet = connexion.executeRequete(query);
        try{
            while (resultSet.next()){
                String name = resultSet.getString("nameYoutuber");
                String firstName = resultSet.getString("firstNameYotuber");
                String userName = resultSet.getString("usernameYoutube");
                String channel = resultSet.getString("channelNameYoutube");
                long subs = resultSet.getLong("subscribersCountYoutube");
                String login = resultSet.getString("loginYoutuber");
                String pwdYoutuber = resultSet.getString("pwdYoutuber");
                String linkChannel = resultSet.getString("linkChannel");

                tempYT = new Youtuber(idYoutuber, name, firstName, userName, channel, subs, login, pwdYoutuber, linkChannel);
            }
        } catch (SQLException e){
            LOGGER.error("Error while reading youtuber by ID, stacktrace : ", e);
        }

        connexion.closeConnection();

        return tempYT;
    }

    public ArrayList<Youtuber> getAll() {
        // créer la requete
        String requete = "SELECT * FROM youtuber";
        // créer le resultset et y mettre le résultat
        ResultSet rs = connexion.executeRequete(requete);
        // faire un try catch sur ça
        try {
            while (rs.next()) {
                int id = rs.getInt("idYoutuber");
                String name = rs.getString("nameYoutuber");
                String firstName = rs.getString("firstNameYoutuber");
                String username = rs.getString("usernameYoutube");
                String channelName = rs.getString("channelNameYoutube");
                long subsCount = rs.getLong("subscribersCountYoutube");
                String login = rs.getString("loginYoutuber");
                String pass = rs.getString("pwdYoutuber");
                String chanLink = rs.getString("linkChannel");
                // mettre ce résultat dans mon youtuber temporairee
                tempYT = new Youtuber(id, name, firstName, username, channelName, subsCount, login, pass,
                        chanLink);
                // et remplir l'arraylist
                listeYT.add(tempYT);
            }
        } catch (SQLException e) {
            LOGGER.error("Error while geting all youtuber, stacktrace : ", e);
        }
        // fermer la connection
        connexion.closeConnection();
        return listeYT;
    }

    public void deleteYoutuber(Youtuber myYoutuber) {
        // creer la requete
        String requete = "DELETE FROM youtuber WHERE idYoutuber = " + myYoutuber.getIdYoutuber();
        // executer la requete
        connexion.executeRequete(requete);
        // fermer la connection
        connexion.closeConnection();
    }

    // Method de check authentification
    public Youtuber checkConnect(String login, String password) {
        // creation de la requete
        String requete = "SELECT * FROM youtuber WHERE loginYoutuber='" + login + "' AND pwdYoutuber='" + password + "'";

        // se connecter à la base de donner
        connexion.connectDB();

        // executer la requete et mettre dans un resultset
        ResultSet rs = connexion.executeRequete(requete);

        try {
            while (rs.next()) {
                int id = rs.getInt("idYoutuber");
                String name = rs.getString("nameYoutuber");
                String firstName = rs.getString("firstNameYoutuber");
                String username = rs.getString("usernameYoutube");
                String channelName = rs.getString("channelNameYoutube");
                long subsCount = rs.getLong("subscribersCountYoutube");
                String loginYt = rs.getString("loginYoutuber");
                String pass = rs.getString("pwdYoutuber");
                String chanLink = rs.getString("linkChannel");
                // mettre ce résultat dans mon youtuber temporairee
                tempYT = new Youtuber(id, name, firstName, username, channelName, subsCount, loginYt, pass,
                        chanLink);
            }

        } catch (SQLException e) {
            LOGGER.error("Error connection : ", e);
        }

        return tempYT;
    }

    public void setSubsYoutuber(Youtuber youtuber){
        Channels channels = new Channels();
        String query = "UPDATE youtuber set subscribersCountYoutube = '" + youtuber.getSubscribersCount() + "' WHERE idYoutuber = '" + youtuber.getIdYoutuber() +"'";
        connexion.connectDB();
        connexion.updateData(query);
        connexion.closeConnection();

    }

    public int getYoutuberIDbyUsername(Youtuber youtuber){
        int id = 0;
        String query = "SELECT * FROM youtuber WHERE usernameYoutube = "+youtuber.getUsernameYoutuber();
        ResultSet resultSet = connexion.executeRequete(query);
        try{
            id = resultSet.getInt("idYoutuber");
        }catch (SQLException e){
            LOGGER.error("Error while reading Youtuber ID : ", e);
        }

        connexion.closeConnection();

        return id;
    }
}
