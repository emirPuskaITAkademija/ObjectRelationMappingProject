package app.three;

import app.second.Actor;
import app.second.HibernateUtil;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Dvije metode:
 * <li> 1. LOAD -> Hibernate -> exception
 * <li> 2. GET -> Hibernate -> null
 *
 * @author Grupa2
 */
public class HibernateLoader {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            //SQL: UPDATE ......
            //Hibernate: update
            Actor actor = (Actor) session.get(Actor.class, 203);
            System.out.println(actor);
            session.getTransaction().commit();
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
