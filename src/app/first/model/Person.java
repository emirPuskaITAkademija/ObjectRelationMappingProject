package app.first.model;

import java.io.Serializable;
/**
 * JavaBean klasa/
 * <p>
 * @author Grupa2
 */
public class Person implements Serializable {

    private String nationalIdentificationNumber;
    private String name;//transient
    private String surname;
    private int age;

    public Person() {
    }

    public Person(String nationalIdentificationNumber, String name, String surname, int age) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "  " + surname + " nin: " + nationalIdentificationNumber + ", age = " + age;
    }
}
