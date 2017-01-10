/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.CommunityMember;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class HouseholdOrg extends Organization{

    public HouseholdOrg() {
        super(OrganizationType.HOUSEHOLD_ORG.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CommunityMember());
        return roles;
    }
    
}
