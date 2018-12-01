package fr.aubin.opiyou.app;

import fr.aubin.opiyou.dao.YoutuberDAO;
import fr.aubin.opiyou.domain.Youtuber;
import fr.aubin.opiyou.service.Channels;
import fr.aubin.opiyou.service.YoutuberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class Register extends HttpServlet{
    private static final long serialVersionUID = 1L;

    final Logger LOGGER = LoggerFactory.getLogger(Register.class);

    public Register() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        register(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        register(request, response);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        YoutuberService serviceYT = new YoutuberService();
        byte[] salt = null;
        try{
            salt = serviceYT.getSalt();
        }catch (NoSuchAlgorithmException e){
            LOGGER.error("Register failed : ", e);
        }

        String nameYT = request.getParameter("nameYoutuber");
        String firstNameYT = request.getParameter("firstNameYoutuber");
        String usernameYoutube = request.getParameter("usernameYoutube");
        String channelName = request.getParameter("channelName");
        String loginYT = request.getParameter("loginYT");
        String passYT = serviceYT.encryptSHA256Password(request.getParameter("passYT"), salt);
        Channels channels = new Channels();

        RequestDispatcher dispatcher;
        long sub = channels.getSubsCount(usernameYoutube);
        String link = channels.generateChannelLink(usernameYoutube);
        Youtuber newYoutuber = new Youtuber(nameYT, firstNameYT, usernameYoutube, channelName, sub, loginYT, passYT, link);


        HttpSession session = request.getSession();
        session.setAttribute("nameYT", firstNameYT);
        if (newYoutuber != null){
            serviceYT.newYoutuber(newYoutuber);
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }else{
            dispatcher = request.getRequestDispatcher("<error>");
            dispatcher.forward(request, response);
        }




    }
}
