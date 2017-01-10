/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.EcoDistrict;
import business.Enterprise.Enterprise;
import business.Neighborhood.Neighborhood;
import javax.swing.JPanel;
import business.Organization.Organization;
import business.UserAccount.UserAccount;

/**
 *
 * @author Reshmi
 */
public abstract class Role {
    public enum RoleType{
        DISTRICT_MONITORING_SUPERVISOR("District Monitoring Supervisor"),
        POLLUTION_BOARD_SUPERVISOR("Pollution Board Supervisor"),
        ENERGY_SOURCE_DEPT_SUPERVISOR("Energy Source Dept Supervisor"),
        COMMUNITY_MEMBER("Community Member"),
        HOSPITAL_ADMIN("Hospital Admin");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    public abstract JPanel createWorkArea(JPanel container,UserAccount account,
            Organization org,Enterprise ent,EcoDistrict eco,Neighborhood areas);
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
