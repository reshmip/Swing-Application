/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory(){
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if(type == Enterprise.EnterpriseType.COMMUNITY){
            enterprise = new CommunityEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if(type == Enterprise.EnterpriseType.POLLUTION){
            enterprise = new PollutionBoard(name);
            enterpriseList.add(enterprise);
        }
//        else if(type.getValue().equals(Enterprise.EnterpriseType.ENERGY)){
//            enterprise = new EnergySourceBoardEnterprise(name);
//            enterpriseList.add(enterprise);
//        }
//        else if(type.getValue().equals(Enterprise.EnterpriseType.POLLUTION)){
//            enterprise = new PollutionControlBoardEnterprise(name);
//            enterpriseList.add(enterprise);
//        }
//        else if(type.getValue().equals(Enterprise.EnterpriseType.HOSPITAL)){
//            enterprise = new HospitalEnterprise(name);
//            enterpriseList.add(enterprise);
//        }
        return enterprise;
    }
}
