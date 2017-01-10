/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Organization.Organization.OrganizationType;
import business.Role.GreenGasEmissionsTracker;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory(){
        organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createAndAddOrg(OrganizationType type){
        Organization org = null;
        if(type.getValue().equals(OrganizationType.HOSPITAL_ADMIN_ORG.getValue())){
            org = new HospitalAdminOrg();
            organizationList.add(org);
        }
        else if(type.getValue().equals(OrganizationType.HOSPITAL_DOCTOR_ORG.getValue())){
            org = new HospitalDoctorOrg();
            organizationList.add(org);
        }
        else if(type.getValue().equals(OrganizationType.HOUSEHOLD_ORG.getValue())){
            org = new HouseholdOrg();
            organizationList.add(org);
        }
        else if(type.getValue().equals(OrganizationType.DISTRICT_MONITORING_ORG.getValue())){
            org = new DistrictAdminOrg();
            organizationList.add(org);
        }
        else if(type.getValue().equals(OrganizationType.ENERGY_RESOUCE_ORG.getValue())){
            org = new EnergyResourceOrg();
            organizationList.add(org);
        }
        else if(type.getValue().equals(OrganizationType.POLLUTION_BOARD_ORG.getValue())){
            org = new PollutionBoardOrg();
            organizationList.add(org);
        }
        else if(type.getValue().equals(OrganizationType.GREEN_GAS_TRACKING_ORG.getValue())){
            org = new GreenGasTrackingOrg();
            organizationList.add(org);
        }
        return org;
    }
}
