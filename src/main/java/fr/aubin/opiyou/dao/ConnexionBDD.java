package fr.aubin.opiyou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnexionBDD {
    private String url;
    private String login;
    private String pass;
    private Connection connect = null;
    private Statement st = null;
    private String request;

    final Logger LOGGER = LoggerFactory.getLogger(ConnexionBDD.class);

    //Constructeurs
    /**
     * @param url
     * @param login
     * @param pass
     * @param connect
     * @param st
     * @param laRequete
     */
    /**
     * Constructeur de niveau 1 permettant de modifier les paramètres de connexion
     */
    public ConnexionBDD(String url, String login, String pass, Connection connect, Statement st, String request) {
        super();
        this.url = url;
        this.login = login;
        this.pass = pass;
        this.connect = connect;
        this.st = st;
        this.request = request;
    }

    /**
     * Surcharge de constructeur permettant une initialisation basique des paramètres de connexion
     */
    public ConnexionBDD() {
        super();
        this.url = "jdbc:mysql://localhost/opiyou?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.login = "root";
        this.pass = "";
        this.connect = null;
        this.st = null;
        this.request = "";
    }


    /**
     * Méthode de connection à la base de donnée
     */
    public void connectDB() {
        try {
            // Charger le driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Récupérer la connection dans mon objet de type Connection
            connect = DriverManager.getConnection(this.url, this.login, this.pass);

            // Préparer le statement et la requête
            this.st = connect.createStatement();

        } catch (SQLException e) {
            LOGGER.error("SQL error in method connectDB : ", e);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class not found error in method connectDB", e);
        }
    }


    /**
     * @param query
     */
    /**
     * Méthode permettant d'executer une requete, attention nécessite une connectio BDD ! (voir seConnecter)
     */
    public ResultSet executeRequete(String query) {
        this.request = query;
        ResultSet rs = null;
        try {
            rs = this.st.executeQuery(request);
        } catch (SQLException e) {
            LOGGER.error("SQL error in method connectDB : ", e);
        }
        return rs;
    }

    /**
     * @param query
     */
    /**
     * Methode permettant de mettre à jour les données en BDD, attention nécessite une connectio BDD ! (voir seConnecter)
     */
    public void updateData(String query) {
        this.request = query;
        try {
            this.st.executeUpdate(request);
        } catch (SQLException e) {
            LOGGER.error("SQL error in method connectDB : ", e);
        }
    }

    /**
     * Méthode permettant de fermer la connection active et donc libérer de la mémoire
     */
    public void closeConnection() {
        try {
            // libérer la mémoire
            connect.close();
            st.close();
        } catch (SQLException e) {
            LOGGER.error("SQL error in method connectDB : ", e);
        }
    }
}
