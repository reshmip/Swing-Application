/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Person;

import business.Sensors.SensorsCatalog;
import business.vitalSignSensor.VitalSignHistory;

/**
 *
 * @author Reshmi
 */
public class Person {
    private String personName;
    private int personId;
    private String address;
    private double phoneNumber;
    private String email;
    private static int count=1;
    private MemberDirectory memberDir;
    private SensorsCatalog sensorsList;
    private VitalSignHistory vitalSignList;
    
    public Person(){
        personId = count;
        count++;
        memberDir = new MemberDirectory();
        sensorsList = new SensorsCatalog();
        vitalSignList = new VitalSignHistory();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MemberDirectory getMemberDir() {
        return memberDir;
    }

    public void setMemberDir(MemberDirectory memberDir) {
        this.memberDir = memberDir;
    }

    public SensorsCatalog getSensorsList() {
        return sensorsList;
    }

    public void setSensorsList(SensorsCatalog sensorsList) {
        this.sensorsList = sensorsList;
    }

    public VitalSignHistory getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(VitalSignHistory vitalSignList) {
        this.vitalSignList = vitalSignList;
    }

    @Override
    public String toString() {
        return personName;
    }
    
    
}
