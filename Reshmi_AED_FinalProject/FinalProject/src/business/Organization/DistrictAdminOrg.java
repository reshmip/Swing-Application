/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.NeighborhoodAdmin;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class DistrictAdminOrg extends Organization{

    public DistrictAdminOrg() {
        super(OrganizationType.DISTRICT_MONITORING_ORG.getValue());
    }
   
    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new NeighborhoodAdmin());
        return roles;
    }
}
