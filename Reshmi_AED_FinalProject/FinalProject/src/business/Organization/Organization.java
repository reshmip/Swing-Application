/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Person.PersonDirectory;
import business.Role.Role;
import business.UserAccount.UserAccountDirectory;
import business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public abstract class Organization {
    private String orgName;
    private int orgID;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccDir;
    private PersonDirectory personDir;
    //private PatientDirectory patientDir;
    private static int count=0;
    
    public enum OrganizationType{
        HOSPITAL_ADMIN_ORG("Hospital Admin Organization"),
        HOSPITAL_DOCTOR_ORG("Hospital Doctor Organization"),
        HOUSEHOLD_ORG("Household Organization"),
        DISTRICT_MONITORING_ORG("District Monitoring Organization"),
        ENERGY_RESOUCE_ORG("Energy Resource Organization"),
        GREEN_GAS_TRACKING_ORG("Green Gas Tracking Organization"),
        POLLUTION_BOARD_ORG("Pollution Control Board Organization");
        
        private String value;
        private OrganizationType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name){
        this.orgName = name;
        workQueue = new WorkQueue();
        userAccDir = new UserAccountDirectory();
        personDir = new PersonDirectory();
        //patientDir = new PatientDirectory();
        count++;
        orgID = count;
    }
    
    public abstract ArrayList<Role> getSupportedRole();

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public UserAccountDirectory getUserAccDir() {
        return userAccDir;
    }

    public void setUserAccDir(UserAccountDirectory userAccDir) {
        this.userAccDir = userAccDir;
    }

    public PersonDirectory getPersonDir() {
        return personDir;
    }

    public void setPersonDir(PersonDirectory personDir) {
        this.personDir = personDir;
    }

//    public PatientDirectory getPatientDir() {
//        return patientDir;
//    }
//
//    public void setPatientDir(PatientDirectory patientDir) {
//        this.patientDir = patientDir;
//    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Organization.count = count;
    }

    @Override
    public String toString() {
        return orgName;
    }
   
}
