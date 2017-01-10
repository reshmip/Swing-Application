/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.GreenGasEmissionsTracker;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class GreenGasTrackingOrg extends Organization{

    public GreenGasTrackingOrg() {
        super(OrganizationType.GREEN_GAS_TRACKING_ORG.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GreenGasEmissionsTracker());
        return roles;
    }  
}
