/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.PollutionSensors.PollutionSensorList;
import business.Role.PollutionBoardSupervisor;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class PollutionBoardOrg extends Organization{


    public PollutionBoardOrg() {
        super(OrganizationType.POLLUTION_BOARD_ORG.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PollutionBoardSupervisor());
        return roles;
    }

}
