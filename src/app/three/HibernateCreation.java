package app.three;

import app.second.Actor;
import app.second.HibernateUtil;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Dvije metode:
 * <li> 1. SAVE -> Hibernate
 * <li> 2. PERSIST -> JPA
 *
 * @author Grupa2
 */
public class HibernateCreation {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            //SQL: INSERT INTO table (first, la) values()...
            //Hibernate: save -> session.save(actor);
            Actor actor = new Actor("Kanita", "Muzaferija", new Date());
            session.save(actor);
            session.getTransaction().commit();
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
