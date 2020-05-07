package app.second;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateApplication {
    public static void main(String[] args) {
        //HQL - Hibernate Query Language -> rad sa objektima
        //case sensitive
        try{
            //Otvaranje sesije -> HibernateUtil -> SESSION_FACTORY
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            //Izlistati sve glumce - potreban je query object
            //UPIT NAD BAZOM : select *from actor -> HQL prebaciti ovaj upit
            //PANDAN UPITU IZNAD : from Actor -> nad klasom u Javi 
            //
            Query query = session.createQuery("from Actor a where a.firstName like 'Pe%'");
            //potvrditi transkaciju 
            session.getTransaction().commit();
            //Izlistati sve Actor objekte
            List<Actor> result = query.list();
            for(Actor actor : result){
                System.out.println(actor);
            }
            //Problem sa Hibernate je što on i kada završi naša main funkcija i dalje radi
            System.exit(0);
        }catch(HibernateException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
