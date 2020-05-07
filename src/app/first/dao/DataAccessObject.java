package app.first.dao;

import app.first.model.Person;
import java.util.List;

/**
 * Programming to interface, not to concrete implementation classes
 * <p>
 *
 *
 * @author Grupa2
 */
public interface DataAccessObject {

    /**
     * Ova metoda treba da pročita trajno snimljene objekte tipa Person i da na
     * vrati listu učitanih objekata.
     * <p>
     * @return persons
     * @throws DaoException
     */
    public List<Person> readPersons() throws DaoException;

    /**
     * Ova metoda treba da snimi osobe koje je dobila kroz parametar persons.
     *
     * @param persons
     * @throws DaoException
     */
    public void writePersons(List<Person> persons) throws DaoException;
}
