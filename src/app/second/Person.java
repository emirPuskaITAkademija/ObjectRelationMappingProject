/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.second;

/**
 *
 * @author Grupa2
 */
public class Person {

    static {
        System.out.println("Ja sam STATIČKI blok koda unutar klase Person");
    }

    {
        System.out.println("Ja sam NESTATIČKI blok koda");
    }

    public Person() {
        System.out.println("Ja generišem još jedan Person objekat..");
    }

}
