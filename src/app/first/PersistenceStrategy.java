package app.first;

import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.model.Person;
import java.util.List;
/**
 * 
 * @author Grupa2
 */
public class PersistenceStrategy {
    //composition - Depend upon abstraction not upon concrete implementation
    private DataAccessObject dao;

    public PersistenceStrategy(DataAccessObject dao) {
        this.dao = dao;
    }

    public void setDao(DataAccessObject dao) {
        this.dao = dao;
    }
    
    public void writePersons(List<Person> persons) throws DaoException{
        dao.writePersons(persons);
    }
    
    public List<Person> readPersons() throws DaoException{
        return dao.readPersons();
    }
}
