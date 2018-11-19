import org.hibernate.Session;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import fr.aubin.opiyou.dao.HibernateUtil;
import fr.aubin.opiyou.domain.Youtuber;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.BasicConfigurator;

import javax.imageio.spi.ServiceRegistry;

public class HibernateTest {

    final static Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
    @Test
    public void testingHibernate(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Youtuber youtuberTest = new Youtuber ("Bobby","Dylan","dybo fait le fou","test","test", "https://www.youtube.com/channel/UCOdKaYgvLlPuinUJ1z5Gm2g");
        session.save(youtuberTest);

        session.getTransaction().commit();
        LOGGER.info("everything ok for : " + youtuberTest.getFirstnameYoutuber());
    }
}
