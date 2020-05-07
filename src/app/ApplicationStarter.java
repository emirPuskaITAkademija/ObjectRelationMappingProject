package app;

import app.first.PersistenceStrategy;
import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.dao.json.JSONDataAccessObject;
import app.first.dao.sql.MySQLDataAccessObject;
import app.first.model.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationStarter {

    public static void main(String[] args) throws DaoException {
        DataAccessObject dao = new MySQLDataAccessObject();
        //new JSONDataAccessObject();
        //new XMLDataAccessObject();
        //new SerializableDataAccessObject();
        //new FileDataAccessObject();
        PersistenceStrategy persistenceStrategy = new PersistenceStrategy(dao);
        /*
        TRAJNO SAČUVATI OBJEKAT koji NOSI PODATKE O VAMA
        persons-> person1, person2
         */
        List<Person> transientPersonList = new ArrayList<>(Arrays.asList(
                new Person("12323", "Amar", "Hodžić", 30),
                new Person("22323", "Ferida", "Bobar", 13),
                new Person("14323", "Kanita", "Muzaferija", 3),
                new Person("30323", "Rijad", "Dautović", 3),
                new Person("34323", "Fadil", "Toskić", 13),
                new Person("14323", "Said", "Hodžić", 30),
                new Person("14523", "Amar", "Topčić", 30),
                new Person("12323", "Mirzad", "Hodžić", 33),
                new Person("14423", "Amar", "Hodžić", 30),
                new Person("126623", "Said", "Rašinlić", 30),
                new Person("1253", "Rijad", "Rogo", 30),
                new Person("125334", "Kemal", "Abdić", 30)
        ));
        persistenceStrategy.writePersons(transientPersonList);
        /*
        ČITAMO SNIMLJENE PODATKE
         */
        for (Person person : persistenceStrategy.readPersons()) {
            System.out.println(person);
        }
    }
}
