package fr.aubin.opiyou.dao;

import fr.aubin.opiyou.domain.Commercial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommercialDAO {

    final static Logger LOGGER = LoggerFactory.getLogger(CommercialDAO.class);

    ConnexionBDD connexionBDD = new ConnexionBDD();
    Commercial tempCommercial = null;
    ArrayList<Commercial> commercials = new ArrayList<>();

    public void createCommercial(Commercial commercial){
        String query = "INSERT INTO commercial (commercialName, corporateName, commercialDescription, commercialRemuneration, commercialMinSubs) VALUES ('"+commercial.getCommercialName()+"','"+commercial.getCorporateName()+"','"+commercial.getCommercialDescription()+"','"+commercial.getCommercialRemuneration()+"','"+commercial.getMinSubs()+"')";
        connexionBDD.connectDB();
        connexionBDD.updateData(query);
        connexionBDD.closeConnection();
    }

    public Commercial readCommercialById(int idCommercial){
        String query = "SELECT * FROM commercial WHERE idCommercial="+idCommercial;
        connexionBDD.connectDB();
        ResultSet rs = connexionBDD.executeRequete(query);
        try{
            while (rs.next()){
                String commercialName = rs.getString("commercialName");
                String corporateName = rs.getString("corporateName");
                String commercialDescription = rs.getString("commercialDescription");
                double commercialRemuneration = rs.getDouble("commercialRemuneration");
                long commercialMinSubs = rs.getLong("commercialMinSubs");

                tempCommercial = new Commercial(idCommercial,commercialName,corporateName,commercialDescription,commercialRemuneration,commercialMinSubs);
            }
        }catch (SQLException e){
            LOGGER.error("Error while reading commercials by ID : ", e);
        }
        return tempCommercial;
    }

    public ArrayList<Commercial> getAllCommercials(){
        String query = "SELECT * FROM commercial";
        connexionBDD.connectDB();
        ResultSet rs = connexionBDD.executeRequete(query);
        try{
            while (rs.next()){
                int idCommercial = rs.getInt("idCommercial");
                String commercialName = rs.getString("commercialName");
                String corporateName = rs.getString("corporateName");
                String commercialDescription = rs.getString("commercialDescription");
                double commercialRemuneration = rs.getDouble("commercialRemuneration");
                long commercialMinSubs = rs.getLong("commercialMinSubs");

                tempCommercial = new Commercial(idCommercial,commercialName,corporateName,commercialDescription,commercialRemuneration,commercialMinSubs);
                commercials.add(tempCommercial);
            }
        }catch (SQLException e){
            LOGGER.error("Error while getting all commercials : ", e);
        }

        return commercials;
    }
}
