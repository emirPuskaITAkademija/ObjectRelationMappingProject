package app.first.dao.json;

import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.model.Person;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONDataAccessObject implements DataAccessObject {

    private static final String FILE_NAME = "persons.json";

    @Override
    public List<Person> readPersons() throws DaoException {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            JSONParser jSONParser = new JSONParser();
            JSONArray jSONArray = (JSONArray) jSONParser.parse(fileReader);
            List<Person> persons = new ArrayList<>();
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                Person person = new Person(jSONObject.get("nin").toString(),
                        jSONObject.get("name").toString(),
                        jSONObject.get("surname").toString(),
                        Integer.parseInt(jSONObject.get("age").toString()));
                persons.add(person);
            }
            return persons;
        } catch (Exception exception) {
            throw new DaoException(exception.getMessage());
        }
    }

    @Override
    public void writePersons(List<Person> persons) throws DaoException {
        if (persons == null || persons.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (Person person : persons) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nin", person.getNationalIdentificationNumber());
            jSONObject.put("name", person.getName());
            jSONObject.put("surname", person.getSurname());
            jSONObject.put("age", person.getAge());
            jSONArray.add(jSONObject);
        }
        String jsonString = jSONArray.toJSONString();//jsonString upisujemo u fajl
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write(jsonString);
        } catch (Exception exception) {
            throw new DaoException(exception.getMessage());
        }
    }
}
