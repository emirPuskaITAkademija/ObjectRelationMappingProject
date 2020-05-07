package app.three;

import app.second.Actor;
import app.second.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 * <ol> CRUD
 * <li> Create -> insert -> obrađeno
 * <li> Retrieve -> obrađeno
 * <li> Update -> obrađeno
 * <li> Delete -> obrađeno
 * @author Grupa2
 */
public class HibernateApplicationTest {

    public static void main(String[] args) {
        //HibernateUtil
        try {
            //ORM - >Hibernate
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            //transakcionalnost
            session.getTransaction().begin();
            //SQL SELECT *FROM actor-> HQL case sensitive : from Actor
            //SQL: SELECT *FROM actor a WHERE a.firstName like 'Ju%'
            //HQL: from Actor a where a.firstName like 'Ju%'
            Query query = session.createQuery("from Actor a where a.firstName like 'Ju%'");
            session.getTransaction().commit();
            List<Actor> actors = query.list();
            for(Actor actor : actors){
                System.out.println(actor);
            }
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
