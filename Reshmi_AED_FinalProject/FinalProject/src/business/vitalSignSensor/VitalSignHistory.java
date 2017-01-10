/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.vitalSignSensor;

import java.util.ArrayList;

/**
 *
 * @author Reshmi
 */
public class VitalSignHistory {
    private ArrayList<VitalSign> vitalSignList;
    
    public VitalSignHistory()
    {
        vitalSignList = new ArrayList<VitalSign>();
    }

    public ArrayList<VitalSign> getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(ArrayList<VitalSign> vitalSignList) {
        this.vitalSignList = vitalSignList;
    }
    
    public VitalSign createAndAddVitalSign(VitalSign vitalSign) {
        //VitalSign vitalSign = new VitalSign();
        vitalSignList.add(vitalSign);
        return vitalSign;
    }

    public void deleteVitalSign(VitalSign vitalSign) {
        vitalSignList.remove(vitalSign);
    }
    
    public String VitalSignStatus(int memberAge, VitalSign vitalSign) {
        String vitalSignStatus = "Normal";

        int respirationRate = vitalSign.getRespiratoryRate();
        int heartRate = vitalSign.getHeartRate();
        int bloodPressure = vitalSign.getBloodPressure();
        int temperature = vitalSign.getTemperature();
        int weight = vitalSign.getWeight();

        /*Toddler*/
        if (memberAge >= 1 && memberAge <= 3) {
            if ((respirationRate < 20 || respirationRate > 30) /*Respiration Rate*/
                    || (heartRate < 80 || heartRate > 130) /*Heart Rate*/
                    || (bloodPressure < 80 || bloodPressure > 110) /*Blood Pressure*/
                    || (temperature < 96 || temperature > 99)) /*Temperature*/ {
                vitalSignStatus = "Abnormal";
            }
        }
        /*Preschooler*/
        if (memberAge >= 4 && memberAge <= 5) {
            if ((respirationRate < 20 || respirationRate > 30)
                    || (heartRate < 80 || heartRate > 120)
                    || (bloodPressure < 80 || bloodPressure > 110)
                    || (temperature < 96 || temperature > 99)) {
                vitalSignStatus = "Abnormal";
            }
        }
        /*School Age*/
        if (memberAge >= 6 && memberAge <= 12) {
            if ((respirationRate < 20 || respirationRate > 30)
                    || (heartRate < 70 || heartRate > 110)
                    || (bloodPressure < 80 || bloodPressure > 110)
                    || (temperature < 96 || temperature > 99)) {
                vitalSignStatus = "Abnormal";
            }
        }
        /*Adolescent*/
        if (memberAge >= 13) {
            if ((respirationRate < 12 || respirationRate > 20)
                    || (heartRate < 55 || heartRate > 105)
                    || (bloodPressure < 110 || bloodPressure > 120)
                    || (temperature < 96 || temperature > 99)) {
                vitalSignStatus = "Abnormal";
            }
        }
        return vitalSignStatus;
    }
}
