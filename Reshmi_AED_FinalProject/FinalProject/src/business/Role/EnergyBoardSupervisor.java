/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoDistrict;
import business.Enterprise.Enterprise;
import business.Neighborhood.Neighborhood;
import business.Organization.EnergyResourceOrg;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.EnergySourceBoardSupervisor.EnergySourceBoardAdminWorkAreaJPanel;

/**
 *
 * @author Reshmi
 */
public class EnergyBoardSupervisor extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, UserAccount account, Organization org, Enterprise ent, EcoDistrict eco,Neighborhood areas) {
        return new EnergySourceBoardAdminWorkAreaJPanel(container, ent, (EnergyResourceOrg)org, account);
    }
    
}
