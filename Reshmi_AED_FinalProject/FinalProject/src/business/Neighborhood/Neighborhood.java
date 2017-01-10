/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Neighborhood;

import business.Enterprise.EnterpriseDirectory;
import business.Organization.Organization;
import business.PollutionSensors.PollutionSensorList;
import business.Role.DistrictAdmin;
import business.Role.NeighborhoodAdmin;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class Neighborhood extends Organization{
    private String neighborhoodName;
    private EnterpriseDirectory enterpriseList;
    private PollutionSensorList pollutionSensorList;
    
    public Neighborhood(){
        super(null);
        enterpriseList = new EnterpriseDirectory();
        pollutionSensorList = new PollutionSensorList();
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public EnterpriseDirectory getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(EnterpriseDirectory enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public PollutionSensorList getPollutionSensorList() {
        return pollutionSensorList;
    }

    public void setPollutionSensorList(PollutionSensorList pollutionSensorList) {
        this.pollutionSensorList = pollutionSensorList;
    }

    
    @Override
    public String toString() {
        return neighborhoodName;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new NeighborhoodAdmin());
        return roleList; 
    }
   
}
