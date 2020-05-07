package app.three;

import app.second.Actor;
import app.second.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Grupa2
 */
public class HibernateDeletetion {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            //SQL: SELECT *FROM Actor a WHERE a.id = ? 
            //Hibernate: load -> session.get(Actor.class, 212);
            Actor actor = (Actor) session.get(Actor.class, 205);
            session.delete(actor);
            session.getTransaction().commit();
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
