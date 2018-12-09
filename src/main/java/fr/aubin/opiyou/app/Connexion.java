package fr.aubin.opiyou.app;

import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domain.Commercial;
import fr.aubin.opiyou.domain.Youtuber;
import fr.aubin.opiyou.service.Channels;
import fr.aubin.opiyou.service.CommercialService;
import fr.aubin.opiyou.service.YoutuberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/connexion")
public class Connexion extends HttpServlet{

    final Logger LOGGER = LoggerFactory.getLogger(Register.class);

    private static final long serialVersionUID = 1L;

    public Connexion() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        connect(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        connect(request, response);
    }

    protected void connect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        YoutuberService serviceYT = new YoutuberService();

        String login = request.getParameter("loginuser");
        String pass = serviceYT.encryptSHA256Password(request.getParameter("passworduser"));

        RequestDispatcher dispatcher;
        Youtuber loggedYT = null;
        YoutuberDAO daoYT = new YoutuberDAO();

        loggedYT = serviceYT.checkUser(login, pass);
        HttpSession session = request.getSession();
        session.setAttribute("youtuber", loggedYT);

        if (loggedYT != null){
            session.setAttribute("youtuber", loggedYT);
            daoYT.setSubsYoutuber(loggedYT);
            CommercialService commercialService = new CommercialService();
            ArrayList<Commercial> commercials = commercialService.getAllCommercials();
            session.setAttribute("listCommercials", commercials);
            dispatcher = request.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(request, response);
        } else {
            dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }



    }
}
