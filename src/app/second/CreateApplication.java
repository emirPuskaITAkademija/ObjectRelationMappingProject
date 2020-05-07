package app.second;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * SAVE & PERSIST(JPA)
 * <p>
 * Save -> može ići van transakcije; vrati ID upisanog recorda
 * <li>
 * Persist -> mora ići unutar transakcije; ne vraća ništa jer se ona ne izvršava
 * sve dok se transakcija ne commit
 *
 * @author Grupa2
 */
public class CreateApplication {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Actor actor = new Actor("Mirzad", "Turalić", new Date());
            session.persist(actor);
            session.getTransaction().commit();
            System.out.println("Insertovan : " + actor.getActorId());
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
