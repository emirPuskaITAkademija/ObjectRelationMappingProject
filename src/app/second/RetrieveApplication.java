package app.second;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Retrieve.
 * <p>
 * get -> ispaliti exception i obavijestiti kroz exception da ne postji
 * <li>
 * load -> vrati null ako Actor sa tim ID ne postoji
 *
 * @author Grupa2
 */
public class RetrieveApplication {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Actor actor = (Actor) session.get(Actor.class, 203);
            session.getTransaction().commit();
            System.out.println(actor);
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
