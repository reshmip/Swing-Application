/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Enterprise;

import business.Organization.Organization;
import business.Organization.OrganizationDirectory;

/**
 *
 * @author Reshmi
 */
public abstract class Enterprise extends Organization{
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationList;
    
    public Enterprise(String name,EnterpriseType type){
        super(name);
        this.enterpriseType = type;
        organizationList = new OrganizationDirectory();
    }
    
    public enum EnterpriseType{
        COMMUNITY("Community"),
        POLLUTION("Pollution Board");
        private String value;
        
        private EnterpriseType(String value){
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

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationList() {
        return organizationList;
    }
    
}
