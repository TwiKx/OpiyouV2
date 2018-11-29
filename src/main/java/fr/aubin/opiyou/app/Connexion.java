package fr.aubin.opiyou.app;

import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domain.Youtuber;
import fr.aubin.opiyou.service.Channels;
import fr.aubin.opiyou.service.YoutuberService;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/connexion")
public class Connexion extends HttpServlet{
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

        String login = request.getParameter("loginuser");
        String pass = request.getParameter("passworduser");

        RequestDispatcher dispatcher;
        YoutuberService serviceYT = new YoutuberService();
        Youtuber loggedYT = null;
        YoutuberDAO daoYT = new YoutuberDAO();

        loggedYT = serviceYT.checkUser(login, pass);
        HttpSession session = request.getSession();

        if (loggedYT != null){
            session.setAttribute("youtuber", loggedYT);
            daoYT.setSubsYoutuber(loggedYT);
            dispatcher = request.getRequestDispatcher("<page-accueil>");
            dispatcher.forward(request, response);
        } else {
            dispatcher = request.getRequestDispatcher("<page-error>");
            dispatcher.forward(request, response);
        }



    }
}
