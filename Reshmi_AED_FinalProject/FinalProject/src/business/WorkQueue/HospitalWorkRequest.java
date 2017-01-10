/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

import business.vitalSignSensor.VitalSign;
import java.util.Date;

/**
 *
 * @author Reshmi
 */
public class HospitalWorkRequest extends WorkRequest{
    
    private String alert;
    private VitalSign recordDate;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public VitalSign getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(VitalSign recordDate) {
        this.recordDate = recordDate;
    }
    
    
}
