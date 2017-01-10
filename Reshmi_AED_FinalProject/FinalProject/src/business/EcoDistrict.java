/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Neighborhood.Neighborhood;
import business.Organization.Organization;
import business.Role.DistrictAdmin;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class EcoDistrict extends Organization{
    private static EcoDistrict district;
    private ArrayList<Neighborhood> neighborhoodList;
    
    public static EcoDistrict getInstance(){
        if(district == null){
            district = new EcoDistrict();
        }
        return district;
    }
    
    private EcoDistrict(){
        super(null);
        neighborhoodList = new ArrayList<Neighborhood>();
    }

    public ArrayList<Neighborhood> getNeighborhoodList() {
        return neighborhoodList;
    }

    public Neighborhood createAddNeighborhoods(){
        Neighborhood neighborhood = new Neighborhood();
        neighborhoodList.add(neighborhood);
        return neighborhood;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new DistrictAdmin());
        return roleList; 
    }
    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccDir().checkIfUserNameIsUnique(username)) {
            return false;
        }
        return true;
    }
}
