/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoDistrict;
import business.Enterprise.Enterprise;
import business.Neighborhood.Neighborhood;
import business.Organization.HouseholdOrg;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.CommunityMemberRole.CommunityMemberWorkAreaJPanel;

/**
 *
 * @author Reshmi
 */
public class CommunityMember extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, UserAccount account, Organization org, Enterprise ent, EcoDistrict eco,Neighborhood areas) {
        return new CommunityMemberWorkAreaJPanel(container, account, ent, org);
    }
    
}
