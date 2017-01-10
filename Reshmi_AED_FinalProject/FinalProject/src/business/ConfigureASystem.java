/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Person.Person;
import business.Role.DistrictAdmin;
import business.UserAccount.UserAccount;

/**
 *
 * @author Reshmi
 */
public class ConfigureASystem {
    public static EcoDistrict configure(){
        EcoDistrict district = EcoDistrict.getInstance();
        Person person = district.getPersonDir().addPerson("Mayor");
        UserAccount ua = district.getUserAccDir().createUserAccount("sysadmin", "sysadmin", person, new DistrictAdmin());
        return district;
    }
}
