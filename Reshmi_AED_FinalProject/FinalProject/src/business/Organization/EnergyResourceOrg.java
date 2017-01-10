/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.EnergyBoardSupervisor;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class EnergyResourceOrg extends Organization{

    public EnergyResourceOrg() {
        super(OrganizationType.ENERGY_RESOUCE_ORG.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EnergyBoardSupervisor());
        return roles;
    }
    
}
