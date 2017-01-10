/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class PersonDirectory {
    private ArrayList<Person> personDir;
    public PersonDirectory(){
        personDir = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonDir() {
        return personDir;
    }
    
    public Person addPerson(String name){
        Person person = new Person();
        person.setPersonName(name);
        personDir.add(person);
        return person;
    }
}
